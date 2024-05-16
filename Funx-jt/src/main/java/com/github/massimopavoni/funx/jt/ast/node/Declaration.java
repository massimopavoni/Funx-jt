package com.github.massimopavoni.funx.jt.ast.node;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.Utils;
import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;
import com.github.massimopavoni.funx.jt.parser.FunxLexer;

/**
 * Declaration node class.
 */
public final class Declaration extends ASTNode {
    /**
     * Type declaration identifier.
     */
    public final String typeVarId;
    /**
     * Type node.
     */
    public final ASTNode type;
    /**
     * Identifier.
     */
    public final String id;
    /**
     * Expression node.
     */
    public final ASTNode expression;

    /**
     * Constructor for the declaration node.
     *
     * @param inputPosition input source code node position
     * @param typeVarId     type identifier
     * @param type          type node
     * @param id            identifier
     * @param expression    expression node
     */
    public Declaration(InputPosition inputPosition, String typeVarId, ASTNode type, String id, ASTNode expression) {
        super(inputPosition);
        this.typeVarId = typeVarId;
        this.type = type;
        this.id = id;
        this.expression = expression;
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
        return id.equals(Utils.fromLexerToken(FunxLexer.MAIN))
                ? visitor.visitMain(this)
                : visitor.visitDeclaration(this);
    }
}
