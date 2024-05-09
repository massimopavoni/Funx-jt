package com.github.massimopavoni.funx.jt.ast;

/**
 * Class representing the position of an AST node in the input.
 *
 * @param line   line number
 * @param column column number
 */
public record InputPosition(int line, int column) {
    /**
     * Unknown position, should never pop up in the error messages.
     */
    public static final InputPosition UNKNOWN = new InputPosition(-1, -1);

    /**
     * To string method override for the input position.
     *
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return String.format("line %d:%d", line, column);
    }
}
