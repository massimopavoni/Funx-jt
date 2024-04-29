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
                        visit(c))));
        return nodeId;
    }

    /**
     * Default behavior for the Graphviz building of a {@link UnaryOperator} node.
     *
     * @param node unary operator node
     * @return node identifier
     */
    private String toGraphvizUnaryOperator(UnaryOperator node) {
        return toGraphvizDefault(node.operatorString(), node, Collections.singletonList(node.operand));
    }

    /**
     * Default behavior for the Graphviz building of a {@link BinaryOperator} node.
     *
     * @param node binary operator node
     * @return node identifier
     */
    private String toGraphvizBinaryOperator(BinaryOperator node) {
        return toGraphvizDefault(node.operatorString(), node, List.of(node.left, node.right));
    }

    /**
     * Visit a {@link ASTNode.Program} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(ASTNode.Program node) {
        builder.append("""
                digraph AST {
                compound=true;
                node [color=gray40, shape=egg];
                edge [color=gray40, arrowsize=0.8];
                """);
        String nodeId = toGraphvizDefault(ASTNode.Program.class.getSimpleName(), node, node.functions);
        builder.append("}\n");
        return nodeId;
    }

    /**
     * Visit a {@link Function} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(Function node) {
        return toGraphvizDefault(String.format("%s : %s", node.typeFunId, node.type.toString()), node,
                Collections.singletonList(node.lambda));
    }

    /**
     * Visit a {@link Type.ParenType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(Type.ParenType node) {
        // currently unused (function prints type using the latter's toString method)
        return "";
    }

    /**
     * Visit a {@link Type.SimpleType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(Type.SimpleType node) {
        // currently unused (function prints type using the latter's toString method)
        return "";
    }

    /**
     * Visit a {@link Type.ArrowType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(Type.ArrowType node) {
        // currently unused (function prints type using the latter's toString method)
        return "";
    }

    /**
     * Visit a {@link Statement.Lambda} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(Statement.Lambda node) {
        return toGraphvizDefault(String.format("\\\\%s", node.params.toString()), node,
                Collections.singletonList(node.statement));
    }

    /**
     * Visit a {@link Statement.Lambda.Param} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(Statement.Lambda.Param node) {
        // currently unused (lambda prints params using the latter's toString method)
        return "";
    }

    /**
     * Visit a {@link Statement.Lambda.MultiParam} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(Statement.Lambda.MultiParam node) {
        // currently unused (lambda prints params using the latter's toString method)
        return "";
    }

    /**
     * Visit a {@link Statement.Let} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(Statement.Let node) {
        String nodeId = getNodeId(node);
        builder.append(String.format("""
                        %1$s [label="%2$s"];
                        subgraph cluster_%1$s {
                        color=gray40;
                        """,
                nodeId, ASTNode.fromLexerToken(FunxLexer.LET)));
        List<String> childrenIds = node.localFunctions.stream()
                .map(this::visit).toList();
        builder.append("}\n");
        builder.append(String.format("""
                        %1$s -> %2$s [lhead="cluster_%1$s"];
                        %1$s -> %3$s;
                        """,
                nodeId, childrenIds.get(childrenIds.size() / 2), visit(node.statement)));
        return nodeId;
    }

    /**
     * Visit a {@link Statement.If} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(Statement.If node) {
        return toGraphvizDefault(ASTNode.fromLexerToken(FunxLexer.IF), node,
                List.of(node.condition, node.thenBranch, node.elseBranch));
    }

    /**
     * Visit a {@link Primary.Parenthesized} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(Primary.Parenthesized node) {
        return visit(node.statement);
    }

    /**
     * Visit a {@link Primary.Literal} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(Primary.Literal node) {
        return toGraphvizDefault(node.value.toString(), node, Collections.emptyList());
    }

    /**
     * Visit a {@link Primary.Fun} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(Primary.Fun node) {
        return toGraphvizDefault(node.funId, node, Collections.emptyList());
    }

    /**
     * Visit a {@link UnaryOperator.Not} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(UnaryOperator.Not node) {
        return toGraphvizUnaryOperator(node);
    }

    /**
     * Visit a {@link BinaryOperator.Application} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(BinaryOperator.Application node) {
        return toGraphvizDefault("$", node, List.of(node.left, node.right));
    }

    /**
     * Visit a {@link BinaryOperator.Divide} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(BinaryOperator.Divide node) {
        return toGraphvizBinaryOperator(node);
    }

    /**
     * Visit a {@link BinaryOperator.Modulo} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(BinaryOperator.Modulo node) {
        return toGraphvizBinaryOperator(node);
    }

    /**
     * Visit a {@link BinaryOperator.Multiply} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(BinaryOperator.Multiply node) {
        return toGraphvizBinaryOperator(node);
    }

    /**
     * Visit a {@link BinaryOperator.Add} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(BinaryOperator.Add node) {
        return toGraphvizBinaryOperator(node);
    }

    /**
     * Visit a {@link BinaryOperator.Subtract} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(BinaryOperator.Subtract node) {
        return toGraphvizBinaryOperator(node);
    }

    /**
     * Visit a {@link BinaryOperator.GreaterThan} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(BinaryOperator.GreaterThan node) {
        return toGraphvizBinaryOperator(node);
    }

    /**
     * Visit a {@link BinaryOperator.GreaterThanEquals} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(BinaryOperator.GreaterThanEquals node) {
        return toGraphvizBinaryOperator(node);
    }

    /**
     * Visit a {@link BinaryOperator.LessThan} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(BinaryOperator.LessThan node) {
        return toGraphvizBinaryOperator(node);
    }

    /**
     * Visit a {@link BinaryOperator.LessThanEquals} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(BinaryOperator.LessThanEquals node) {
        return toGraphvizBinaryOperator(node);
    }

    /**
     * Visit an {@link BinaryOperator.EqualsEquals} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(BinaryOperator.EqualsEquals node) {
        return toGraphvizBinaryOperator(node);
    }

    /**
     * Visit a {@link BinaryOperator.NotEquals} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(BinaryOperator.NotEquals node) {
        return toGraphvizBinaryOperator(node);
    }

    /**
     * Visit an {@link BinaryOperator.And} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(BinaryOperator.And node) {
        return toGraphvizBinaryOperator(node);
    }

    /**
     * Visit an {@link BinaryOperator.Or} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    @Override
    public String visit(BinaryOperator.Or node) {
        return toGraphvizBinaryOperator(node);
    }
}
