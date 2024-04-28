package com.github.massimopavoni.funx.jt.cli;

/**
 * Command Line Interface exception.
 */
public class CLIException extends Exception {
    /**
     * Constructor for a CLIException.
     *
     * @param message exception message
     */
    public CLIException(String message) {
        super(message);
    }

    /**
     * Constructor for a CLIException with a cause.
     *
     * @param message exception message
     * @param cause   exception cause
     */
    public CLIException(String message, Throwable cause) {
        super(message, cause);
    }
}
