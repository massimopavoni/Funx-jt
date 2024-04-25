package com.github.massimopavoni.funx.jt.ast;

import java.util.Arrays;

public enum TypeEnum {
    BOOLEAN("Bool", Boolean.class),
    FLOATING("Float", Double.class),
    INTEGER("Int", Integer.class);

    private final String typeName;
    private final Class<?> typeClass;

    TypeEnum(String typeName, Class<?> typeClass) {
        this.typeName = typeName;
        this.typeClass = typeClass;
    }

    public static TypeEnum fromString(String typeName) {
        return Arrays.stream(TypeEnum.values())
                .filter(type -> type.getTypeName().equals(typeName))
                .findFirst()
                .orElse(null);
    }

    public String getTypeName() {
        return typeName;
    }

    public Class<?> getTypeClass() {
        return typeClass;
    }
}
