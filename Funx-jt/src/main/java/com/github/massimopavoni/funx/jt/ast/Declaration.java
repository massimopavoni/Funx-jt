package com.github.massimopavoni.funx.jt.ast;

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
}
