package com.github.massimopavoni.funx.jt.testexamples;

import java.util.function.Function;

public class Prelude {
    // Unary operators

    // This can be written in funx as
    // not : Bool -> Bool
    // not x = if x then False else True
    public static Function<Boolean, Boolean> not() {
        return x -> !x;
    }

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

    public static Function<Object, Function<Object, Boolean>> equalsEquals() {
        return x -> x::equals;
    }

    public static Function<Object, Function<Object, Boolean>> notEquals() {
        return x -> y -> !x.equals(y);
    }

    // Let functional interface
    @FunctionalInterface
    public interface Let<T> {
        T _eval();
    }
}
