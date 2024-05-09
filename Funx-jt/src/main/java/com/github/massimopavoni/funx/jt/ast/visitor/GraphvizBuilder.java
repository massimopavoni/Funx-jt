package com.github.massimopavoni.funx.jt.ast.visitor;

import com.github.massimopavoni.funx.jt.ast.node.ASTNode;
import com.github.massimopavoni.funx.jt.ast.node.Declaration;
import com.github.massimopavoni.funx.jt.ast.node.Expression;
import com.github.massimopavoni.funx.jt.ast.node.Type;
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
     * Unique identifier for an AST node,
     * used for Graphviz instead of the hash code to avoid collisions and a resulting weird looking graph.
     */
    private int nodeId = 0;

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
        return String.valueOf(nodeId++);
    }

    /**
     * Default behavior for the Graphviz building,
     * using more parameters to set a node label and connect all children to a parent node.
     * (We don't use the ASTVisitor visit method with node results aggregation within this very custom visitor).
     *
     * @param label    node label
     * @param children list of children nodes
     * @return node identifier
     */
    private String toGraphvizDefault(String label, List<ASTNode> children) {
        String nodeId = getNodeId();
        builder.append(String.format("%s [label=\"%s\"];\n",
                nodeId, label));
        children.forEach(c -> builder.append(
                String.format("%s -> %s;\n",
                        nodeId,
                        c.accept(this))));
        return nodeId;
    }

    /**
     * Visit a {@link ASTNode.Module} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitModule(ASTNode.Module node) {
        builder.append("""
                digraph AST {
                node [fontname="Arial", color=gray40, shape=egg];
                edge [fontname="Arial", color=gray40, arrowsize=0.8];
                """);
        String nodeId = toGraphvizDefault(ASTNode.Module.class.getSimpleName(),
                Collections.singletonList(node.declarations));
        builder.append("}\n");
        return nodeId;
    }

    /**
     * Visit a {@link ASTNode.Declarations} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitDeclarations(ASTNode.Declarations node) {
        return toGraphvizDefault(ASTNode.Declarations.class.getSimpleName(),
                node.declarationList);
    }

    /**
     * Visit a {@link Declaration} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitDeclaration(Declaration node) {
        return toGraphvizDefault(node.id,
                List.of(node.type, node.expression));
    }

    /**
     * Visit a {@link Type.NamedType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitNamedType(Type.NamedType node) {
        return toGraphvizDefault(node.type.typeName,
                Collections.emptyList());
    }

    /**
     * Visit a {@link Type.VariableType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitVariableType(Type.VariableType node) {
        return toGraphvizDefault(node.name,
                Collections.emptyList());
    }

    /**
     * Visit a {@link Type.ArrowType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitArrowType(Type.ArrowType node) {
        return toGraphvizDefault(ASTNode.fromLexerToken(FunxLexer.Arrow),
                List.of(node.input, node.output));
    }

    /**
     * Visit a {@link Expression.Lambda} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitLambda(Expression.Lambda node) {
        return toGraphvizDefault(
                String.format("\\\\%s", node.paramId),
                Collections.singletonList(node.expression));
    }

    /**
     * Visit a {@link Expression.Let} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitLet(Expression.Let node) {
        return toGraphvizDefault(ASTNode.fromLexerToken(FunxLexer.LET),
                List.of(node.localDeclarations, node.expression));
    }

    /**
     * Visit a {@link Expression.If} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitIf(Expression.If node) {
        return toGraphvizDefault(ASTNode.fromLexerToken(FunxLexer.IF),
                List.of(node.condition, node.thenBranch, node.elseBranch));
    }

    /**
     * Visit a {@link Expression.Application} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitApplication(Expression.Application node) {
        return toGraphvizDefault("@",
                List.of(node.left, node.right));
    }

    /**
     * Visit a {@link Expression.Constant} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitConstant(Expression.Constant node) {
        return toGraphvizDefault(node.value.toString(),
                Collections.emptyList());
    }

    /**
     * Visit a {@link Expression.Variable} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitVariable(Expression.Variable node) {
        return toGraphvizDefault(node.id,
                Collections.emptyList());
    }
}