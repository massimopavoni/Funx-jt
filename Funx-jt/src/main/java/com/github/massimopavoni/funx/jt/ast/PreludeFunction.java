package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.ast.node.Type;

import static com.github.massimopavoni.funx.jt.ast.node.Type.ArrowType.ARITHMETIC_FUNCTION_TYPE;
import static com.github.massimopavoni.funx.jt.ast.node.Type.ArrowType.COMPARISON_FUNCTION_TYPE;

/**
 * Enum for symbols and corresponding Prelude functions.
 */
public enum PreludeFunction {
    /**
     * Boolean not.
     */
    NOT("!!", "not",
            new Type.ArrowType(new Type.NamedType(TypeEnum.BOOLEAN),
                    new Type.NamedType(TypeEnum.BOOLEAN))),
    /**
     * Arithmetic division.
     */
    DIVIDE("/", "divide", ARITHMETIC_FUNCTION_TYPE),
    /**
     * Arithmetic modulo.
     */
    MODULO("%", "modulo", ARITHMETIC_FUNCTION_TYPE),
    /**
     * Arithmetic multiplication.
     */
    MULTIPLY("*", "multiply", ARITHMETIC_FUNCTION_TYPE),
    /**
     * Arithmetic addition.
     */
    ADD("+", "add", ARITHMETIC_FUNCTION_TYPE),
    /**
     * Arithmetic subtraction.
     */
    SUBTRACT("-", "subtract", ARITHMETIC_FUNCTION_TYPE),
    /**
     * Greater than comparison.
     */
    GREATER_THAN(">", "greaterThan", COMPARISON_FUNCTION_TYPE),
    /**
     * Greater than or equal comparison.
     */
    GREATER_THAN_EQUALS(">=", "greaterThanEquals", COMPARISON_FUNCTION_TYPE),
    /**
     * Less than comparison.
     */
    LESS_THAN("<", "lessThan", COMPARISON_FUNCTION_TYPE),
    /**
     * Less than or equal comparison.
     */
    LESS_THAN_EQUALS("<=", "lessThanEquals", COMPARISON_FUNCTION_TYPE),
    /**
     * Equal comparison.
     */
    EQUALS_EQUALS("==", "equalsEquals", COMPARISON_FUNCTION_TYPE),
    /**
     * Not equal comparison.
     */
    NOT_EQUALS("!=", "notEquals", COMPARISON_FUNCTION_TYPE);

    /**
     * Prelude function symbol.
     */
    public final String functionSymbol;
    /**
     * Prelude function name.
     */
    public final String functionName;
    /**
     * Prelude function type.
     */
    public final Type.ArrowType functionType;

    /**
     * Constructor for the Prelude function enum.
     *
     * @param functionSymbol function symbol
     * @param functionName   function name
     * @param functionType   function type
     */
    PreludeFunction(String functionSymbol, String functionName, Type.ArrowType functionType) {
        this.functionSymbol = functionSymbol;
        this.functionName = functionName;
        this.functionType = functionType;
    }

    /**
     * Get the Prelude function enum from the function name.
     *
     * @param functionName function name
     * @return Prelude function enum
     */
    public static PreludeFunction fromFunctionName(String functionName) {
        return Utils.enumFromField(PreludeFunction.class, f -> f.functionName.equals(functionName));
    }

    /**
     * Get the Prelude function enum from the function symbol.
     *
     * @param functionSymbol function symbol
     * @return Prelude function enum
     */
    public static PreludeFunction fromFunctionSymbol(String functionSymbol) {
        return Utils.enumFromField(PreludeFunction.class, f -> f.functionSymbol.equals(functionSymbol));
    }
}
