package com.github.massimopavoni.funx.jt.ast.node;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.Utils;
import com.github.massimopavoni.funx.jt.ast.typesystem.*;
import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;
import com.github.massimopavoni.funx.jt.parser.FunxLexer;

/**
 * Declaration node class.
 */
public final class Declaration extends ASTNode {
    /**
     * Type identifier.
     */
    public final String typeId;
    /**
     * Expected declaration scheme.
     */
    public final Scheme scheme;
    /**
     * Identifier.
     */
    public final String id;
    /**
     * Expression node.
     */
    public final Expression expression;

    /**
     * Constructor for the declaration node.
     *
     * @param inputPosition input source code node position
     * @param typeId        type identifier
     * @param scheme        expected declaration scheme
     * @param id            identifier
     * @param expression    expression node
     */
    public Declaration(InputPosition inputPosition, String typeId, Scheme scheme, String id, ASTNode expression) {
        super(inputPosition);
        this.typeId = typeId;
        this.scheme = scheme;
        this.id = id;
        this.expression = (Expression) expression;
    }

    public void checkType() {
        if (scheme != null) {
            if (!typeId.equals(id))
                InferenceEngine.reportError(inputPosition,
                        String.format("type identifier '%s' does not match declaration identifier '%s'",
                                typeId, id));
            try {
                scheme.type.unify(expression.type);
            } catch (TypeException e) {
                InferenceEngine.reportError(inputPosition, e.getMessage());
            }
        }
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
