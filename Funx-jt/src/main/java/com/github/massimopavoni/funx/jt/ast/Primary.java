package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;

/**
 * Base class for primary nodes.
 */
public abstract class Primary extends Expression {
    /**
     * Package private default constructor,
     * preventing instantiation of generalization class from outside.
     */
    Primary() {
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
         * @param value constant value
         */
        public Constant(Object value) {
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
        public final String varId;

        /**
         * Constructor for the variable primary node.
         *
         * @param varId variable identifier
         */
        public Variable(String varId) {
            this.varId = varId;
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
