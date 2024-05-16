package com.github.massimopavoni.funx.lib;

import java.util.function.Function;

public class JavaPrelude {
    // Binary operators
    public static Function<Integer, Function<Integer, Integer>> divide() {
        return x -> y -> x / y;
    }

    public static Function<Integer, Function<Integer, Integer>> modulo() {
        return x -> y -> x % y;
    }

    public static Function<Integer, Function<Integer, Integer>> multiply() {
        return x -> y -> x * y;
    }

    public static Function<Integer, Function<Integer, Integer>> add() {
        return x -> y -> x + y;
    }

    public static Function<Integer, Function<Integer, Integer>> subtract() {
        return x -> y -> x - y;
    }

    public static Function<Integer, Function<Integer, Boolean>> greaterThan() {
        return x -> y -> x > y;
    }

    public static Function<Integer, Function<Integer, Boolean>> greaterThanEquals() {
        return x -> y -> x >= y;
    }

    public static Function<Integer, Function<Integer, Boolean>> lessThan() {
        return x -> y -> x < y;
    }

    public static Function<Integer, Function<Integer, Boolean>> lessThanEquals() {
        return x -> y -> x <= y;
    }

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
}
