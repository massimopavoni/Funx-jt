package com.github.massimopavoni.funx.jt.ast.visitor;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.node.*;
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
     * Constructor for the AST visitor.
     */
    protected ASTVisitor() {
        // Empty constructor
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
     * Report an error using the AST reporter instance.
     *
     * @param position error position
     * @param message  error message
     */
    void reportError(InputPosition position, String message) {
        errorReporter.reportError(String.format("%s %s", position, message));
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
     * Visit a {@link Type.NamedType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitNamedType(Type.NamedType node);

    /**
     * Visit a {@link Type.VariableType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitVariableType(Type.VariableType node);

    /**
     * Visit a {@link Type.ArrowType} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitArrowType(Type.ArrowType node);

    /**
     * Visit a {@link Expression.Lambda} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitLambda(Expression.Lambda node);

    /**
     * Visit a {@link Expression.Let} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitLet(Expression.Let node);

    /**
     * Visit a {@link Expression.If} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitIf(Expression.If node);

    /**
     * Visit a {@link Expression.Application} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitApplication(Expression.Application node);

    /**
     * Visit a {@link Expression.Constant} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitConstant(Expression.Constant node);

    /**
     * Visit a {@link Expression.Variable} AST node.
     *
     * @param node the AST node
     * @return the visitor result
     */
    public abstract T visitVariable(Expression.Variable node);
}
