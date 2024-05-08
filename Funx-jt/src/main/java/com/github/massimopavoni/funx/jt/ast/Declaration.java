package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;

/**
 * Declaration node class.
 */
public class Declaration extends ASTNode {
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
     * Statement node.
     */
    public final ASTNode statement;

    /**
     * Constructor for the declaration node.
     *
     * @param typeVarId type identifier
     * @param type      type node
     * @param id        identifier
     * @param statement statement node
     */
    public Declaration(String typeVarId, ASTNode type, String id, ASTNode statement) {
        this.typeVarId = typeVarId;
        this.type = type;
        this.id = id;
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
        visitor.setCurrentDeclaration(id);
        return visitor.visitDeclaration(this);
    }
}
