package com.github.massimopavoni.funx.jt.ast.node;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.Utils;
import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;
import com.github.massimopavoni.funx.jt.ast.visitor.IllegalASTStateException;
import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Base class for every node in the AST.
 */
public sealed abstract class ASTNode
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
     * Accepts a visitor to traverse the AST.
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
         * Main declaration if present.
         */
        public final ASTNode main;
        /**
         * Declarations in the module.
         */
        public final ASTNode declarations;

        /**
         * Constructor for the module node.
         *
         * @param inputPosition input source code node position
         * @param name          module name
         * @param packageName   package name
         * @param main          main declaration
         * @param declarations  declarations in the module
         */
        public Module(InputPosition inputPosition, String name, String packageName,
                      ASTNode main, ASTNode declarations) {
            super(inputPosition);
            this.name = name;
            this.packageName = packageName;
            this.main = main;
            this.declarations = declarations;
        }

        /**
         * Accepts a visitor to traverse the AST.
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
        public final List<ASTNode> declarations;
        /**
         * Map of declaration identifiers and corresponding type.
         */
        public final Map<String, TrashType> declarationTypes;

        /**
         * Constructor for the Declarations node.
         *
         * @param inputPosition   input source code node position
         * @param declarationList list of declarations
         */
        public Declarations(InputPosition inputPosition, List<ASTNode> declarationList) {
            super(inputPosition);
            this.declarations = declarationList;
            Map<String, List<Declaration>> groupedDeclarations = declarationList.stream()
                    .map(d -> (Declaration) d)
                    .collect(Collectors.groupingBy(d -> d.id));
            groupedDeclarations.forEach((id, declarations) -> {
                String message = null;
                if (id.equals(Utils.fromLexerToken(FunxLexer.MAIN)))
                    message = String.format("%s declaration not at the beginning of the module",
                            Utils.fromLexerToken(FunxLexer.MAIN));
                if (declarations.size() > 1)
                    message = String.format("multiple declarations for identifier \"%s\"", id);
                if (message != null)
                    throw new IllegalASTStateException(String.format("%s at lines %s",
                            message,
                            String.join(", ",
                                    declarations.stream()
                                            .map(d -> String.format("%d:%d",
                                                    d.inputPosition.line(), d.inputPosition.column()))
                                            .toList())));
            });
            this.declarationTypes = groupedDeclarations.entrySet().stream()
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            e -> (TrashType) e.getValue().getFirst().type));
        }

        /**
         * Accepts a visitor to traverse the AST.
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
