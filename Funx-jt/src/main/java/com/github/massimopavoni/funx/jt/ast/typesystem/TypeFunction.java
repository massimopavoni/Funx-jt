package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.github.massimopavoni.funx.jt.ast.Utils;
import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.function.Function;

/**
 * Enum for type functions.
 */
public enum TypeFunction {
    /**
     * Arrow type.
     */
    ARROW(Utils.fromLexerToken(FunxLexer.Arrow), 2, Function.class),
    /**
     * Boolean type.
     */
    BOOLEAN(Utils.fromLexerToken(FunxLexer.BOOLTYPE), 0, Boolean.class),
    /**
     * Integer type.
     */
    INTEGER(Utils.fromLexerToken(FunxLexer.INTTYPE), 0, Long.class);

    /**
     * Type function identifier.
     */
    public final String id;
    /**
     * Type function arity.
     */
    public final int arity;
    /**
     * Type function class.
     */
    public final Class<?> typeClass;

    /**
     * Constructor for the type function enum.
     *
     * @param id        function identifier
     * @param arity     function arity
     * @param typeClass function class
     */
    TypeFunction(String id, int arity, Class<?> typeClass) {
        this.id = id;
        this.arity = arity;
        this.typeClass = typeClass;
    }

    /**
     * Get the type function enum from the function identifier.
     *
     * @param id function identifier
     * @return type function enum
     */
    public static TypeFunction fromId(String id) {
        return Utils.enumFromField(TypeFunction.class, tf -> tf.id.equals(id));
    }

    /**
     * Get the type function enum from the function class.
     *
     * @param typeClass function class
     * @return type function enum
     */
    public static TypeFunction fromClass(Class<?> typeClass) {
        return Utils.enumFromField(TypeFunction.class, tf -> tf.typeClass.equals(typeClass));
    }
}
