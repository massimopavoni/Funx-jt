package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;

public final class Function extends ASTNode {
    public final ASTNode type;
    public final String id;
    public final ASTNode lambda;

    public Function(ASTNode type, String id, ASTNode lambda) {
        this.type = type;
        this.id = id;
        this.lambda = lambda;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s %s %s",
                type.toString(),
                id,
                ASTNode.fromLexerToken(FunxLexer.Equals),
                lambda.toString());
    }

    public final static class ParenType extends ASTNode {
        public final ASTNode type;

        public ParenType(ASTNode type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return String.format("%s%s%s",
                    ASTNode.fromLexerToken(FunxLexer.OpenParen),
                    type.toString(),
                    ASTNode.fromLexerToken(FunxLexer.CloseParen));
        }
    }

    public final static class Type extends ASTNode {
        public final TypeEnum type;

        public Type(TypeEnum type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type.getTypeName();
        }
    }

    public final static class ArrowType extends ASTNode {
        public final ASTNode input;
        public final ASTNode output;

        public ArrowType(ASTNode input, ASTNode output) {
            this.input = input;
            this.output = output;
        }

        @Override
        public String toString() {
            return String.format("%s %s %s",
                    input.toString(),
                    ASTNode.fromLexerToken(FunxLexer.Arrow),
                    output.toString());
        }
    }
}
