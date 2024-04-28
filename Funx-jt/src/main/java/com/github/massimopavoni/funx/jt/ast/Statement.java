package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;

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
         * Parameters node.
         */
        public final ASTNode params;
        /**
         * Statement node.
         */
        public final ASTNode statement;

        /**
         * Constructor for the lambda statement node.
         *
         * @param params    parameters node
         * @param statement statement node
         */
        public Lambda(ASTNode params, ASTNode statement) {
            this.params = params;
            this.statement = statement;
        }

        /**
         * To string method override,
         * essentially re-prints the original source code.
         *
         * @return string representation of the node
         */
        @Override
        public String toString() {
            return String.format("%s%s %s %s",
                    ASTNode.fromLexerToken(FunxLexer.Backslash),
                    params.toString(),
                    ASTNode.fromLexerToken(FunxLexer.Arrow),
                    statement.toString());
        }

        /**
         * Lambda parameter class.
         */
        public final static class Param extends ASTNode {
            /**
             * Parameter identifier.
             */
            public final String paramId;

            /**
             * Constructor for the lambda parameter node.
             *
             * @param paramId parameter identifier
             */
            public Param(String paramId) {
                this.paramId = paramId;
            }

            /**
             * To string method override,
             * essentially re-prints the original source code.
             *
             * @return string representation of the node
             */
            @Override
            public String toString() {
                return paramId;
            }
        }

        /**
         * Multiple lambda parameters class.
         */
        public final static class MultiParam extends ASTNode {
            /**
             * First parameter node.
             */
            public final ASTNode first;
            /**
             * Subsequent parameters node.
             */
            public final ASTNode second;

            /**
             * Constructor for the multiple lambda parameters node.
             *
             * @param first  first parameter node
             * @param second subsequent parameters node
             */
            public MultiParam(ASTNode first, ASTNode second) {
                this.first = first;
                this.second = second;
            }

            /**
             * To string method override,
             * essentially re-prints the original source code.
             *
             * @return string representation of the node
             */
            @Override
            public String toString() {
                return String.format("%s %s", first.toString(), second.toString());
            }
        }
    }

    /**
     * Let statement class.
     */
    public final static class Let extends Statement {
        /**
         * List of local function nodes.
         */
        public final List<ASTNode> localFunctions;
        /**
         * Statement node.
         */
        public final ASTNode statement;

        /**
         * Constructor for the let statement node.
         *
         * @param localFunctions list of local function nodes
         * @param statement      statement node
         */
        public Let(List<ASTNode> localFunctions, ASTNode statement) {
            this.localFunctions = localFunctions;
            this.statement = statement;
        }

        /**
         * To string method override,
         * essentially re-prints the original source code.
         *
         * @return string representation of the node
         */
        @Override
        public String toString() {
            return String.format("%s\n%s\n%s %s",
                    ASTNode.fromLexerToken(FunxLexer.LET),
                    String.join("\n", localFunctions.stream()
                            .map(ASTNode::toString)
                            .toArray(String[]::new)),
                    ASTNode.fromLexerToken(FunxLexer.IN),
                    statement.toString());
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
         * To string method override,
         * essentially re-prints the original source code.
         *
         * @return string representation of the node
         */
        @Override
        public String toString() {
            return String.format("%s %s %s %s %s %s",
                    ASTNode.fromLexerToken(FunxLexer.IF),
                    condition.toString(),
                    ASTNode.fromLexerToken(FunxLexer.THEN),
                    thenBranch.toString(),
                    ASTNode.fromLexerToken(FunxLexer.ELSE),
                    elseBranch.toString());
        }
    }
}
