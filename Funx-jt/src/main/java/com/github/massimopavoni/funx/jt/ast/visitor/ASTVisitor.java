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
    T visitModule(ASTNode.Module node);

    /**
     * Visit a {@link ASTNode.Declarations} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visitDeclarations(ASTNode.Declarations node);

    /**
     * Visit a {@link Declaration} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visitDeclaration(Declaration node);

    /**
     * Visit a {@link Type.SimpleType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visitSimpleType(Type.SimpleType node);

    /**
     * Visit a {@link Type.ArrowType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visitArrowType(Type.ArrowType node);

    /**
     * Visit a {@link Statement.Lambda} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visitLambda(Statement.Lambda node);

    /**
     * Visit a {@link Statement.Let} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visitLet(Statement.Let node);

    /**
     * Visit a {@link Statement.If} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visitIf(Statement.If node);

    /**
     * Visit a {@link Expression.Application} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visitApplication(Expression.Application node);

    /**
     * Visit a {@link Primary.Constant} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visitConstant(Primary.Constant node);

    /**
     * Visit a {@link Primary.Variable} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    T visitVariable(Primary.Variable node);

    /**
     * Visit an {@link ASTNode}.
     *
     * @param node the AST node
     * @return the visitor result
     */
    default T visitNode(ASTNode node) {
        return switch (node) {
            case ASTNode.Module module -> visitModule(module);
            case ASTNode.Declarations declarations -> visitDeclarations(declarations);
            case Declaration declaration -> visitDeclaration(declaration);
            case Type type -> visitType(type);
            case Statement statement -> visitStatement(statement);
            case ASTNode ignored -> throw new IllegalASTNodeException("Bare base AST node found");
        };
    }

    /**
     * Visit a {@link Type} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    default T visitType(Type node) {
        return switch (node) {
            case Type.SimpleType simpleType -> visitSimpleType(simpleType);
            case Type.ArrowType arrowType -> visitArrowType(arrowType);
            case Type ignored -> throw new IllegalASTNodeException("Bare base Type node found");
        };
    }

    /**
     * Visit a {@link Statement} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    default T visitStatement(Statement node) {
        return switch (node) {
            case Statement.Lambda lambda -> visitLambda(lambda);
            case Statement.Let let -> visitLet(let);
            case Statement.If ifNode -> visitIf(ifNode);
            case Expression expression -> visitExpression(expression);
            case Statement ignored -> throw new IllegalASTNodeException("Bare base Statement node found");
        };
    }

    /**
     * Visit an {@link Expression} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    default T visitExpression(Expression node) {
        return switch (node) {
            case Primary primary -> visitPrimary(primary);
            case Expression.Application application -> visitApplication(application);
            case Expression ignored -> throw new IllegalASTNodeException("Bare base Expression node found");
        };
    }

    /**
     * Visit a {@link Primary} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    default T visitPrimary(Primary node) {
        return switch (node) {
            case Primary.Constant constant -> visitConstant(constant);
            case Primary.Variable variable -> visitVariable(variable);
            case Primary ignored -> throw new IllegalASTNodeException("Bare base Primary node found");
        };
    }
}
