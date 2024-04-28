package com.github.massimopavoni.funx.jt.ast.visitor;

/**
 * Exception thrown when an illegal AST node is encountered.
 */
public class IllegalASTNodeException extends IllegalArgumentException {
    /**
     * Constructor for an IllegalASTNodeException.
     *
     * @param message exception message
     */
    public IllegalASTNodeException(String message) {
        super(message);
    }
}
