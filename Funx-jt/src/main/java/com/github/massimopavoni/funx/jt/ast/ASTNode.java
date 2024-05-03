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
         * Declarations in the module.
         */
        public final ASTNode declarations;

        /**
         * Constructor for the module node.
         *
         * @param declarations declarations in the module
         */
        public Module(ASTNode declarations) {
            this.declarations = declarations;
        }
    }

    /**
     * Declarations node class.
     */
    public final static class Declarations extends ASTNode {
        /**
         * List of declarations.
         */
        public final List<ASTNode> declarationList;

        /**
         * Constructor for the Declarations node.
         *
         * @param declarationList list of declarations
         */
        public Declarations(List<ASTNode> declarationList) {
            this.declarationList = declarationList;
        }
    }
}
