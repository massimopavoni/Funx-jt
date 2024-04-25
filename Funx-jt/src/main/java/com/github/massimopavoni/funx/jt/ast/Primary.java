package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.Collections;

public abstract class Primary extends Expression {
    public final static class Parenthesized extends Primary {
        public final ASTNode statement;

        public Parenthesized(ASTNode statement) {
            this.statement = statement;
        }

        @Override
        public String toGraphviz(StringBuilder builder) {
            return statement.toGraphviz(builder);
        }

        @Override
        public String toString() {
            return String.format("%s%s%s",
                    ASTNode.fromLexerToken(FunxLexer.OpenParen),
                    statement.toString(),
                    ASTNode.fromLexerToken(FunxLexer.CloseParen));
        }
    }

    public final static class Literal extends Primary {
        public final Object value;

        public Literal(Object value) {
            this.value = value;
        }

        @Override
        public String toGraphviz(StringBuilder builder) {
            return toGraphvizDefault(builder, value.toString(), Collections.emptyList());
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public final static class Fun extends Primary {
        public final String funId;

        public Fun(String funId) {
            this.funId = funId;
        }

        @Override
        public String toGraphviz(StringBuilder builder) {
            return toGraphvizDefault(builder, funId, Collections.emptyList());
        }

        @Override
        public String toString() {
            return funId;
        }
    }
}
