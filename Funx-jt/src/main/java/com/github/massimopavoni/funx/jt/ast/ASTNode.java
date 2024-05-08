package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;
import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
     * Accepts a visitor to traverse the AST.
     *
     * @param visitor visitor to accept
     * @param <T>     return type of the visitor
     * @return the result of the visit
     */
    public abstract <T> T accept(ASTVisitor<? extends T> visitor);

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

        /**
         * Accepts a visitor to traverse the AST.
         *
         * @param visitor visitor to accept
         * @param <T>     return type of the visitor
         * @return the result of the visit
         */
        @Override
        public <T> T accept(ASTVisitor<? extends T> visitor) {
            return visitor.visitModule(this);
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
         * Map of declaration identifiers and corresponding type.
         */
        public final Map<String, Type> declarationTypeMap;

        /**
         * Constructor for the Declarations node.
         *
         * @param declarationList list of declarations
         */
        public Declarations(List<ASTNode> declarationList) {
            this.declarationList = declarationList;
            declarationTypeMap = declarationList.stream()
                    .map(d -> (Declaration) d)
                    .collect(Collectors.toMap(d -> d.id, d -> (Type) d.type));
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
            return visitor.visitDeclarations(this);
        }
    }
}
