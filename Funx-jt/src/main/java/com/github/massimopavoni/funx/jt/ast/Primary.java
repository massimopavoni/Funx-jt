package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.Collections;

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
     * Parenthesized primary class.
     */
    public final static class Parenthesized extends Primary {
        /**
         * Parenthesized statement node.
         */
        public final ASTNode statement;

        /**
         * Constructor for the parenthesized primary node.
         *
         * @param statement statement node
         */
        public Parenthesized(ASTNode statement) {
            this.statement = statement;
        }

        /**
         * Method for AST tree visualization.
         *
         * @param builder Graphviz code string builder
         * @return node identifier
         */
        @Override
        public String toGraphviz(StringBuilder builder) {
            return statement.toGraphviz(builder);
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
                    statement.toString(),
                    ASTNode.fromLexerToken(FunxLexer.CloseParen));
        }
    }

    /**
     * Literal primary class.
     */
    public final static class Literal extends Primary {
        /**
         * Literal value.
         */
        public final Object value;

        /**
         * Constructor for the literal primary node.
         *
         * @param value literal value
         */
        public Literal(Object value) {
            this.value = value;
        }

        /**
         * Method for AST tree visualization.
         *
         * @param builder Graphviz code string builder
         * @return node identifier
         */
        @Override
        public String toGraphviz(StringBuilder builder) {
            return toGraphvizDefault(builder, value.toString(), Collections.emptyList());
        }

        /**
         * To string method override,
         * essentially re-prints the original source code.
         *
         * @return string representation of the node
         */
        @Override
        public String toString() {
            return value.toString();
        }
    }

    /**
     * Function primary class.
     */
    public final static class Fun extends Primary {
        /**
         * Function identifier.
         */
        public final String funId;

        /**
         * Constructor for the function primary node.
         *
         * @param funId function identifier
         */
        public Fun(String funId) {
            this.funId = funId;
        }

        /**
         * Method for AST tree visualization.
         *
         * @param builder Graphviz code string builder
         * @return node identifier
         */
        @Override
        public String toGraphviz(StringBuilder builder) {
            return toGraphvizDefault(builder, funId, Collections.emptyList());
        }

        /**
         * To string method override,
         * essentially re-prints the original source code.
         *
         * @return string representation of the node
         */
        @Override
        public String toString() {
            return funId;
        }
    }
}
