package com.github.massimopavoni.funx.jt.ast.visitor;

import com.github.massimopavoni.funx.jt.ast.PreludeFunction;
import com.github.massimopavoni.funx.jt.ast.Utils;
import com.github.massimopavoni.funx.jt.ast.node.ASTNode;
import com.github.massimopavoni.funx.jt.ast.node.Declaration;
import com.github.massimopavoni.funx.jt.ast.node.Expression;
import com.github.massimopavoni.funx.jt.ast.typesystem.*;
import com.github.massimopavoni.funx.lib.FunxPrelude;
import com.github.massimopavoni.funx.lib.JavaPrelude;
import com.google.common.collect.ImmutableMap;
import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;

import java.util.*;
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
    /**
     * Map of monomorphic top level declarations,
     * to initialize them in a static block.
     */
    private final Map<String, Expression> monomorphicTopLevelDeclarations = new LinkedHashMap<>();
    /**
     * Queue of maps of monomorphic let declarations,
     * to initialize them in their own {@code _eval} method.
     */
    private final Deque<Map<String, Expression>> monomorphicLetDeclarationsQueue = new ArrayDeque<>();
    /**
     * List of scopes, used like a stack but cycled through for lookups.
     * Each map entry has the variable name as key and a tuple of the scheme and the scope as value,
     * where the scope is either a Prelude class, the module class, {@code this} for lets or {@code null} for lambdas.
     */
    private final List<Map<String, Utils.Tuple<Scheme, String>>> scopes = new ArrayList<>();
    /**
     * Current scope level indicator (0 is top level).
     */
    private short currentLevel = 0;
    /**
     * Flag to indicate if a cast is needed for a lambda or let expression,
     * whenever using one in an application ("in the wild").
     */
    private boolean wildCast = false;

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
     * Add a list of declarations to the current scope.
     *
     * @param declarations list of declarations
     * @param scope        scope name
     */
    private void addToScope(List<Declaration> declarations, String scope) {
        scopes.addFirst(declarations.stream()
                .collect(ImmutableMap.toImmutableMap(
                        decl -> decl.id,
                        decl -> new Utils.Tuple<>(decl.scheme(), scope))));
    }

    /**
     * Add a single variable to the current scope.
     *
     * @param id     variable identifier
     * @param scheme variable scheme
     * @param scope  scope name
     */
    private void addToScope(String id, Scheme scheme, String scope) {
        scopes.addFirst(Collections.singletonMap(id, new Utils.Tuple<>(scheme, scope)));
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
        // add Prelude functions to the scope
        scopes.addFirst(Arrays.stream(PreludeFunction.values())
                .collect(ImmutableMap.toImmutableMap(
                        pf -> pf.id,
                        pf -> new Utils.Tuple<>(pf.scheme, pf.nativeJava
                                ? JavaPrelude.class.getSimpleName()
                                : FunxPrelude.class.getSimpleName()))));
        // add module functions to the scope
        addToScope(module.let.localDeclarations.declarationList, module.name);
        // append package, imports, class declaration and constructor
        builder.append(module.packageName.isEmpty()
                        ? ""
                        : String.format("package %s;%n", module.packageName.toLowerCase()))
                .append("\n\nimport ").append(Function.class.getName())
                .append(";\n\nimport ").append(JavaPrelude.class.getName())
                .append(";\n\nimport ").append(FunxPrelude.class.getName())
                .append(";\n\nimport static ").append(JavaPrelude.class.getName())
                .append(".*;\nimport static ").append(FunxPrelude.class.getName())
                .append(".*;\n\npublic class ").append(module.name).append(" {\n")
                .append("private ").append(module.name)
                .append("() {\n// private constructor to prevent instantiation\n}\n\n");
        // visit main and top level declarations
        if (module.let.expression.type() != Type.Boring.INSTANCE)
            visitMain(module.let.expression);
        visit(module.let.localDeclarations);
        // initialize monomorphic top level declarations in a static block
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
        scopes.removeFirst();
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
        return visit(declarations.declarationList);
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
        // top level declarations should be static and public,
        // while let local declarations should be private to the anonymous class
        builder.append(currentLevel == 0 ? "public static " : "private ");
        String scheme = schemeStringOf(declaration.scheme());
        if (declaration.scheme().variables.isEmpty()) {
            // defer initialization of monomorphic declarations
            builder.append(scheme).append(" ").append(declaration.id);
            appendSemiColon();
            (currentLevel == 0 ? monomorphicTopLevelDeclarations : monomorphicLetDeclarationsQueue.getFirst())
                    .put(declaration.id, declaration.expression);
        } else {
            // initialize polymorphic declarations immediately (as methods with generics)
            builder.append(scheme)
                    .append(" ").append(declaration.id).append("() {\nreturn ");
            visit(declaration.expression);
            appendSemiColon();
            appendCloseBrace();
        }
        appendNewline();
        return null;
    }

    /**
     * Get the string representation of a scheme.
     *
     * @param scheme scheme
     * @return string representation
     */
    private String schemeStringOf(Scheme scheme) {
        String schemeString = "";
        if (!scheme.variables.isEmpty())
            // polymorphic types have generic type parameters
            // (and we use sorted variables to ensure consistent order of generics
            // when simulating polymorphic types instantiation using Java generics)
            schemeString += "<" + scheme.sortedVariables.stream()
                    .map(Type.Variable::toString)
                    .collect(Collectors.joining(", ")) + "> ";
        return schemeString + typeStringOf(scheme.type);
    }

    /**
     * Get the string representation of a type.
     *
     * @param type type
     * @return string representation
     */
    private String typeStringOf(Type type) {
        return switch (type) {
            case Type.Variable variable -> variable.toString();
            case Type.FunctionApplication fun -> {
                String functionName = fun.function.typeClass.getSimpleName();
                if (fun.function.arity > 0)
                    // function types with arity > 0 have generic type parameters
                    yield String.format("%s<%s>",
                            functionName,
                            fun.arguments.stream()
                                    .map(this::typeStringOf)
                                    .collect(Collectors.joining(", ")));
                else
                    yield functionName;
            }
            default -> throw new InferenceException("Unsupported type for declaration found");
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
        // add lambda parameter to the scope
        addToScope(lambda.paramId, new Scheme(Collections.emptySet(),
                ((Type.FunctionApplication) lambda.type()).arguments.getFirst()), null);
        // always use parentheses because lambdas might be used in applications and other weird places
        builder.append("(");
        if (wildCast) {
            // wild cast is needed for lambdas in applications
            builder.append("(").append(typeStringOf(lambda.type())).append(") ");
            wildCast = false;
        }
        builder.append(lambda.paramId).append(" -> ");
        visit(lambda.expression);
        appendCloseParen();
        scopes.removeFirst();
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
        currentLevel++;
        // add let local declarations to the scope
        addToScope(let.localDeclarations.declarationList, "this");
        if (wildCast) {
            // wild cast is needed for lets in applications
            builder.append("(").append(typeStringOf(let.type())).append(") ");
            wildCast = false;
        }
        // use a new anonymous class for the let expression and push a new monomorphic let declarations map
        builder.append("(new ").append(JavaPrelude.Let.class.getSimpleName()).append("<>() {\n");
        monomorphicLetDeclarationsQueue.push(new LinkedHashMap<>());
        visit(let.localDeclarations);
        builder.append("""
                        @Override
                        public\s""")
                .append(typeStringOf(let.expression.type()))
                .append("\n_eval() {\n");
        // if there are any monomorphic declarations, initialize them in the _eval method,
        // then pop the map either way
        if (!monomorphicLetDeclarationsQueue.getFirst().isEmpty())
            monomorphicLetDeclarationsQueue.getFirst().forEach((id, expression) -> {
                builder.append(id).append(" = ");
                visit(expression);
                appendSemiColon();
                appendNewline();
            });
        monomorphicLetDeclarationsQueue.pop();
        builder.append("return ");
        visit(let.expression);
        appendSemiColon();
        appendCloseBrace();
        builder.append("})._eval()");
        // restore previous scope state and level
        scopes.removeFirst();
        currentLevel--;
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
        // left and right expressions necessitate a wild cast if they are lambda or let expressions
        if (application.left instanceof Expression.Lambda || application.left instanceof Expression.Let) {
            wildCast = true;
            visit(application.left);
        } else
            visit(application.left);
        builder.append(".apply(");
        if (application.right instanceof Expression.Lambda || application.right instanceof Expression.Let) {
            wildCast = true;
            visit(application.right);
        } else
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
        // Java expecting an L suffix for long literals because it's a L language
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
        // firstly, find the variable in the scopes
        int i;
        Utils.Tuple<Scheme, String> variableScheme = null;
        for (i = 0; i < scopes.size(); i++)
            if ((variableScheme = scopes.get(i).get(variable.id)) != null)
                break;
        // cannot have a null tuple, since type inference would have failed before this
        if (Objects.requireNonNull(variableScheme).fst().variables.isEmpty())
            // lambda param or monomorphic declaration
            builder.append(variable.id);
        else if (variableScheme.snd().equals("this") && i > 0)
            // polymorphic declaration from an intermediate let scope needs the worst: an unchecked cast
            builder.append(JavaPrelude.class.getSimpleName()).append(".<")
                    .append(typeStringOf(variable.type())).append(">_instantiationCast(")
                    .append(variable.id)
                    .append("())");
        else {
            // polymorphic declaration from Prelude, top level or same let scope can properly use generics
            builder.append(variableScheme.snd()).append(".<");
            try {
                // to do so we need to instantiate the scheme and find the substitution
                Utils.Tuple<Substitution, Type> instantiation = variableScheme.fst().instantiate();
                Substitution subst = instantiation.fst().applySubstitution(instantiation.snd().unify(variable.type()));
                // to then apply to the sorted variables
                builder.append(variableScheme.fst().sortedVariables.stream()
                                .map(ov -> subst.variables().contains(ov)
                                        ? typeStringOf(subst.substituteOf(ov))
                                        : Type.Variable.toString(ov))
                                .collect(Collectors.joining(", ")))
                        .append(">").append(variable.id).append("()");
            } catch (TypeException e) {
                // should never happen
                throw new InferenceException(e.getMessage());
            }
        }
        return null;
    }
}
