package com.github.massimopavoni.funx.jt.ast.node;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;

/**
 * Base class for primary nodes.
 */
public abstract class Primary extends Expression {
    /**
     * Package private default constructor,
     * preventing instantiation of generalization class from outside.
     *
     * @param inputPosition input source code node position
     */
    Primary(InputPosition inputPosition) {
        super(inputPosition);
    }

    /**
     * Constant primary class.
     */
    public final static class Constant extends Primary {
        /**
         * Constant value.
         */
        public final Object value;

        /**
         * Constructor for the constant primary node.
         *
         * @param inputPosition input source code node position
         * @param value         constant value
         */
        public Constant(InputPosition inputPosition, Object value) {
            super(inputPosition);
            this.value = value;
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
            return visitor.visitConstant(this);
        }
    }

    /**
     * Variable primary class.
     */
    public final static class Variable extends Primary {
        /**
         * Variable identifier.
         */
        public final String id;

        /**
         * Constructor for the variable primary node.
         *
         * @param inputPosition input source code node position
         * @param id            variable identifier
         */
        public Variable(InputPosition inputPosition, String id) {
            super(inputPosition);
            this.id = id;
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
            return visitor.visitVariable(this);
        }
    }
}
