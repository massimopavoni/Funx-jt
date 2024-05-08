package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;

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

        /**
         * Accepts a visitor to traverse the AST.
         *
         * @param visitor visitor to accept
         * @param <T>     return type of the visitor
         * @return the result of the visit
         */
        @Override
        public <T> T accept(ASTVisitor<? extends T> visitor) {
            return visitor.visitSimpleType(this);
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

        /**
         * Accepts a visitor to traverse the AST.
         *
         * @param visitor visitor to accept
         * @param <T>     return type of the visitor
         * @return the result of the visit
         */
        @Override
        public <T> T accept(ASTVisitor<? extends T> visitor) {
            return visitor.visitArrowType(this);
        }
    }
}
