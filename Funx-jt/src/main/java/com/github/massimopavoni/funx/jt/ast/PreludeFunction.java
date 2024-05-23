package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.ast.typesystem.Scheme;

import java.util.Set;

import static com.github.massimopavoni.funx.jt.ast.typesystem.Scheme.*;
import static com.github.massimopavoni.funx.jt.ast.typesystem.Type.FunctionApplication.arrowOf;
import static com.github.massimopavoni.funx.jt.ast.typesystem.Type.Variable.*;

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
    OR("||", "or", BOOLEAN_BINARY, false),
    /**
     * Identity function.
     */
    ID("id", "id",
            new Scheme(Set.of(0L),
                    arrowOf(ZERO, ZERO)), false),
    /**
     * Right associative function application.
     */
    APPLY("$", "apply",
            new Scheme(Set.of(0L, 1L),
                    arrowOf(arrowOf(ZERO, ONE), ZERO, ONE)), false),
    /**
     * Function composition.
     */
    COMPOSE(".", "compose",
            new Scheme(Set.of(0L, 1L, 2L),
                    arrowOf(arrowOf(ONE, TWO), arrowOf(ZERO, ONE), ZERO, TWO)), false),
    /**
     * Function arguments flip.
     */
    FLIP("flip", "flip",
            new Scheme(Set.of(0L, 1L, 2L),
                    arrowOf(arrowOf(ZERO, ONE, TWO), ONE, ZERO, TWO)), false);

    /**
     * Prelude function symbol.
     */
    public final String symbol;
    /**
     * Prelude function id.
     */
    public final String id;
    /**
     * Prelude function scheme.
     */
    public final Scheme scheme;
    public final boolean nativeJava;

    /**
     * Constructor for the Prelude function enum.
     *
     * @param symbol function symbol
     * @param id     function id
     * @param scheme function scheme
     */
    PreludeFunction(String symbol, String id, Scheme scheme, boolean nativeJava) {
        this.symbol = symbol;
        this.id = id;
        this.scheme = scheme;
        this.nativeJava = nativeJava;
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
