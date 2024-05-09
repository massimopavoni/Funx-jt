package com.github.massimopavoni.funx.testexamples;

import java.util.function.Function;

// Recursion is kinda free
public class Recursion {
    public static void main(String[] args) {
        assert factorial().apply(20L).equals(2432902008176640000L);
    }

    // But it's clear that with the method approach (as opposed to nested class-based),
    // mutual recursion is not possible
    // Furthermore, this example starts making it clear that polymorphic functions with type constraints
    // for using specific other functions or primitive operations (e.g. numbers operators) are going to be
    // a bit of a problem, and some typing shenanigans might happen during AST translation
    public static Function<Long, Long> factorial() {
        Function<Long, Boolean> equalsZero = x -> x.equals(0L);
        Function<Long, Function<Long, Long>> multiply = x -> y -> x * y;
        Function<Long, Long> subtractOne = x -> x - 1;
        return x -> equalsZero.apply(x) ? 1 : multiply.apply(x).apply(factorial().apply(subtractOne.apply(x)));
    }
}
