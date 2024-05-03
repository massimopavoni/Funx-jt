package com.github.massimopavoni.funx.jt.ast;

/**
 * Base class for type nodes.
 */
public abstract class Type extends ASTNode {
    /**
     * Package private default constructor,
     * preventing instantiation of generalization class from outside.
     */
    Type() {
    }

    /**
     * Simple type class.
     */
    public final static class SimpleType extends Type {
        /**
         * Type enum.
         */
        public final TypeEnum type;

        /**
         * Constructor for the simple type node.
         *
         * @param type type enum
         */
        public SimpleType(TypeEnum type) {
            this.type = type;
        }
    }

    /**
     * Arrow type class.
     */
    public final static class ArrowType extends Type {
        /**
         * Input type node.
         */
        public final ASTNode input;
        /**
         * Output type node.
         */
        public final ASTNode output;

        /**
         * Constructor for the arrow type node.
         *
         * @param input  input type node
         * @param output output type node
         */
        public ArrowType(ASTNode input, ASTNode output) {
            this.input = input;
            this.output = output;
        }
    }
}
