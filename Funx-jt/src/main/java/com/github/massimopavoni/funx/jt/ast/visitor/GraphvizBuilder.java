package com.github.massimopavoni.funx.jt.ast.visitor;

import com.github.massimopavoni.funx.jt.ast.Utils;
import com.github.massimopavoni.funx.jt.ast.node.ASTNode;
import com.github.massimopavoni.funx.jt.ast.node.Declaration;
import com.github.massimopavoni.funx.jt.ast.node.Expression;
import com.github.massimopavoni.funx.jt.ast.typesystem.Type;
import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.Collections;
import java.util.List;

/**
 * Graphviz visualization builder for the AST tree.
 * The parameter type is a string representing the node identifier.
 */
public final class GraphvizBuilder extends ASTVisitor<String> {
    /**
     * Graphviz code string builder.
     */
    private final StringBuilder builder;
    /**
     * Internal counter to get identifiers for AST nodes,
     * used instead of the hash code to avoid collisions and a resulting weird looking graph.
     */
    private int nodeCounter = 0;

    /**
     * Constructor for the Graphviz builder.
     *
     * @param builder Graphviz code string builder
     */
    public GraphvizBuilder(StringBuilder builder) {
        this.builder = builder;
    }

    /**
     * Retrieve the built Graphviz code.
     *
     * @return Graphviz code string
     */
    public String getBuiltGraphviz() {
        return builder.toString();
    }

    /**
     * Returns a unique identifier for an AST node.
     *
     * @return unique identifier using the internal counter
     */
    private String getNodeId() {
        return String.valueOf(nodeCounter++);
    }

    /**
     * Default behavior for the Graphviz building,
     * using more parameters to set a node label and connect all children to a parent node.
     * (We don't use the ASTVisitor visit method with node results aggregation within this very custom visitor).
     *
     * @param label    node label
     * @param type     node type
     * @param children list of children nodes
     * @return node identifier
     */
    private String toGraphvizDefault(String label, String type, List<? extends ASTNode> children) {
        String nodeId = getNodeId();
        builder.append(nodeId).append(" [label=\"").append(label);
        if (type != null)
            builder.append(" : ").append(type);
        builder.append("\"];\n");
        children.forEach(c ->
                builder.append(
                        String.format("%s -> %s;%n",
                                nodeId,
                                c.accept(this))));
        return nodeId;
    }

    /**
     * Visit a {@link ASTNode.Module} AST node.
     *
     * @param module module node
     * @return visitor result
     */
    @Override
    public String visitModule(ASTNode.Module module) {
        builder.append("""
                digraph AST {
                node [fontname="Arial", color=gray40, shape=egg];
                edge [fontname="Arial", color=gray40, arrowsize=0.8];
                """);
        String nodeId = toGraphvizDefault(String.format("module %s%s%s",
                        module.packageName,
                        module.packageName.isEmpty() ? "" : ".",
                        module.name),
                null,
                Collections.singletonList(module.let));
        builder.append("}\n");
        return nodeId;
    }

    /**
     * Visit a {@link ASTNode.Declarations} AST node.
     *
     * @param declarations declarations node
     * @return visitor result
     */
    @Override
    public String visitDeclarations(ASTNode.Declarations declarations) {
        return toGraphvizDefault(ASTNode.Declarations.class.getSimpleName(),
                null,
                declarations.declarations);
    }

    /**
     * Visit the main {@link Expression} AST node.
     *
     * @param main expression node
     * @return visitor result
     */
    @Override
    public String visitMain(Expression main) {
        throw new IllegalStateException(String.format(
                "Main expression cannot be visited directly by %s", GraphvizBuilder.class.getSimpleName()));
    }


    /**
     * Visit a {@link Declaration} AST node.
     *
     * @param declaration declaration node
     * @return visitor result
     */
    @Override
    public String visitDeclaration(Declaration declaration) {
        return toGraphvizDefault(declaration.id,
                declaration.scheme().toString(),
                Collections.singletonList(declaration.expression));
    }

    /**
     * Visit a {@link Expression.Lambda} AST node.
     *
     * @param lambda lambda node
     * @return visitor result
     */
    @Override
    public String visitLambda(Expression.Lambda lambda) {
        return toGraphvizDefault(
                String.format("\\\\%s", lambda.paramId),
                lambda.type().toString(),
                Collections.singletonList(lambda.expression));
    }

    /**
     * Visit a {@link Expression.Let} AST node.
     *
     * @param let let node
     * @return visitor result
     */
    @Override
    public String visitLet(Expression.Let let) {
        return toGraphvizDefault(Utils.fromLexerToken(FunxLexer.LET),
                null,
                List.of(let.localDeclarations, let.expression));
    }

    /**
     * Visit a {@link Expression.If} AST node.
     * application
     *
     * @param ifE if node
     * @return visitor result
     */
    @Override
    public String visitIf(Expression.If ifE) {
        return toGraphvizDefault(Utils.fromLexerToken(FunxLexer.IF),
                ifE.type().toString(),
                List.of(ifE.condition, ifE.thenBranch, ifE.elseBranch));
    }

    /**
     * Visit a {@link Expression.Application} AST node.
     * constant
     *
     * @param application application node
     * @return visitor result
     */
    @Override
    public String visitApplication(Expression.Application application) {
        return toGraphvizDefault("@",
                application.type().toString(),
                List.of(application.left, application.right));
    }

    /**
     * Visit a {@link Expression.Constant} AST node.
     *
     * @param constant constant node
     * @return visitor result
     */
    @Override
    public String visitConstant(Expression.Constant constant) {
        return toGraphvizDefault(constant.value.toString(),
                constant.type().toString(),
                Collections.emptyList());
    }

    /**
     * Visit a {@link Expression.Variable} AST node.
     *
     * @param variable variable node
     * @return visitor result
     */
    @Override
    public String visitVariable(Expression.Variable variable) {
        return toGraphvizDefault(variable.id,
                variable.type().toString(),
                Collections.emptyList());
    }
}