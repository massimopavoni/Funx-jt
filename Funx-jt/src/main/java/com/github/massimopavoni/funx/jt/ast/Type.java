package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;

/**
 * Base class for type nodes.
 */
public abstract class Type extends ASTNode {
    /**
     * Package private default constructor,
     * preventing instantiation of generalization class.
     */
    Type() {
    }

    /**
     * Parenthesized type class.
     */
    public final static class ParenType extends Type {
        /**
         * Type node.
         */
        public final ASTNode type;

        /**
         * Constructor for the parenthesized type node.
         *
         * @param type type node
         */
        public ParenType(ASTNode type) {
            this.type = type;
        }

        /**
         * Method for AST tree visualization.
         *
         * @param builder Graphviz code string builder
         * @return node identifier
         */
        @Override
        public String toGraphviz(StringBuilder builder) {
            // currently unused
            return "";
        }

        /**
         * To string method override,
         * essentially re-prints the original source code.
         *
         * @return string representation of the node
         */
        @Override
        public String toString() {
            return String.format("%s%s%s",
                    ASTNode.fromLexerToken(FunxLexer.OpenParen),
                    type.toString(),
                    ASTNode.fromLexerToken(FunxLexer.CloseParen));
        }
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
         * Method for AST tree visualization.
         *
         * @param builder Graphviz code string builder
         * @return node identifier
         */
        @Override
        public String toGraphviz(StringBuilder builder) {
            // currently unused
            return "";
        }

        /**
         * To string method override,
         * essentially re-prints the original source code.
         *
         * @return string representation of the node
         */
        @Override
        public String toString() {
            return type.getTypeName();
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
         * Method for AST tree visualization.
         *
         * @param builder Graphviz code string builder
         * @return node identifier
         */
        @Override
        public String toGraphviz(StringBuilder builder) {
            // currently unused
            return "";
        }

        /**
         * To string method override,
         * essentially re-prints the original source code.
         *
         * @return string representation of the node
         */
        @Override
        public String toString() {
            return String.format("%s %s %s",
                    input.toString(),
                    ASTNode.fromLexerToken(FunxLexer.Arrow),
                    output.toString());
        }
    }
}
