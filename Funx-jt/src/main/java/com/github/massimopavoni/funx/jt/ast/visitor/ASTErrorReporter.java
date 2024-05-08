package com.github.massimopavoni.funx.jt.ast.visitor;

/**
 * Error reporter for the abstract syntax tree.
 */
public class ASTErrorReporter {
    /**
     * Errors count.
     */
    private int errorsCount;

    /**
     * Default constructor.
     */
    public ASTErrorReporter() {
        errorsCount = 0;
    }

    /**
     * Get the number of errors encountered.
     *
     * @return number of errors
     */
    public int getErrorsCount() {
        return errorsCount;
    }

    /**
     * Report an error.
     *
     * @param message expected input
     */
    public void reportError(String message) {
        errorsCount++;
        System.err.printf(message + '\n');
    }
}
