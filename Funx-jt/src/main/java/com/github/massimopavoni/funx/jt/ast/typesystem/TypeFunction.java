package com.github.massimopavoni.funx.jt.ast.typesystem;

import com.github.massimopavoni.funx.jt.ast.Utils;
import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.function.Function;

public enum TypeFunction {
    ARROW(Utils.fromLexerToken(FunxLexer.Arrow), 2, Function.class),
    BOOLEAN(Utils.fromLexerToken(FunxLexer.BOOLTYPE), 0, Boolean.class),
    INTEGER(Utils.fromLexerToken(FunxLexer.INTTYPE), 0, Long.class);

    public final String id;
    public final int arity;
    public final Class<?> typeClass;

    TypeFunction(String id, int arity, Class<?> typeClass) {
        this.id = id;
        this.arity = arity;
        this.typeClass = typeClass;
    }

    public static TypeFunction fromId(String id) {
        return Utils.enumFromField(TypeFunction.class, tf -> tf.id.equals(id));
    }

    public static TypeFunction fromClass(Class<?> typeClass) {
        return Utils.enumFromField(TypeFunction.class, tf -> tf.typeClass.equals(typeClass));
    }
}
