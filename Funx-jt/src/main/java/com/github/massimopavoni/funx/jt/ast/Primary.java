package com.github.massimopavoni.funx.jt.ast;

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
    }
}
