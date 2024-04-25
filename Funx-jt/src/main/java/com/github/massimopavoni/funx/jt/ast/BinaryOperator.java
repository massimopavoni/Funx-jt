package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.List;

public abstract class BinaryOperator extends Expression.Operator {
    public final ASTNode left;
    public final ASTNode right;

    public BinaryOperator(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    private static String fromLexerBop(int bop) {
        return String.format(" %s ", ASTNode.fromLexerToken(bop));
    }

    @Override
    public String toGraphviz(StringBuilder builder) {
        return toGraphvizDefault(builder, operatorString(), List.of(left, right));
    }

    @Override
    public String toString() {
        return String.format("%s%s%s", left.toString(), operatorString(), right.toString());
    }

    public final static class Application extends BinaryOperator {
        public Application(ASTNode left, ASTNode right) {
            super(left, right);
        }

        @Override
        public String toGraphviz(StringBuilder builder) {
            return toGraphvizDefault(builder, " $ ", List.of(left, right));
        }

        @Override
        public String operatorString() {
            return " ";
        }
    }

    public final static class Divide extends BinaryOperator {
        public Divide(ASTNode left, ASTNode right) {
            super(left, right);
        }

        @Override
        public String operatorString() {
            return BinaryOperator.fromLexerBop(FunxLexer.Divide);
        }
    }

    public final static class Modulo extends BinaryOperator {
        public Modulo(ASTNode left, ASTNode right) {
            super(left, right);
        }

        @Override
        public String operatorString() {
            return BinaryOperator.fromLexerBop(FunxLexer.Modulo);
        }
    }

    public final static class Multiply extends BinaryOperator {
        public Multiply(ASTNode left, ASTNode right) {
            super(left, right);
        }

        @Override
        public String operatorString() {
            return BinaryOperator.fromLexerBop(FunxLexer.Multiply);
        }
    }

    public final static class Add extends BinaryOperator {
        public Add(ASTNode left, ASTNode right) {
            super(left, right);
        }

        @Override
        public String operatorString() {
            return BinaryOperator.fromLexerBop(FunxLexer.Add);
        }
    }

    public final static class Subtract extends BinaryOperator {
        public Subtract(ASTNode left, ASTNode right) {
            super(left, right);
        }

        @Override
        public String operatorString() {
            return BinaryOperator.fromLexerBop(FunxLexer.Subtract);
        }
    }

    public final static class GreaterThan extends BinaryOperator {
        public GreaterThan(ASTNode left, ASTNode right) {
            super(left, right);
        }

        @Override
        public String operatorString() {
            return BinaryOperator.fromLexerBop(FunxLexer.GreaterThan);
        }
    }

    public final static class GreaterThanEquals extends BinaryOperator {
        public GreaterThanEquals(ASTNode left, ASTNode right) {
            super(left, right);
        }

        @Override
        public String operatorString() {
            return BinaryOperator.fromLexerBop(FunxLexer.GreaterThanEquals);
        }
    }

    public final static class LessThan extends BinaryOperator {
        public LessThan(ASTNode left, ASTNode right) {
            super(left, right);
        }

        @Override
        public String operatorString() {
            return BinaryOperator.fromLexerBop(FunxLexer.LessThan);
        }
    }

    public final static class LessThanEquals extends BinaryOperator {
        public LessThanEquals(ASTNode left, ASTNode right) {
            super(left, right);
        }

        @Override
        public String operatorString() {
            return BinaryOperator.fromLexerBop(FunxLexer.LessThanEquals);
        }
    }

    public final static class EqualsEquals extends BinaryOperator {
        public EqualsEquals(ASTNode left, ASTNode right) {
            super(left, right);
        }

        @Override
        public String operatorString() {
            return BinaryOperator.fromLexerBop(FunxLexer.EqualsEquals);
        }
    }

    public final static class NotEquals extends BinaryOperator {
        public NotEquals(ASTNode left, ASTNode right) {
            super(left, right);
        }

        @Override
        public String operatorString() {
            return BinaryOperator.fromLexerBop(FunxLexer.NotEquals);
        }
    }

    public final static class And extends BinaryOperator {
        public And(ASTNode left, ASTNode right) {
            super(left, right);
        }

        @Override
        public String operatorString() {
            return BinaryOperator.fromLexerBop(FunxLexer.And);
        }
    }

    public final static class Or extends BinaryOperator {
        public Or(ASTNode left, ASTNode right) {
            super(left, right);
        }

        @Override
        public String operatorString() {
            return BinaryOperator.fromLexerBop(FunxLexer.Or);
        }
    }
}
