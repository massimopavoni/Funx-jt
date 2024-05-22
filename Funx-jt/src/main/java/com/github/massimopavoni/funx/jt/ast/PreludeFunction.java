package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.ast.typesystem.Scheme;

import static com.github.massimopavoni.funx.jt.ast.typesystem.Scheme.*;

/**
 * Enum for symbols and corresponding Prelude functions.
 */
public enum PreludeFunction {
    /**
     * Boolean not.
     */
    NOT("!!", "not", BOOLEAN_UNARY, false),
    /**
     * Arithmetic division.
     */
    DIVIDE("/", "divide", ARITHMETIC_BINARY, true),
    /**
     * Arithmetic modulo.
     */
    MODULO("%", "modulo", ARITHMETIC_BINARY, true),
    /**
     * Arithmetic multiplication.
     */
    MULTIPLY("*", "multiply", ARITHMETIC_BINARY, true),
    /**
     * Arithmetic addition.
     */
    ADD("+", "add", ARITHMETIC_BINARY, true),
    /**
     * Arithmetic subtraction.
     */
    SUBTRACT("-", "subtract", ARITHMETIC_BINARY, true),
    /**
     * Greater than comparison.
     */
    GREATER_THAN(">", "greaterThan", COMPARISON_BINARY, true),
    /**
     * Greater than or equal comparison.
     */
    GREATER_THAN_EQUALS(">=", "greaterThanEquals", COMPARISON_BINARY, true),
    /**
     * Less than comparison.
     */
    LESS_THAN("<", "lessThan", COMPARISON_BINARY, true),
    /**
     * Less than or equal comparison.
     */
    LESS_THAN_EQUALS("<=", "lessThanEquals", COMPARISON_BINARY, true),
    /**
     * Equal comparison.
     */
    EQUALS_EQUALS("==", "equalsEquals", EQUALITY_BINARY, true),
    /**
     * Not equal comparison.
     */
    NOT_EQUALS("!=", "notEquals", EQUALITY_BINARY, true),
    /**
     * Strict logical and.
     */
    AND("&&", "and", BOOLEAN_BINARY, false),
    /**
     * Strict logical or.
     */
    OR("||", "or", BOOLEAN_BINARY, false);

    /**
     * Prelude function symbol.
     */
    public final String symbol;
    /**
     * Prelude function name.
     */
    public final String name;
    /**
     * Prelude function scheme.
     */
    public final Scheme scheme;
    public final boolean nativeJava;

    /**
     * Constructor for the Prelude function enum.
     *
     * @param symbol function symbol
     * @param name   function name
     * @param scheme function scheme
     */
    PreludeFunction(String symbol, String name, Scheme scheme, boolean nativeJava) {
        this.symbol = symbol;
        this.name = name;
        this.scheme = scheme;
        this.nativeJava = nativeJava;
    }

    /**
     * Get the Prelude function enum from the function name.
     *
     * @param name function name
     * @return Prelude function enum
     */
    public static PreludeFunction fromName(String name) {
        return Utils.enumFromField(PreludeFunction.class, f -> f.name.equals(name));
    }

    /**
     * Get the Prelude function enum from the function symbol.
     *
     * @param symbol function symbol
     * @return Prelude function enum
     */
    public static PreludeFunction fromSymbol(String symbol) {
        return Utils.enumFromField(PreludeFunction.class, f -> f.symbol.equals(symbol));
    }
}
