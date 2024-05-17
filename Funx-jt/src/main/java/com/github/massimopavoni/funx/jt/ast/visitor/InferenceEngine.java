package com.github.massimopavoni.funx.jt.ast.visitor;

import com.github.massimopavoni.funx.jt.ast.typesystem.Type;

public final class InferenceEngine extends ASTVisitor<Void> {
    private static long variableCounter = 0;

    public InferenceEngine() {
    }

    public static Type.Variable newTypeVariable() {
        return new Type.Variable(variableCounter++);
    }
}
