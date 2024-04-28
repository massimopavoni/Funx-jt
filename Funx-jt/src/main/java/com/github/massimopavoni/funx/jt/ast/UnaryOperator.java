package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;

/**
 * Base class for unary operator nodes.
 */
public abstract class UnaryOperator extends Expression.Operator {
    /**
     * Operand node.
     */
    public final ASTNode operand;

    /**
     * Constructor for the unary operator node.
     *
     * @param operand operand node
     */
    public UnaryOperator(ASTNode operand) {
        this.operand = operand;
    }

    /**
     * To string method override,
     * essentially re-prints the original source code.
     *
     * @return string representation of the node
     */
    @Override
    public String toString() {
        return String.format("%s%s", operatorString(), operand.toString());
    }

    /**
     * Not boolean unary operator class.
     */
    public final static class Not extends UnaryOperator {
        /**
         * Constructor for the not operator node.
         *
         * @param operand operand node
         */
        public Not(ASTNode operand) {
            super(operand);
        }

        /**
         * Get the operator string representation.
         *
         * @return operator string
         */
        @Override
        public String operatorString() {
            return ASTNode.fromLexerToken(FunxLexer.Not);
        }
    }
}
