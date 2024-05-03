package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.parser.FunxLexer;

import java.util.Arrays;

/**
 * Enum for type names and corresponding Java classes.
 */
public enum TypeEnum {
    /**
     * Boolean type.
     */
    BOOLEAN(ASTNode.fromLexerToken(FunxLexer.BOOLTYPE), Boolean.class),
    /**
     * Integer type.
     */
    INTEGER(ASTNode.fromLexerToken(FunxLexer.INTTYPE), Integer.class);

    /**
     * Funx type name.
     */
    public final String typeName;
    /**
     * Java type class.
     */
    public final Class<?> typeClass;

    /**
     * Constructor for the type enum.
     *
     * @param typeName  type name
     * @param typeClass type class
     */
    TypeEnum(String typeName, Class<?> typeClass) {
        this.typeName = typeName;
        this.typeClass = typeClass;
    }

    /**
     * Get the type enum from the type name.
     *
     * @param typeName type name
     * @return type enum
     */
    public static TypeEnum fromString(String typeName) {
        return Arrays.stream(TypeEnum.values())
                .filter(type -> type.typeName.equals(typeName))
                .findFirst()
                .orElse(null);
    }
}
