package com.github.massimopavoni.funx.jt.ast;

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
    }

    /**
     * Let statement class.
     */
    public final static class Let extends Statement {
        /**
         * List of local declaration nodes.
         */
        public final List<ASTNode> localDeclarations;
        /**
         * Statement node.
         */
        public final ASTNode statement;

        /**
         * Constructor for the let statement node.
         *
         * @param localDeclarations list of local declaration nodes
         * @param statement         statement node
         */
        public Let(List<ASTNode> localDeclarations, ASTNode statement) {
            this.localDeclarations = localDeclarations;
            this.statement = statement;
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
    }
}
