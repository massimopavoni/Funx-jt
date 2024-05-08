package com.github.massimopavoni.funx.jt.ast;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Useful static methods for AST operations.
 */
public final class Utils {
    /**
     * Get the enum constant from an enum by filtering on a filter.
     *
     * @param enumClass   enum class to use
     * @param fieldFilter filter to apply
     * @param <E>         enum generic parameter
     * @return enum constant or null if not found
     */
    public static <E extends Enum<E>> E enumFromField(Class<E> enumClass, Predicate<E> fieldFilter) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(fieldFilter)
                .findFirst()
                .orElse(null);
    }
}
