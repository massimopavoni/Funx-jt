package com.github.massimopavoni.funx.jt.ast.typesystem;

/**
 * Exception thrown when an inference error occurs.
 */
public final class InferenceException extends RuntimeException {
    /**
     * Constructor for the inference exception.
     *
     * @param message exception message
     */
    public InferenceException(String message) {
        super(message);
    }
}
