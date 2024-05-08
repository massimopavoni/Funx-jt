package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;

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

        /**
         * Accepts a visitor to traverse the AST.
         *
         * @param visitor visitor to accept
         * @param <T>     return type of the visitor
         * @return the result of the visit
         */
        @Override
        public <T> T accept(ASTVisitor<? extends T> visitor) {
            return visitor.visitApplication(this);
        }
    }
}
