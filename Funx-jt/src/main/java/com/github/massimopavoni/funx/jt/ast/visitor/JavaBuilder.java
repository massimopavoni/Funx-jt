package com.github.massimopavoni.funx.jt.ast.visitor;

import com.github.massimopavoni.funx.jt.ast.node.ASTNode;
import com.github.massimopavoni.funx.jt.ast.node.Declaration;
import com.github.massimopavoni.funx.jt.ast.node.Expression;
import com.github.massimopavoni.funx.lib.FunxPrelude;
import com.github.massimopavoni.funx.lib.JavaPrelude;
import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Java code builder for the AST tree.
 */
public final class JavaBuilder extends ASTVisitor<Void> {
    /**
     * Java code string builder.
     */
    private final StringBuilder builder;
    /**
     * Java code formatter.
     */
    private final Formatter formatter;
    /**
     * List of currently in scope lambda parameters.
     */
    private final List<String> lambdaParams = new ArrayList<>();
    /**
     * Flag to indicate if the current declarations are at top level.
     */
    private boolean currentlyTopLevel = true;
    /**
     * Current declaration type, used for let expressions.
     */
    private TrashType currentDeclarationTrashType = null;

    /**
     * Constructor for the Java builder.
     *
     * @param builder Java code string builder
     */
    public JavaBuilder(StringBuilder builder) {
        this.builder = builder;
        formatter = new Formatter();
    }

    /**
     * Retrieve the built Java code after formatting it.
     *
     * @return Java code string
     * @throws FormatterException if there is an error while formatting code
     */
    public String getBuiltJava() throws FormatterException {
        return formatter.formatSource(builder.toString());
    }

    /**
     * Append a closing parenthesis to the Java code.
     */
    private void appendCloseParen() {
        builder.append(")");
    }

    /**
     * Append a closing brace and newline to the Java code.
     */
    private void appendCloseBrace() {
        builder.append("}");
        appendNewline();
    }

    /**
     * Append a newline to the Java code.
     */
    private void appendNewline() {
        builder.append("\n");
    }

    /**
     * Append a semicolon and newline to the Java code.
     */
    private void appendSemiColon() {
        builder.append(";");
        appendNewline();
    }

    /**
     * Visit a {@link ASTNode.Module} AST node.
     *
     * @param module module node
     * @return visitor result
     */
    @Override
    public Void visitModule(ASTNode.Module module) {
        builder.append(String.format("""
                        %1$s
                        
                        import %2$s;
                        
                        import static %3$s.*;
                        import static %4$s.*;
                        
                        public class %5$s {
                        private %5$s() {
                        // Private constructor to prevent instantiation
                        }
                        
                        """,
                module.packageName.isEmpty()
                        ? ""
                        : String.format("package %s;%n", module.packageName.toLowerCase()),
                Function.class.getName(),
                JavaPrelude.class.getName(),
                FunxPrelude.class.getName(),
                module.name));
        if (module.main != null)
            visit(module.main);
        visit(module.declarations);
        appendCloseBrace();
        return null;
    }

    /**
     * Visit a {@link ASTNode.Declarations} AST node.
     *
     * @param declarations declarations node
     * @return visitor result
     */
    @Override
    public Void visitDeclarations(ASTNode.Declarations declarations) {
        return visit(declarations.declarations);
    }

    /**
     * Visit the main {@link Declaration} AST node.
     *
     * @param main declaration node
     * @return visitor result
     */
    @Override
    public Void visitMain(Declaration main) {
        builder.append("""
                public static void main(String[] args) {
                System.out.println(""");
        visit(main.expression);
        appendCloseParen();
        appendSemiColon();
        appendCloseBrace();
        return null;
    }

    /**
     * Visit a {@link Declaration} AST node.
     *
     * @param declaration declaration node
     * @return visitor result
     */
    @Override
    public Void visitDeclaration(Declaration declaration) {
        builder.append(currentlyTopLevel ? "public static " : "private ");
        visit(declaration.type);
        builder.append(String.format("""
                 %s() {
                return\s""", declaration.id));
        currentDeclarationTrashType = (TrashType) declaration.type;
        visit(declaration.expression);
        appendSemiColon();
        appendCloseBrace();
        appendNewline();
        return null;
    }

    /**
     * Visit a {@link TrashType.NamedTrashType} AST node.
     *
     * @param type type node
     * @return visitor result
     */
    @Override
    public Void visitNamedType(TrashType.NamedTrashType type) {
        builder.append(type.type.typeClass.getSimpleName());
        return null;
    }

    /**
     * Visit a {@link TrashType.VariableTrashType} AST node.
     *
     * @param type type node
     * @return visitor result
     */
    @Override
    public Void visitVariableType(TrashType.VariableTrashType type) {
        throw new IllegalASTStateException("type variable not yet supported");
    }

    /**
     * Visit a {@link TrashType.ArrowTrashType} AST node.
     *
     * @param type type node
     * @return visitor result
     */
    @Override
    public Void visitArrowType(TrashType.ArrowTrashType type) {
        builder.append("Function<");
        visit(type.input);
        builder.append(", ");
        visit(type.output);
        builder.append(">");
        return null;
    }

    /**
     * Visit a {@link Expression.Lambda} AST node.
     *
     * @param lambda lambda node
     * @return visitor result
     */
    @Override
    public Void visitLambda(Expression.Lambda lambda) {
        lambdaParams.add(lambda.paramId);
        builder.append("(");
        builder.append(String.format("%s -> ", lambda.paramId));
        visit(lambda.expression);
        appendCloseParen();
        lambdaParams.clear();
        return null;
    }

    /**
     * Visit a {@link Expression.Let} AST node.
     *
     * @param let let node
     * @return visitor result
     */
    @Override
    public Void visitLet(Expression.Let let) {
        currentlyTopLevel = !currentlyTopLevel;
        builder.append(String.format("(new %s<>() {%n", JavaPrelude.Let.class.getSimpleName()));
        visit(let.localDeclarations);
        builder.append("""
                @Override
                public\s""");
        visit(currentDeclarationTrashType);
        builder.append("""
                 _eval() {
                return\s""");
        visit(let.expression);
        appendSemiColon();
        appendCloseBrace();
        builder.append("})._eval()");
        currentlyTopLevel = !currentlyTopLevel;
        return null;
    }

    /**
     * Visit a {@link Expression.If} AST node.
     *
     * @param ifE if node
     * @return visitor result
     */
    @Override
    public Void visitIf(Expression.If ifE) {
        builder.append("((");
        visit(ifE.condition);
        builder.append(") ? (");
        visit(ifE.thenBranch);
        builder.append(") : (");
        visit(ifE.elseBranch);
        builder.append("))");
        return null;
    }

    /**
     * Visit a {@link Expression.Application} AST node.
     *
     * @param application application node
     * @return visitor result
     */
    @Override
    public Void visitApplication(Expression.Application application) {
        visit(application.left);
        builder.append(".apply(");
        visit(application.right);
        builder.append(")");
        return null;
    }

    /**
     * Visit a {@link Expression.Constant} AST node.
     *
     * @param constant constant node
     * @return visitor result
     */
    @Override
    public Void visitConstant(Expression.Constant constant) {
        builder.append(constant.value);
        return null;
    }

    /**
     * Visit a {@link Expression.Variable} AST node.
     *
     * @param variable variable node
     * @return visitor result
     */
    @Override
    public Void visitVariable(Expression.Variable variable) {
        builder.append(variable.id);
        if (!lambdaParams.contains(variable.id))
            builder.append("()");
        return null;
    }
}
