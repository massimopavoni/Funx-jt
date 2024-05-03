package com.github.massimopavoni.funx.jt.ast.visitor;

import com.github.massimopavoni.funx.jt.ast.*;
import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.Collections;
import java.util.List;

/**
 * Graphviz visualization builder for the AST tree.
 * The parameter type is a string representing the node identifier.
 */
public final class GraphvizBuilder implements ASTVisitor<String> {
    /**
     * Graphviz code string builder.
     */
    private final StringBuilder builder;

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
     * @param node AST node
     * @return unique identifier using the hash code of the object
     */
    private String getNodeId(ASTNode node) {
        return String.valueOf(node.hashCode());
    }

    /**
     * Default behavior for the Graphviz building,
     * using more parameters to set a node label and connect all children to this node.
     *
     * @param label    node label
     * @param parent   parent node
     * @param children list of children nodes
     * @return node identifier
     */
    private String toGraphvizDefault(String label, ASTNode parent, List<ASTNode> children) {
        String nodeId = getNodeId(parent);
        builder.append(String.format("%s [label=\"%s\"];\n",
                nodeId, label));
        children.forEach(c -> builder.append(
                String.format("%s -> %s;\n",
                        nodeId,
                        visitNode(c))));
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
        String nodeId = toGraphvizDefault(ASTNode.Module.class.getSimpleName(), node,
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
        return toGraphvizDefault(ASTNode.Declarations.class.getSimpleName(), node, node.declarationList);
    }

    /**
     * Visit a {@link Declaration} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitDeclaration(Declaration node) {
        return toGraphvizDefault(node.id, node,
                List.of(node.type, node.statement));
    }

    /**
     * Visit a {@link Type.SimpleType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitSimpleType(Type.SimpleType node) {
        return toGraphvizDefault(node.type.typeName, node, Collections.emptyList());
    }

    /**
     * Visit a {@link Type.ArrowType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitArrowType(Type.ArrowType node) {
        return toGraphvizDefault(ASTNode.fromLexerToken(FunxLexer.Arrow), node,
                List.of(node.input, node.output));
    }

    /**
     * Visit a {@link Statement.Lambda} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitLambda(Statement.Lambda node) {
        return toGraphvizDefault(
                String.format("\\\\%s", node.paramId), node,
                Collections.singletonList(node.statement));
    }

    /**
     * Visit a {@link Statement.Let} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitLet(Statement.Let node) {
        return toGraphvizDefault(ASTNode.fromLexerToken(FunxLexer.LET), node,
                List.of(node.localDeclarations, node.statement));
    }

    /**
     * Visit a {@link Statement.If} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitIf(Statement.If node) {
        return toGraphvizDefault(ASTNode.fromLexerToken(FunxLexer.IF), node,
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
        return toGraphvizDefault("@", node,
                List.of(node.left, node.right));
    }

    /**
     * Visit a {@link Primary.Constant} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitConstant(Primary.Constant node) {
        return toGraphvizDefault(node.value.toString(), node, Collections.emptyList());
    }

    /**
     * Visit a {@link Primary.Variable} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visitVariable(Primary.Variable node) {
        return toGraphvizDefault(node.varId, node, Collections.emptyList());
    }
}