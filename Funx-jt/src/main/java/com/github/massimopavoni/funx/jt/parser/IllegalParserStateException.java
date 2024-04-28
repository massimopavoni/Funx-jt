package com.github.massimopavoni.funx.jt.parser;

import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Exception thrown when the parser is in an illegal state.
 */
public class IllegalParserStateException extends IllegalStateException {
    /**
     * Constructor for an IllegalParserStateException.
     *
     * @param message exception message
     */
    public IllegalParserStateException(String message) {
        super(message);
    }

    /**
     * Constructor for an IllegalParserStateException with a parser context.
     *
     * @param ctx      parser context
     * @param expected expected input
     */
    public IllegalParserStateException(ParserRuleContext ctx, String expected) {
        super(String.format("line %d:%d mismatched input '%s' expecting %s%n",
                ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.start.getText(), expected));
    }
}
