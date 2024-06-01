package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.github.massimopavoni.funx.jt.ast.InputPosition;
import com.github.massimopavoni.funx.jt.ast.PreludeFunction;
import com.github.massimopavoni.funx.jt.ast.node.ASTNode;
import com.github.massimopavoni.funx.jt.ast.visitor.ASTErrorReporter;

import java.util.Arrays;

/**
 * Type system inference engine static class.
 */
public final class InferenceEngine {
    /**
     * AST error reporter instance.
     */
    private static final ASTErrorReporter errorReporter = new ASTErrorReporter();
    /**
     * Fancy types flag, switching between latin and greek letters for type variables.
     */
    private static boolean fancyTypes = false;
    /**
     * Counter for new type variables.
     */
    private static long typeVariablesCounter = 0;

    /**
     * Static class constructor, private to prevent instantiation.
     *
     * @throws IllegalStateException if an attempt to instantiate the class is made
     */
    private InferenceEngine() {
        throw new IllegalStateException("Static class cannot be instantiated.");
    }

    /**
     * Set the fancy types flag.
     *
     * @param fancyTypes new flag value
     */
    public static void setFancyTypes(boolean fancyTypes) {
        InferenceEngine.fancyTypes = fancyTypes;
    }

    /**
     * Fancy types flag getter.
     *
     * @return fancy types flag
     */
    public static boolean fancyTypes() {
        return fancyTypes;
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
     * Report an error using the AST error reporter instance.
     *
     * @param position error position
     * @param message  error message
     */
    public static void reportError(InputPosition position, String message) {
        errorReporter.reportError(String.format("%s %s", position, message));
    }

    /**
     * Create a new type variable using the global counter.
     *
     * @return new type variable
     */
    public static Type.Variable newTypeVariable() {
        return new Type.Variable(typeVariablesCounter++);
    }

    /**
     * Type inference entry point for a module node.
     *
     * @param module module node
     */
    public static void inferModuleTypes(ASTNode.Module module) {
        Context ctx = new Context();
        // bind Prelude functions, excluding non Java native ones if we're compiling FunxPrelude
        Arrays.stream(PreludeFunction.values())
                .filter(module.name.equals("FunxPrelude")
                        ? fun -> fun.nativeJava
                        : fun -> true)
                .forEach(fun -> ctx.bind(fun.id, fun.scheme));
        module.let.infer(ctx);
    }
}
