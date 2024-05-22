package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.PreludeFunction;
import com.github.massimopavoni.funx.jt.ast.node.ASTNode;
import com.github.massimopavoni.funx.jt.ast.visitor.ASTErrorReporter;

import java.util.Arrays;

public final class InferenceEngine {
    private static final ASTErrorReporter errorReporter = new ASTErrorReporter();
    private static long variableCounter = 0;

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

    public static void inferModuleTypes(ASTNode.Module module) {
        Environment env = new Environment();
        Arrays.stream(PreludeFunction.values())
                .filter(module.name.equals("FunxPrelude")
                        ? fun -> fun.nativeJava
                        : fun -> true)
                .forEach(fun -> env.bind(fun.name, fun.scheme));
        module.let.infer(env);
    }
}
