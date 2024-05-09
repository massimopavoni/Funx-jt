package com.github.massimopavoni.funx.jt.ast.node;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;

/**
 * Base class for expression nodes.
 */
public abstract class Expression extends Statement {
    /**
     * Package private default constructor,
     * preventing instantiation of generalization class from outside.
     *
     * @param inputPosition input source code node position
     */
    Expression(InputPosition inputPosition) {
        super(inputPosition);
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
         * @param inputPosition input source code node position
         * @param left          left node
         * @param right         right node
         */
        public Application(InputPosition inputPosition, ASTNode left, ASTNode right) {
            super(inputPosition);
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
