package com.github.massimopavoni.funx.jt.parser;

import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Exception thrown when the parser is in an illegal state.
 */
public class IllegalParserStateException extends IllegalStateException {
    /**
     * Constructor for the illegal parser state exception.
     *
     * @param message exception message
     */
    public IllegalParserStateException(String message) {
        super(message);
    }

    /**
     * Constructor for the illegal parser state exception using a parser context.
     *
     * @param ctx      parser context
     * @param expected expected input
     */
    public IllegalParserStateException(ParserRuleContext ctx, String expected) {
        super(String.format("line %d:%d mismatched input '%s' expecting %s",
                ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.start.getText(), expected));
    }
}
