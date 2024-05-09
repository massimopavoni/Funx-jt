package com.github.massimopavoni.funx.jt.ast.node;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;

/**
 * Base class for expression nodes.
 */
public abstract class Expression extends ASTNode {
    /**
     * Package private default constructor,
     * preventing instantiation of generalization class from outside.
     *
     * @param inputPosition input source code node position
     */
    Expression(InputPosition inputPosition) {
        super(inputPosition);
    }

    /**
     * Constant expression class.
     */
    public final static class Constant extends Expression {
        /**
         * Constant value.
         */
        public final Object value;

        /**
         * Constructor for the constant expression node.
         *
         * @param inputPosition input source code node position
         * @param value         constant value
         */
        public Constant(InputPosition inputPosition, Object value) {
            super(inputPosition);
            this.value = value;
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
            return visitor.visitConstant(this);
        }
    }

    /**
     * Variable expression class.
     */
    public final static class Variable extends Expression {
        /**
         * Variable identifier.
         */
        public final String id;

        /**
         * Constructor for the variable expression node.
         *
         * @param inputPosition input source code node position
         * @param id            variable identifier
         */
        public Variable(InputPosition inputPosition, String id) {
            super(inputPosition);
            this.id = id;
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
            return visitor.visitVariable(this);
        }
    }

    /**
     * Application expression class.
     */
    public static final class Application extends Expression {
        /**
         * Application left node.
         */
        public final ASTNode left;
        /**
         * Application right node.
         */
        public final ASTNode right;

        /**
         * Constructor for the application expression node.
         *
         * @param inputPosition input source code node position
         * @param left          left node
         * @param right         right node
         */
        public Application(InputPosition inputPosition, ASTNode left, ASTNode right) {
            super(inputPosition);
            this.left = left;
            this.right = right;
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
            return visitor.visitApplication(this);
        }
    }

    /**
     * Lambda expression class.
     */
    public final static class Lambda extends Expression {
        /**
         * Parameter identifier.
         */
        public final String paramId;
        /**
         * Expression node.
         */
        public final ASTNode expression;

        /**
         * Constructor for the lambda expression node.
         *
         * @param inputPosition input source code node position
         * @param paramId       parameter identifier
         * @param expression    expression node
         */
        public Lambda(InputPosition inputPosition, String paramId, ASTNode expression) {
            super(inputPosition);
            this.paramId = paramId;
            this.expression = expression;
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
            return visitor.visitLambda(this);
        }
    }

    /**
     * Let expression class.
     */
    public final static class Let extends Expression {
        /**
         * Local declarations node.
         */
        public final ASTNode localDeclarations;
        /**
         * Expression node.
         */
        public final ASTNode expression;

        /**
         * Constructor for the let expression node.
         *
         * @param inputPosition     input source code node position
         * @param localDeclarations local declarations node
         * @param expression        expression node
         */
        public Let(InputPosition inputPosition, ASTNode localDeclarations, ASTNode expression) {
            super(inputPosition);
            this.localDeclarations = localDeclarations;
            this.expression = expression;
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
            return visitor.visitLet(this);
        }
    }

    /**
     * If expression class.
     */
    public final static class If extends Expression {
        /**
         * Condition node.
         */
        public final ASTNode condition;
        /**
         * Then branch node.
         */
        public final ASTNode thenBranch;
        /**
         * Else branch node.
         */
        public final ASTNode elseBranch;

        /**
         * Constructor for the if expression node.
         *
         * @param inputPosition input source code node position
         * @param condition     condition node
         * @param thenBranch    then branch node
         * @param elseBranch    else branch node
         */
        public If(InputPosition inputPosition, ASTNode condition, ASTNode thenBranch, ASTNode elseBranch) {
            super(inputPosition);
            this.condition = condition;
            this.thenBranch = thenBranch;
            this.elseBranch = elseBranch;
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
            return visitor.visitIf(this);
        }
    }
}
