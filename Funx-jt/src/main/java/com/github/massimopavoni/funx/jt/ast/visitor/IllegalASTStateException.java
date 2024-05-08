package com.github.massimopavoni.funx.jt.ast.visitor;

/**
 * Exception thrown when an illegal AST is being visited.
 */
public class IllegalASTStateException extends IllegalStateException {
    /**
     * Constructor for an IllegalASTStateException.
     *
     * @param message exception message
     */
    public IllegalASTStateException(String message) {
        super(message);
    }
}
