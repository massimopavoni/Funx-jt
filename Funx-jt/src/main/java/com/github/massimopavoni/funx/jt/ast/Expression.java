package com.github.massimopavoni.funx.jt.ast;

/**
 * Base class for expression nodes.
 */
public abstract class Expression extends Statement {
    /**
     * Package private default constructor,
     * preventing instantiation of generalization class from outside.
     */
    Expression() {
    }

    /**
     * Base class for operator nodes.
     */
    public static abstract class Operator extends Expression {
        /**
         * Package private default constructor,
         * preventing instantiation of generalization class from outside.
         */
        Operator() {
        }

        /**
         * Get the operator string representation.
         *
         * @return operator string
         */
        public abstract String operatorString();
    }
}
