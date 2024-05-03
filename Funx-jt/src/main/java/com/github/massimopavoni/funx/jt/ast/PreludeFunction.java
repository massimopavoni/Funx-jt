package com.github.massimopavoni.funx.jt.ast;

import java.util.Arrays;

/**
 * Enum for symbols and corresponding Prelude functions.
 */
public enum PreludeFunction {
    NOT("!!", "not"),
    DIVIDE("/", "divide"),
    MODULO("%", "modulo"),
    MULTIPLY("*", "multiply"),
    ADD("+", "add"),
    SUBTRACT("-", "subtract"),
    GREATER_THAN(">", "greaterThan"),
    GREATER_THAN_EQUALS(">=", "greaterThanEquals"),
    LESS_THAN("<", "lessThan"),
    LESS_THAN_EQUALS("<=", "lessThanEquals"),
    EQUALS_EQUALS("==", "equalsEquals"),
    NOT_EQUALS("!=", "notEquals");

    /**
     * Prelude function symbol.
     */
    public final String functionSymbol;
    /**
     * Prelude function name.
     */
    public final String functionName;

    /**
     * Constructor for the Prelude function enum.
     *
     * @param functionSymbol function symbol
     * @param functionName   function name
     */
    PreludeFunction(String functionSymbol, String functionName) {
        this.functionSymbol = functionSymbol;
        this.functionName = functionName;
    }

    /**
     * Get the Prelude function enum from the function symbol.
     *
     * @param functionSymbol function symbol
     * @return Prelude function enum
     */
    public static PreludeFunction fromFunctionSymbol(String functionSymbol) {
        return Arrays.stream(PreludeFunction.values())
                .filter(function -> function.functionSymbol.equals(functionSymbol))
                .findFirst()
                .orElse(null);
    }
}
