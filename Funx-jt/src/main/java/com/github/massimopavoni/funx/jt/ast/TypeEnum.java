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
    BOOLEAN(ASTNode.fromLexerToken(FunxLexer.BOOL), Boolean.class),
    /**
     * Floating type.
     */
    FLOATING(ASTNode.fromLexerToken(FunxLexer.FLOAT), Double.class),
    /**
     * Integer type.
     */
    INTEGER(ASTNode.fromLexerToken(FunxLexer.INT), Integer.class);

    /**
     * Funx type name.
     */
    private final String typeName;
    /**
     * Java type class.
     */
    private final Class<?> typeClass;

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
                .filter(type -> type.getTypeName().equals(typeName))
                .findFirst()
                .orElse(null);
    }

    /**
     * Type name getter.
     *
     * @return type name
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Type class getter.
     *
     * @return type class
     */
    public Class<?> getTypeClass() {
        return typeClass;
    }
}
