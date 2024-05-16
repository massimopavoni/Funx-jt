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
    NOT("!!", "not", BOOLEAN_FUNCTION),
    /**
     * Arithmetic division.
     */
    DIVIDE("/", "divide", ARITHMETIC_FUNCTION),
    /**
     * Arithmetic modulo.
     */
    MODULO("%", "modulo", ARITHMETIC_FUNCTION),
    /**
     * Arithmetic multiplication.
     */
    MULTIPLY("*", "multiply", ARITHMETIC_FUNCTION),
    /**
     * Arithmetic addition.
     */
    ADD("+", "add", ARITHMETIC_FUNCTION),
    /**
     * Arithmetic subtraction.
     */
    SUBTRACT("-", "subtract", ARITHMETIC_FUNCTION),
    /**
     * Greater than comparison.
     */
    GREATER_THAN(">", "greaterThan", COMPARISON_FUNCTION),
    /**
     * Greater than or equal comparison.
     */
    GREATER_THAN_EQUALS(">=", "greaterThanEquals", COMPARISON_FUNCTION),
    /**
     * Less than comparison.
     */
    LESS_THAN("<", "lessThan", COMPARISON_FUNCTION),
    /**
     * Less than or equal comparison.
     */
    LESS_THAN_EQUALS("<=", "lessThanEquals", COMPARISON_FUNCTION),
    /**
     * Equal comparison.
     */
    EQUALS_EQUALS("==", "equalsEquals", EQUALITY_FUNCTION),
    /**
     * Not equal comparison.
     */
    NOT_EQUALS("!=", "notEquals", EQUALITY_FUNCTION);

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

    /**
     * Constructor for the Prelude function enum.
     *
     * @param symbol function symbol
     * @param name   function name
     * @param scheme function scheme
     */
    PreludeFunction(String symbol, String name, Scheme scheme) {
        this.symbol = symbol;
        this.name = name;
        this.scheme = scheme;
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
