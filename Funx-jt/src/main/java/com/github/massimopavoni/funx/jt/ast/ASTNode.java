package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.List;

/**
 * Base class for every node in the AST.
 */
public abstract class ASTNode {
    /**
     * Package private default constructor,
     * preventing instantiation of generalization class from outside.
     */
    ASTNode() {
    }

    /**
     * Returns the string representation of a lexer token.
     * Put here instead of the lexer to avoid using java code snippets in ANTLR '.g4' grammar files.
     *
     * @param token lexer token
     * @return string representation of the token
     */
    public static String fromLexerToken(int token) {
        return FunxLexer.VOCABULARY.getLiteralName(token).replaceAll("'", "");
    }

    /**
     * Returns a unique identifier for the node.
     * Used for AST tree visualization.
     *
     * @return unique identifier using the hash code of the object
     */
    public String getNodeId() {
        return String.valueOf(hashCode());
    }

    /**
     * To string method override,
     * essentially re-prints the original source code.
     *
     * @return string representation of the node
     */
    @Override
    public abstract String toString();

    /**
     * Root node of the AST.
     */
    public final static class Program extends ASTNode {
        /**
         * List of functions in the program.
         */
        public final List<ASTNode> functions;

        /**
         * Constructor for the program node.
         *
         * @param functions list of functions in the program
         */
        public Program(List<ASTNode> functions) {
            this.functions = functions;
        }

        /**
         * To string method override,
         * essentially re-prints the original source code.
         *
         * @return string representation of the node
         */
        @Override
        public String toString() {
            return String.join("\n\n",
                    functions.stream()
                            .map(ASTNode::toString)
                            .toArray(String[]::new));
        }
    }
}
