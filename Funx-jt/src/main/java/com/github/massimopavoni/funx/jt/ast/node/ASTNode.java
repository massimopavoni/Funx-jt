package com.github.massimopavoni.funx.jt.ast.node;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;

import java.util.List;

/**
 * Base class for every node in the AST.
 */
public abstract sealed class ASTNode
        permits ASTNode.Module, ASTNode.Declarations, Declaration, Expression {
    /**
     * Position of the AST node in the input source code.
     */
    public final InputPosition inputPosition;

    /**
     * Package private default constructor,
     * preventing instantiation of generalization class from outside.
     *
     * @param inputPosition input source code node position
     */
    protected ASTNode(InputPosition inputPosition) {
        this.inputPosition = inputPosition;
    }

    /**
     * Accept a visitor to traverse the AST.
     *
     * @param visitor visitor to accept
     * @param <T>     return type of the visitor
     * @return result of the visit
     */
    public abstract <T> T accept(ASTVisitor<? extends T> visitor);

    /**
     * Root node of the AST.
     */
    public static final class Module extends ASTNode {
        /**
         * Module name.
         */
        public final String name;
        /**
         * Package name.
         */
        public final String packageName;
        /**
         * Let body of the module.
         */
        public final Expression.Let let;

        /**
         * Constructor for the module node.
         *
         * @param inputPosition input source code node position
         * @param name          module name
         * @param packageName   package name
         * @param let           let body of the module
         */
        public Module(InputPosition inputPosition, String name, String packageName, ASTNode let) {
            super(inputPosition);
            this.name = name;
            this.packageName = packageName;
            this.let = (Expression.Let) let;
        }

        /**
         * Accept a visitor to traverse the AST.
         *
         * @param visitor visitor to accept
         * @param <T>     return type of the visitor
         * @return result of the visit
         */
        @Override
        public <T> T accept(ASTVisitor<? extends T> visitor) {
            return visitor.visitModule(this);
        }
    }

    /**
     * Declarations node class.
     */
    public static final class Declarations extends ASTNode {
        /**
         * List of declarations.
         */
        public final List<Declaration> declarationList;

        /**
         * Constructor for the Declarations node.
         *
         * @param inputPosition   input source code node position
         * @param declarationList list of declarations
         */
        public Declarations(InputPosition inputPosition, List<ASTNode> declarationList) {
            super(inputPosition);
            this.declarationList = declarationList.stream()
                    .map(Declaration.class::cast)
                    .toList();
        }

        /**
         * Accept a visitor to traverse the AST.
         *
         * @param visitor visitor to accept
         * @param <T>     return type of the visitor
         * @return result of the visit
         */
        @Override
        public <T> T accept(ASTVisitor<? extends T> visitor) {
            return visitor.visitDeclarations(this);
        }
    }
}
