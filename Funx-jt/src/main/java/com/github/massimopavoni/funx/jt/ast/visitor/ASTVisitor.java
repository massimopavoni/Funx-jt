package com.github.massimopavoni.funx.jt.ast.visitor;

import com.github.massimopavoni.funx.jt.ast.*;
import com.github.massimopavoni.funx.jt.parser.ASTBuilder;

/**
 * Interface defining a complete generic visitor for an AST tree produced by {@link ASTBuilder}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
interface ASTVisitor<T> {
    /**
     * Visit a {@link ASTNode.Module} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(ASTNode.Module node);

    /**
     * Visit a {@link Declaration} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(Declaration node);

    /**
     * Visit a {@link Type.SimpleType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(Type.SimpleType node);

    /**
     * Visit a {@link Type.ArrowType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(Type.ArrowType node);

    /**
     * Visit a {@link Statement.Lambda} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(Statement.Lambda node);

    /**
     * Visit a {@link Statement.Let} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(Statement.Let node);

    /**
     * Visit a {@link Statement.If} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(Statement.If node);

    /**
     * Visit a {@link Expression.Application} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(Expression.Application node);

    /**
     * Visit a {@link Primary.Constant} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(Primary.Constant node);

    /**
     * Visit a {@link Primary.Variable} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(Primary.Variable node);

    /**
     * Visit an {@link ASTNode}.
     *
     * @param node the AST node
     * @return the visitor result
     */
    default T visit(ASTNode node) {
        return switch (node) {
            case ASTNode.Module module -> visit(module);
            case Declaration declaration -> visit(declaration);
            case Type type -> visit(type);
            case Statement statement -> visit(statement);
            case ASTNode ignored -> throw new IllegalASTNodeException("Bare base AST node found");
        };
    }

    /**
     * Visit a {@link Type} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    default T visit(Type node) {
        return switch (node) {
            case Type.SimpleType simpleType -> visit(simpleType);
            case Type.ArrowType arrowType -> visit(arrowType);
            case Type ignored -> throw new IllegalASTNodeException("Bare base Type node found");
        };
    }

    /**
     * Visit a {@link Statement} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    default T visit(Statement node) {
        return switch (node) {
            case Statement.Lambda lambda -> visit(lambda);
            case Statement.Let let -> visit(let);
            case Statement.If ifNode -> visit(ifNode);
            case Expression expression -> visit(expression);
            case Statement ignored -> throw new IllegalASTNodeException("Bare base Statement node found");
        };
    }

    /**
     * Visit an {@link Expression} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    default T visit(Expression node) {
        return switch (node) {
            case Primary primary -> visit(primary);
            case Expression.Application application -> visit(application);
            case Expression ignored -> throw new IllegalASTNodeException("Bare base Expression node found");
        };
    }

    /**
     * Visit a {@link Primary} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    default T visit(Primary node) {
        return switch (node) {
            case Primary.Constant constant -> visit(constant);
            case Primary.Variable variable -> visit(variable);
            case Primary ignored -> throw new IllegalASTNodeException("Bare base Primary node found");
        };
    }
}
