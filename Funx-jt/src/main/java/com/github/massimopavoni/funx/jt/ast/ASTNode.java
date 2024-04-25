package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.List;

public abstract class ASTNode {
    public static String fromLexerToken(int token) {
        return FunxLexer.VOCABULARY.getLiteralName(token).replaceAll("'", "");
    }

    @Override
    public abstract String toString();

    public final static class Program extends ASTNode {
        public final List<ASTNode> functions;

        public Program(List<ASTNode> functions) {
            this.functions = functions;
        }

        @Override
        public String toString() {
            return String.join("\n\n",
                    functions.stream()
                            .map(ASTNode::toString)
                            .toArray(String[]::new));
        }
    }
}
