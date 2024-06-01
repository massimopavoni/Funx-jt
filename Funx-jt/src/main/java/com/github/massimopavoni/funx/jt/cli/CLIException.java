package com.github.massimopavoni.funx.jt.cli;

/**
 * Command Line Interface exception.
 */
public class CLIException extends Exception {
    /**
     * Constructor for the CLI exception.
     *
     * @param message exception message
     */
    public CLIException(String message) {
        super(message);
    }

    /**
     * Constructor for the CLI exception with a cause.
     *
     * @param message exception message
     * @param cause   exception cause
     */
    public CLIException(String message, Throwable cause) {
        super(message, cause);
    }
}
