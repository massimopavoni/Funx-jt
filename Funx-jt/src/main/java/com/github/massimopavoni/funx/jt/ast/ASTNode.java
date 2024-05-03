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
     * Root node of the AST.
     */
    public final static class Module extends ASTNode {
        /**
         * List of declarations in the module.
         */
        public final List<ASTNode> declarations;

        /**
         * Constructor for the module node.
         *
         * @param declarations list of declarations in the module
         */
        public Module(List<ASTNode> declarations) {
            this.declarations = declarations;
        }
    }
}
