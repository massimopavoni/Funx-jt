package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;

import java.util.List;

/**
 * Base class for statement nodes.
 */
public abstract class Statement extends ASTNode {
    /**
     * Package private default constructor,
     * preventing instantiation of generalization class from outside.
     */
    Statement() {
    }

    /**
     * Lambda statement class.
     */
    public final static class Lambda extends Statement {
        /**
         * Parameter identifier.
         */
        public final String paramId;
        /**
         * Statement node.
         */
        public final ASTNode statement;

        /**
         * Constructor for the lambda statement node.
         *
         * @param paramId   parameter identifier
         * @param statement statement node
         */
        public Lambda(String paramId, ASTNode statement) {
            this.paramId = paramId;
            this.statement = statement;
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
     * Let statement class.
     */
    public final static class Let extends Statement {
        /**
         * Local declaration node.
         */
        public final ASTNode localDeclarations;
        /**
         * Statement node.
         */
        public final ASTNode statement;

        /**
         * Constructor for the let statement node.
         *
         * @param localDeclarations local declaration node
         * @param statement         statement node
         */
        public Let(ASTNode localDeclarations, ASTNode statement) {
            this.localDeclarations = localDeclarations;
            this.statement = statement;
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
     * If statement class.
     */
    public final static class If extends Statement {
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
         * Constructor for the if statement node.
         *
         * @param condition  condition node
         * @param thenBranch then branch node
         * @param elseBranch else branch node
         */
        public If(ASTNode condition, ASTNode thenBranch, ASTNode elseBranch) {
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
