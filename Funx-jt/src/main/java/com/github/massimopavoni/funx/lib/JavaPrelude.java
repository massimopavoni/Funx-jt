package com.github.massimopavoni.funx.lib;

import java.util.function.Function;

public class JavaPrelude {
    // Binary operators
    public static Function<Long, Function<Long, Long>> divide = x -> y -> x / y;

    public static Function<Long, Function<Long, Long>> modulo = x -> y -> x % y;

    public static Function<Long, Function<Long, Long>> multiply = x -> y -> x * y;

    public static Function<Long, Function<Long, Long>> add = x -> y -> x + y;

    public static Function<Long, Function<Long, Long>> subtract = x -> y -> x - y;

    public static Function<Long, Function<Long, Boolean>> greaterThan = x -> y -> x > y;

    public static Function<Long, Function<Long, Boolean>> greaterThanEquals = x -> y -> x >= y;

    public static Function<Long, Function<Long, Boolean>> lessThan = x -> y -> x < y;

    public static Function<Long, Function<Long, Boolean>> lessThanEquals = x -> y -> x <= y;

    public static <A> Function<A, Function<A, Boolean>> equalsEquals() {
        return x -> x::equals;
    }

    public static <A> Function<A, Function<A, Boolean>> notEquals() {
        return x -> y -> !x.equals(y);
    }

    // Let functional interface
    @FunctionalInterface
    public interface Let<T> {
        T _eval();
    }

    // Cast method for polymorphic functions instantiation
    // (essentially a bypass for the overly aggressive type erasure in Java)
    @SuppressWarnings("rawtypes, unchecked")
    public static <T extends Function> T _instantiationCast(Function f) {
        return (T) f;
    }
}
