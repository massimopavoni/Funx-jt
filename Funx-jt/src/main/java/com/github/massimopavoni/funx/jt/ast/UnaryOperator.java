package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;

public abstract class UnaryOperator extends Expression.Operator {
    public final ASTNode operand;

    public UnaryOperator(ASTNode operand) {
        this.operand = operand;
    }

    private static String fromLexerUop(int uop) {
        return ASTNode.fromLexerToken(uop);
    }

    @Override
    public String toString() {
        return String.format("%s%s", operatorString(), operand.toString());
    }

    public final static class Not extends UnaryOperator {
        public Not(ASTNode operand) {
            super(operand);
        }

        @Override
        public String operatorString() {
            return UnaryOperator.fromLexerUop(FunxLexer.Not);
        }
    }
}
