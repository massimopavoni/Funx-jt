package com.github.massimopavoni.funx.jt.ast.visitor;

import com.github.massimopavoni.funx.jt.ast.node.ASTNode;
import com.github.massimopavoni.funx.jt.ast.node.Declaration;
import com.github.massimopavoni.funx.jt.ast.node.Expression;
import com.github.massimopavoni.funx.jt.ast.typesystem.Environment;
import com.github.massimopavoni.funx.jt.ast.typesystem.InferenceException;
import com.github.massimopavoni.funx.jt.ast.typesystem.Scheme;
import com.github.massimopavoni.funx.jt.ast.typesystem.Type;
import com.github.massimopavoni.funx.lib.FunxPrelude;
import com.github.massimopavoni.funx.lib.JavaPrelude;
import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    private final Map<String, Expression> monomorphicTopLevelDeclarations = new LinkedHashMap<>();
    private final Map<String, Expression> monomorphicLetDeclarations = new LinkedHashMap<>();
    /**
     * Flag to indicate if the current declarations are at top level.
     */
    private boolean currentlyTopLevel = true;
    private Environment currentEnv;

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
        builder.append(module.packageName.isEmpty()
                        ? ""
                        : String.format("package %s;%n", module.packageName.toLowerCase()))
                .append("\n\nimport ").append(Function.class.getName())
                .append(";\n\nimport static ").append(JavaPrelude.class.getName())
                .append(".*;\nimport static ").append(FunxPrelude.class.getName())
                .append(".*;\n\npublic class ").append(module.name).append(" {\n")
                .append("private ").append(module.name)
                .append("() {\n// Private constructor to prevent instantiation\n}\n\n");
        currentEnv = module.let.env();
        if (module.let.expression.type() != Type.Boring.INSTANCE)
            visitMain(module.let.expression);
        visit(module.let.localDeclarations);
        if (!monomorphicTopLevelDeclarations.isEmpty()) {
            builder.append("static {\n");
            monomorphicTopLevelDeclarations.forEach((id, expression) -> {
                builder.append(id).append(" = ");
                visit(expression);
                appendSemiColon();
                appendNewline();
            });
            appendCloseBrace();
        }
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
     * Visit the main {@link Expression} AST node.
     *
     * @param main expression node
     * @return visitor result
     */
    @Override
    public Void visitMain(Expression main) {
        builder.append("""
                public static void main(String[] args) {
                System.out.println(""");
        visit(main);
        appendCloseParen();
        appendSemiColon();
        appendCloseBrace();
        appendNewline();
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
        String scheme = schemeStringOf(declaration.scheme());
        if (declaration.scheme().variables.isEmpty()) {
            builder.append(scheme).append(" ").append(declaration.id);
            appendSemiColon();
            (currentlyTopLevel ? monomorphicTopLevelDeclarations : monomorphicLetDeclarations)
                    .put(declaration.id, declaration.expression);
        } else {
            builder.append(scheme)
                    .append(" ").append(declaration.id).append("() {\nreturn ");
            visit(declaration.expression);
            appendSemiColon();
            appendCloseBrace();
        }
        appendNewline();
        return null;
    }

    private String schemeStringOf(Scheme scheme) {
        String schemeString = "";
        if (!scheme.variables.isEmpty())
            schemeString += "<" + scheme.variables.stream()
                    .map(v -> "t" + v)
                    .collect(Collectors.joining(", ")) + "> ";
        return schemeString + typeStringOf(scheme.type);
    }

    private String typeStringOf(Type type) {
        return switch (type) {
            case Type.Variable var -> var.toString();
            case Type.FunctionApplication fun -> {
                String functionName = fun.function.typeClass.getSimpleName();
                if (fun.function.arity > 0)
                    yield String.format("%s<%s>",
                            functionName,
                            fun.arguments.stream()
                                    .map(this::typeStringOf)
                                    .collect(Collectors.joining(", ")));
                else
                    yield functionName;
            }
            default -> throw new InferenceException("Illegal type for declaration found");
        };
    }

    /**
     * Visit a {@link Expression.Lambda} AST node.
     *
     * @param lambda lambda node
     * @return visitor result
     */
    @Override
    public Void visitLambda(Expression.Lambda lambda) {
        Environment previousEnv = currentEnv;
        currentEnv = lambda.env();
        builder.append("(").append(lambda.paramId).append(" -> ");
        visit(lambda.expression);
        appendCloseParen();
        currentEnv = previousEnv;
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
        Environment previousEnv = currentEnv;
        currentEnv = let.env();
        builder.append("(new ").append(JavaPrelude.Let.class.getSimpleName()).append("<>() {\n");
        visit(let.localDeclarations);
        builder.append("""
                        @Override
                        public\s""")
                .append(typeStringOf(let.expression.type()))
                .append("\n_eval() {\n");
        if (!monomorphicLetDeclarations.isEmpty()) {
            monomorphicLetDeclarations.forEach((id, expression) -> {
                builder.append(id).append(" = ");
                visit(expression);
                appendSemiColon();
                appendNewline();
            });
            monomorphicLetDeclarations.clear();
        }
        builder.append("return ");
        visit(let.expression);
        appendSemiColon();
        appendCloseBrace();
        builder.append("})._eval()");
        currentlyTopLevel = !currentlyTopLevel;
        currentEnv = previousEnv;
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
        if (constant.type().equals(Type.FunctionApplication.INTEGER_TYPE))
            builder.append("L");
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
        if (!currentEnv.bindingOf(variable.id).variables.isEmpty())
            builder.append("()");
        return null;
    }
}
