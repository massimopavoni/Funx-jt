package com.github.massimopavoni.funx.jt.ast.visitor;

import com.github.massimopavoni.funx.jt.ast.*;
import com.github.massimopavoni.funx.jt.parser.ASTBuilder;

import java.util.List;

/**
 * Abstract class defining a complete generic visitor for an AST tree produced by an {@link ASTBuilder}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public abstract class ASTVisitor<T> {
    /**
     * Error reporter for the AST visitor.
     */
    private final ASTErrorReporter errorReporter = new ASTErrorReporter();

    /**
     * Current declaration identifier to more easily report errors.
     */
    private String currentDeclaration;

    /**
     * Constructor for the AST visitor.
     */
    public ASTVisitor() {
        currentDeclaration = "Module Root";
    }

    /**
     * Retrieve the number of errors found.
     *
     * @return number of errors
     */
    public int getErrorsCount() {
        return errorReporter.getErrorsCount();
    }

    /**
     * Current declaration identifier setter.
     *
     * @param declaration declaration id
     */
    public void setCurrentDeclaration(String declaration) {
        currentDeclaration = declaration;
    }

    /**
     * Report an error using the AST reporter instance.
     *
     * @param message error message
     */
    void reportError(String message) {
        errorReporter.reportError(String.format("At declaration \"%s\": %s", currentDeclaration, message));
    }

    /**
     * Visit any {@link ASTNode}.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public T visit(ASTNode node) {
        return node.accept(this);
    }

    /**
     * Visit a list of {@link ASTNode}s.
     *
     * @param nodes list of AST nodes
     * @return the visitor result
     */
    public T visit(List<ASTNode> nodes) {
        T result = defaultResult();
        for (ASTNode node : nodes)
            result = aggregateResult(result, node.accept(this));
        return result;
    }

    /**
     * Default result for the visitor.
     *
     * @return the visitor result
     */
    public T defaultResult() {
        return null;
    }

    /**
     * Aggregate the result of visiting a node with the current aggregate.
     *
     * @param aggregate  current aggregate
     * @param nextResult next node result
     * @return the visitor result
     */
    public T aggregateResult(T aggregate, T nextResult) {
        return nextResult;
    }

    /**
     * Visit a {@link ASTNode.Module} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitModule(ASTNode.Module node);

    /**
     * Visit a {@link ASTNode.Declarations} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitDeclarations(ASTNode.Declarations node);

    /**
     * Visit a {@link Declaration} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitDeclaration(Declaration node);

    /**
     * Visit a {@link Type.SimpleType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitSimpleType(Type.SimpleType node);

    /**
     * Visit a {@link Type.ArrowType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitArrowType(Type.ArrowType node);

    /**
     * Visit a {@link Statement.Lambda} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitLambda(Statement.Lambda node);

    /**
     * Visit a {@link Statement.Let} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitLet(Statement.Let node);

    /**
     * Visit a {@link Statement.If} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitIf(Statement.If node);

    /**
     * Visit a {@link Expression.Application} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitApplication(Expression.Application node);

    /**
     * Visit a {@link Primary.Constant} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitConstant(Primary.Constant node);

    /**
     * Visit a {@link Primary.Variable} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitVariable(Primary.Variable node);
}
