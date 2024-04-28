package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;

/**
 * Base class for binary operator nodes.
 */
public abstract class BinaryOperator extends Expression.Operator {
    /**
     * Left operand node.
     */
    public final ASTNode left;
    /**
     * Right operand node.
     */
    public final ASTNode right;

    /**
     * Constructor for the binary operator node.
     *
     * @param left  left operand node
     * @param right right operand node
     */
    public BinaryOperator(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    /**
     * To string method override,
     * essentially re-prints the original source code.
     *
     * @return string representation of the node
     */
    @Override
    public String toString() {
        return String.format("%s %s %s", left.toString(), operatorString(), right.toString());
    }

    /**
     * Application binary operator class.
     */
    public final static class Application extends BinaryOperator {
        /**
         * Constructor for the application operator node.
         *
         * @param left  left operand node
         * @param right right operand node
         */
        public Application(ASTNode left, ASTNode right) {
            super(left, right);
        }

        /**
         * Get the operator string representation.
         *
         * @return operator string
         */
        @Override
        public String operatorString() {
            return " ";
        }

        /**
         * To string method override,
         * essentially re-prints the original source code.
         *
         * @return string representation of the node
         */
        @Override
        public String toString() {
            return String.format("%s%s%s", left.toString(), operatorString(), right.toString());
        }
    }

    /**
     * Division binary operator class.
     */
    public final static class Divide extends BinaryOperator {
        /**
         * Constructor for the division operator node.
         *
         * @param left  left operand node
         * @param right right operand node
         */
        public Divide(ASTNode left, ASTNode right) {
            super(left, right);
        }

        /**
         * Get the operator string representation.
         *
         * @return operator string
         */
        @Override
        public String operatorString() {
            return ASTNode.fromLexerToken(FunxLexer.Divide);
        }
    }

    /**
     * Modulo binary operator class.
     */
    public final static class Modulo extends BinaryOperator {
        /**
         * Constructor for the modulo operator node.
         *
         * @param left  left operand node
         * @param right right operand node
         */
        public Modulo(ASTNode left, ASTNode right) {
            super(left, right);
        }

        /**
         * Get the operator string representation.
         *
         * @return operator string
         */
        @Override
        public String operatorString() {
            return ASTNode.fromLexerToken(FunxLexer.Modulo);
        }
    }

    /**
     * Multiplication binary operator class.
     */
    public final static class Multiply extends BinaryOperator {
        /**
         * Constructor for the multiplication operator node.
         *
         * @param left  left operand node
         * @param right right operand node
         */
        public Multiply(ASTNode left, ASTNode right) {
            super(left, right);
        }

        /**
         * Get the operator string representation.
         *
         * @return operator string
         */
        @Override
        public String operatorString() {
            return ASTNode.fromLexerToken(FunxLexer.Multiply);
        }
    }

    /**
     * Addition binary operator class.
     */
    public final static class Add extends BinaryOperator {
        /**
         * Constructor for the addition operator node.
         *
         * @param left  left operand node
         * @param right right operand node
         */
        public Add(ASTNode left, ASTNode right) {
            super(left, right);
        }

        /**
         * Get the operator string representation.
         *
         * @return operator string
         */
        @Override
        public String operatorString() {
            return ASTNode.fromLexerToken(FunxLexer.Add);
        }
    }

    /**
     * Subtraction binary operator class.
     */
    public final static class Subtract extends BinaryOperator {
        /**
         * Constructor for the subtraction operator node.
         *
         * @param left  left operand node
         * @param right right operand node
         */
        public Subtract(ASTNode left, ASTNode right) {
            super(left, right);
        }

        /**
         * Get the operator string representation.
         *
         * @return operator string
         */
        @Override
        public String operatorString() {
            return ASTNode.fromLexerToken(FunxLexer.Subtract);
        }
    }

    /**
     * Greater than comparison binary operator class.
     */
    public final static class GreaterThan extends BinaryOperator {
        /**
         * Constructor for the greater than operator node.
         *
         * @param left  left operand node
         * @param right right operand node
         */
        public GreaterThan(ASTNode left, ASTNode right) {
            super(left, right);
        }

        /**
         * Get the operator string representation.
         *
         * @return operator string
         */
        @Override
        public String operatorString() {
            return ASTNode.fromLexerToken(FunxLexer.GreaterThan);
        }
    }

    /**
     * Greater than or equal comparison binary operator class.
     */
    public final static class GreaterThanEquals extends BinaryOperator {
        /**
         * Constructor for the greater than or equal operator node.
         *
         * @param left  left operand node
         * @param right right operand node
         */
        public GreaterThanEquals(ASTNode left, ASTNode right) {
            super(left, right);
        }

        /**
         * Get the operator string representation.
         *
         * @return operator string
         */
        @Override
        public String operatorString() {
            return ASTNode.fromLexerToken(FunxLexer.GreaterThanEquals);
        }
    }

    /**
     * Less than comparison binary operator class.
     */
    public final static class LessThan extends BinaryOperator {
        /**
         * Constructor for the less than operator node.
         *
         * @param left  left operand node
         * @param right right operand node
         */
        public LessThan(ASTNode left, ASTNode right) {
            super(left, right);
        }

        /**
         * Get the operator string representation.
         *
         * @return operator string
         */
        @Override
        public String operatorString() {
            return ASTNode.fromLexerToken(FunxLexer.LessThan);
        }
    }

    /**
     * Less than or equal comparison binary operator class.
     */
    public final static class LessThanEquals extends BinaryOperator {
        /**
         * Constructor for the less than or equal operator node.
         *
         * @param left  left operand node
         * @param right right operand node
         */
        public LessThanEquals(ASTNode left, ASTNode right) {
            super(left, right);
        }

        /**
         * Get the operator string representation.
         *
         * @return operator string
         */
        @Override
        public String operatorString() {
            return ASTNode.fromLexerToken(FunxLexer.LessThanEquals);
        }
    }

    /**
     * Equal comparison binary operator class.
     */
    public final static class EqualsEquals extends BinaryOperator {
        /**
         * Constructor for the equal operator node.
         *
         * @param left  left operand node
         * @param right right operand node
         */
        public EqualsEquals(ASTNode left, ASTNode right) {
            super(left, right);
        }

        /**
         * Get the operator string representation.
         *
         * @return operator string
         */
        @Override
        public String operatorString() {
            return ASTNode.fromLexerToken(FunxLexer.EqualsEquals);
        }
    }

    /**
     * Not equal comparison binary operator class.
     */
    public final static class NotEquals extends BinaryOperator {
        /**
         * Constructor for the not equal operator node.
         *
         * @param left  left operand node
         * @param right right operand node
         */
        public NotEquals(ASTNode left, ASTNode right) {
            super(left, right);
        }

        /**
         * Get the operator string representation.
         *
         * @return operator string
         */
        @Override
        public String operatorString() {
            return ASTNode.fromLexerToken(FunxLexer.NotEquals);
        }
    }

    /**
     * And boolean binary operator class.
     */
    public final static class And extends BinaryOperator {
        /**
         * Constructor for the and operator node.
         *
         * @param left  left operand node
         * @param right right operand node
         */
        public And(ASTNode left, ASTNode right) {
            super(left, right);
        }

        /**
         * Get the operator string representation.
         *
         * @return operator string
         */
        @Override
        public String operatorString() {
            return ASTNode.fromLexerToken(FunxLexer.And);
        }
    }

    /**
     * Or boolean binary operator class.
     */
    public final static class Or extends BinaryOperator {
        /**
         * Constructor for the or operator node.
         *
         * @param left  left operand node
         * @param right right operand node
         */
        public Or(ASTNode left, ASTNode right) {
            super(left, right);
        }

        /**
         * Get the operator string representation.
         *
         * @return operator string
         */
        @Override
        public String operatorString() {
            return ASTNode.fromLexerToken(FunxLexer.Or);
        }
    }
}
