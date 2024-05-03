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
     * Application expression class.
     */
    public static final class Application extends Expression {
        /**
         * Application left node.
         */
        public final ASTNode left;
        /**
         * Application right node.
         */
        public final ASTNode right;

        /**
         * Constructor for the application expression node.
         *
         * @param left  left node
         * @param right right node
         */
        public Application(ASTNode left, ASTNode right) {
            this.left = left;
            this.right = right;
        }
    }
}
