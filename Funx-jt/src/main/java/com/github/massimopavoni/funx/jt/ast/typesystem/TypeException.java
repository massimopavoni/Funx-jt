package com.github.massimopavoni.funx.jt.ast.typesystem;

/**
 * Exception thrown when a type mismatch occurs.
 */
public class TypeException extends Exception {
    /**
     * Constructor for the type exception.
     *
     * @param expected expected type
     * @param actual   actual type
     */
    public TypeException(Type expected, Type actual) {
        super(String.format("could not match expected type '%s' with actual type '%s'", expected, actual));
    }
}
