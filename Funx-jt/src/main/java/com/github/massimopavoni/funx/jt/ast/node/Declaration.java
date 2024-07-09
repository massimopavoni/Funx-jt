package com.github.massimopavoni.funx.jt.ast.node;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.typesystem.*;
import com.github.massimopavoni.funx.jt.ast.visitor.ASTVisitor;

/**
 * Declaration node class.
 */
public final class Declaration extends ASTNode {
    /**
     * Type identifier.
     */
    public final String typeId;
    /**
     * Identifier.
     */
    public final String id;
    /**
     * Expression node.
     */
    public final Expression expression;
    /**
     * Expected declaration scheme.
     */
    private Scheme scheme;

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

    /**
     * Declaration scheme getter.
     *
     * @return declaration scheme
     */
    public Scheme scheme() {
        return scheme;
    }

    /**
     * Check an expected scheme against the actual scheme.
     *
     * @param expectedScheme expected scheme
     */
    public void checkScheme(Scheme expectedScheme) {
        // if there's a user defined type
        if (typeId != null) {
            // check if ids match
            if (!typeId.equals(id))
                InferenceEngine.reportError(inputPosition,
                        String.format("type identifier '%s' does not match declaration identifier '%s'",
                                typeId, id));
            try {
                // try to unify the expected type with the actual type
                // (this order of unification means that if the actual scheme corresponds
                // to any kind of instantiation of the expected scheme, the unification will succeed
                // and the scheme of the declaration will obviously be a restriction of the expected scheme)
                Substitution unification = expectedScheme.type.unify(scheme.type);
                Type expectedType = expectedScheme.type.applySubstitution(unification);
                if (expectedType.equals(scheme.type))
                    // propagate the substitution
                    expression.propagateSubstitution(unification);
                else
                    InferenceEngine.reportError(inputPosition,
                            String.format("could not match expected type '%s' with actual type '%s'",
                                    expectedScheme, scheme));
            } catch (TypeException e) {
                InferenceEngine.reportError(inputPosition, e.getMessage());
            }
        } else
            scheme = expectedScheme;
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
        return visitor.visitDeclaration(this);
    }
}
