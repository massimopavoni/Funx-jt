package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.github.massimopavoni.funx.jt.ast.Utils;
import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.function.Function;

public enum TypeFunction {
    ARROW(Utils.fromLexerToken(FunxLexer.Arrow), 2, Function.class),
    BOOLEAN(Utils.fromLexerToken(FunxLexer.BOOLTYPE), 0, Boolean.class),
    INTEGER(Utils.fromLexerToken(FunxLexer.INTTYPE), 0, Long.class);

    public final String name;
    public final int arity;
    public final Class<?> typeClass;

    TypeFunction(String name, int arity, Class<?> typeClass) {
        this.name = name;
        this.arity = arity;
        this.typeClass = typeClass;
    }

    public static TypeFunction fromName(String name) {
        return Utils.enumFromField(TypeFunction.class, tf -> tf.name.equals(name));
    }

    public static TypeFunction fromClass(Class<?> typeClass) {
        return Utils.enumFromField(TypeFunction.class, tf -> tf.typeClass.equals(typeClass));
    }
}
