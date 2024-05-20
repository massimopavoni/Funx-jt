package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.visitor.ASTErrorReporter;

public final class InferenceEngine {
    private static long variableCounter = 0;
    private static final ASTErrorReporter errorReporter = new ASTErrorReporter();

    private InferenceEngine() {
    }

    public static Type.Variable newTypeVariable() {
        return new Type.Variable(variableCounter++);
    }

    /**
     * Retrieve the number of errors found.
     *
     * @return number of errors
     */
    public static int getErrorsCount() {
        return errorReporter.getErrorsCount();
    }

    /**
     * Report an error using the AST reporter instance.
     *
     * @param position error position
     * @param message  error message
     */
    public static void reportError(InputPosition position, String message) {
        errorReporter.reportError(String.format("%s %s", position, message));
    }

    public static void inferModuleTypes(Module module) {
        Environment env = new Environment();
    }
}
