package com.github.massimopavoni.funx.jt.cli;

import com.github.massimopavoni.funx.jt.ast.visitor.IllegalASTNodeException;
import com.github.massimopavoni.funx.jt.parser.IllegalParserStateException;
import picocli.CommandLine;

/**
 * Exception handler for the command line interface execution.
 */
public class ExceptionHandler implements CommandLine.IExecutionExceptionHandler {
    /**
     * Default constructor.
     */
    public ExceptionHandler() {
    }

    /**
     * Handle the exception thrown during command line interface execution.
     *
     * @param e           encountered exception
     * @param commandLine command line instance
     * @param parseResult argument parsing result
     * @return exit code
     */
    @Override
    public int handleExecutionException(Exception e, CommandLine commandLine, CommandLine.ParseResult parseResult) {
        String message = String.format("%s: %s", switch (e) {
            case CLIException clie -> String.format("CLI error%s",
                    clie.getCause() != null
                            ? String.format(" (%s)", clie.getCause().getMessage())
                            : "");
            case IllegalASTNodeException ignored -> "Illegal AST node";
            case IllegalParserStateException ignored -> "Illegal parser state";
            default -> "Unknown error";
        }, e.getMessage());
        commandLine.getErr().println(commandLine.getColorScheme().errorText(message));
        return commandLine.getCommandSpec().exitCodeOnExecutionException();
    }
}