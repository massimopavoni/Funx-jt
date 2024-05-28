package com.github.massimopavoni.funx.jt.ast.typesystem;

public class TypeException extends Exception {
    public TypeException(Type expected, Type actual) {
        super(String.format("could not match expected type '%s' with actual type '%s'", expected, actual));
    }
}
