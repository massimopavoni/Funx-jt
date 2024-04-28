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
     * Visit a {@link ASTNode.Program} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(ASTNode.Program node);

    /**
     * Visit a {@link Function} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(Function node);

    /**
     * Visit a {@link Type.ParenType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(Type.ParenType node);

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
     * Visit a {@link Statement.Lambda.Param} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(Statement.Lambda.Param node);

    /**
     * Visit a {@link Statement.Lambda.MultiParam} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(Statement.Lambda.MultiParam node);

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
     * Visit a {@link Primary.Parenthesized} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(Primary.Parenthesized node);

    /**
     * Visit a {@link Primary.Literal} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(Primary.Literal node);

    /**
     * Visit a {@link Primary.Fun} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(Primary.Fun node);

    /**
     * Visit a {@link UnaryOperator.Not} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(UnaryOperator.Not node);

    /**
     * Visit a {@link BinaryOperator.Application} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(BinaryOperator.Application node);

    /**
     * Visit a {@link BinaryOperator.Divide} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(BinaryOperator.Divide node);

    /**
     * Visit a {@link BinaryOperator.Modulo} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(BinaryOperator.Modulo node);

    /**
     * Visit a {@link BinaryOperator.Multiply} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(BinaryOperator.Multiply node);

    /**
     * Visit a {@link BinaryOperator.Add} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(BinaryOperator.Add node);

    /**
     * Visit a {@link BinaryOperator.Subtract} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(BinaryOperator.Subtract node);

    /**
     * Visit a {@link BinaryOperator.GreaterThan} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(BinaryOperator.GreaterThan node);

    /**
     * Visit a {@link BinaryOperator.GreaterThanEquals} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(BinaryOperator.GreaterThanEquals node);

    /**
     * Visit a {@link BinaryOperator.LessThan} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(BinaryOperator.LessThan node);

    /**
     * Visit a {@link BinaryOperator.LessThanEquals} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(BinaryOperator.LessThanEquals node);

    /**
     * Visit an {@link BinaryOperator.EqualsEquals} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(BinaryOperator.EqualsEquals node);

    /**
     * Visit a {@link BinaryOperator.NotEquals} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(BinaryOperator.NotEquals node);

    /**
     * Visit an {@link BinaryOperator.And} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(BinaryOperator.And node);

    /**
     * Visit an {@link BinaryOperator.Or} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visit(BinaryOperator.Or node);

    /**
     * Visit an {@link ASTNode}.
     *
     * @param node the AST node
     * @return the visitor result
     */
    default T visit(ASTNode node) {
        return switch (node) {
            case ASTNode.Program program -> visit(program);
            case Function function -> visit(function);
            case Type type -> visit(type);
            case Statement statement -> visit(statement);
            case Statement.Lambda.Param param -> visit(param);
            case Statement.Lambda.MultiParam multiParam -> visit(multiParam);
            case ASTNode ignored -> throw new IllegalArgumentException("Bare base AST node found");
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
            case Type.ParenType parenType -> visit(parenType);
            case Type.SimpleType simpleType -> visit(simpleType);
            case Type.ArrowType arrowType -> visit(arrowType);
            case Type ignored -> throw new IllegalArgumentException("Bare base Type node found");
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
            case Statement ignored -> throw new IllegalArgumentException("Bare base Statement node found");
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
            case UnaryOperator unaryOperator -> visit(unaryOperator);
            case BinaryOperator binaryOperator -> visit(binaryOperator);
            case Expression ignored -> throw new IllegalArgumentException("Bare base Expression node found");
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
            case Primary.Parenthesized parenthesized -> visit(parenthesized);
            case Primary.Literal literal -> visit(literal);
            case Primary.Fun fun -> visit(fun);
            case Primary ignored -> throw new IllegalArgumentException("Bare base Primary node found");
        };
    }

    /**
     * Visit a {@link UnaryOperator} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    default T visit(UnaryOperator node) {
        return switch (node) {
            case UnaryOperator.Not not -> visit(not);
            case UnaryOperator ignored -> throw new IllegalArgumentException("Bare base UnaryOperator node found");
        };
    }

    /**
     * Visit a {@link BinaryOperator} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    default T visit(BinaryOperator node) {
        return switch (node) {
            case BinaryOperator.Application application -> visit(application);
            case BinaryOperator.Divide divide -> visit(divide);
            case BinaryOperator.Modulo modulo -> visit(modulo);
            case BinaryOperator.Multiply multiply -> visit(multiply);
            case BinaryOperator.Add add -> visit(add);
            case BinaryOperator.Subtract subtract -> visit(subtract);
            case BinaryOperator.GreaterThan greaterThan -> visit(greaterThan);
            case BinaryOperator.GreaterThanEquals greaterThanEquals -> visit(greaterThanEquals);
            case BinaryOperator.LessThan lessThan -> visit(lessThan);
            case BinaryOperator.LessThanEquals lessThanEquals -> visit(lessThanEquals);
            case BinaryOperator.EqualsEquals equalsEquals -> visit(equalsEquals);
            case BinaryOperator.NotEquals notEquals -> visit(notEquals);
            case BinaryOperator.And and -> visit(and);
            case BinaryOperator.Or or -> visit(or);
            case BinaryOperator ignored -> throw new IllegalArgumentException("Bare base BinaryOperator node found");
        };
    }
}
