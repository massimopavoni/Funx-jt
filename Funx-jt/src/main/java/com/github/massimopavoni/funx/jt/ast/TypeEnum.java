package com.github.massimopavoni.funx.jt.ast;

import com.github.massimopavoni.funx.jt.ast.node.ASTNode;
import com.github.massimopavoni.funx.jt.parser.FunxLexer;

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
    public static TypeEnum fromTypeName(String typeName) {
        return Utils.enumFromField(TypeEnum.class, t -> t.typeName.equals(typeName));
    }

    /**
     * Get the type enum from the type class.
     *
     * @param typeClass type class
     * @return type enum
     */
    public static TypeEnum fromTypeClass(Class<?> typeClass) {
        return Utils.enumFromField(TypeEnum.class, t -> t.typeClass.equals(typeClass));
    }
}
