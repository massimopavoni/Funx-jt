package com.github.massimopavoni.funx.jt.ast.visitor;

/**
 * Exception thrown when an illegal AST is being visited.
 */
public class IllegalASTStateException extends IllegalStateException {
    /**
     * Constructor for the illegal AST state exception.
     *
     * @param message exception message
     */
    public IllegalASTStateException(String message) {
        super(message);
    }
}
