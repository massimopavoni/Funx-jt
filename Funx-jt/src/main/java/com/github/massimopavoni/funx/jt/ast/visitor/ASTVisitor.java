package com.github.massimopavoni.funx.jt.ast.visitor;

import com.github.massimopavoni.funx.jt.ast.node.ASTNode;
import com.github.massimopavoni.funx.jt.ast.node.Declaration;
import com.github.massimopavoni.funx.jt.ast.node.Expression;
import com.github.massimopavoni.funx.jt.parser.ASTBuilder;

import java.util.List;

/**
 * Abstract class defining a complete generic visitor for an AST tree produced by an {@link ASTBuilder}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public abstract sealed class ASTVisitor<T>
        permits JavaBuilder, GraphvizBuilder {
    /**
     * Constructor for the AST visitor.
     */
    protected ASTVisitor() {
        // empty constructor
    }

    /**
     * Visit any {@link ASTNode}.
     *
     * @param node AST node
     * @return visitor result
     */
    public T visit(ASTNode node) {
        return node.accept(this);
    }

    /**
     * Visit a list of {@link ASTNode}s.
     *
     * @param nodes list of AST nodes
     * @return visitor result
     */
    public T visit(List<? extends ASTNode> nodes) {
        T result = defaultResult();
        for (ASTNode node : nodes)
            result = aggregateResult(result, visit(node));
        return result;
    }

    /**
     * Default result for the visitor.
     *
     * @return visitor result
     */
    public T defaultResult() {
        return null;
    }

    /**
     * Aggregate the result of visiting a node with the current aggregate.
     *
     * @param aggregate  current aggregate
     * @param nextResult next node result
     * @return visitor result
     */
    public T aggregateResult(T aggregate, T nextResult) {
        return nextResult;
    }

    /**
     * Visit a {@link ASTNode.Module} AST node.
     *
     * @param module module node
     * @return visitor result
     */
    public abstract T visitModule(ASTNode.Module module);

    /**
     * Visit a {@link ASTNode.Declarations} AST node.
     *
     * @param declarations declarations node
     * @return visitor result
     */
    public abstract T visitDeclarations(ASTNode.Declarations declarations);

    /**
     * Visit the main {@link Expression} AST node.
     *
     * @param main expression node
     * @return visitor result
     */
    public abstract T visitMain(Expression main);

    /**
     * Visit a {@link Declaration} AST node.
     *
     * @param declaration declaration node
     * @return visitor result
     */
    public abstract T visitDeclaration(Declaration declaration);

    /**
     * Visit a {@link Expression.Lambda} AST node.
     *
     * @param lambda lambda node
     * @return visitor result
     */
    public abstract T visitLambda(Expression.Lambda lambda);

    /**
     * Visit a {@link Expression.Let} AST node.
     *
     * @param let let node
     * @return visitor result
     */
    public abstract T visitLet(Expression.Let let);

    /**
     * Visit a {@link Expression.If} AST node.
     *
     * @param ifE if node
     * @return visitor result
     */
    public abstract T visitIf(Expression.If ifE);

    /**
     * Visit a {@link Expression.Application} AST node.
     *
     * @param application application node
     * @return visitor result
     */
    public abstract T visitApplication(Expression.Application application);

    /**
     * Visit a {@link Expression.Constant} AST node.
     *
     * @param constant constant node
     * @return visitor result
     */
    public abstract T visitConstant(Expression.Constant constant);

    /**
     * Visit a {@link Expression.Variable} AST node.
     *
     * @param variable variable node
     * @return visitor result
     */
    public abstract T visitVariable(Expression.Variable variable);
}
