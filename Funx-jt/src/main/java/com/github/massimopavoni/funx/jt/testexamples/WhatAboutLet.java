package com.github.massimopavoni.funx.jt.testexamples;

import java.util.function.Function;

// What will we do w̶i̶t̶h̶ a̶ d̶r̶u̶n̶k̶e̶n̶ s̶a̶i̶l̶o̶r̶?̶ when we need some anonymous functions in a let expression?
//
// f x y = let id x = x in id x
public class WhatAboutLet {
    public static void main(String[] args) {
        // id const R> const
        assert SimpleExpression.Id.apply(F.function()).equals(F.function());
        // const 1 R> \y .> id 1
        assert F.apply(1) instanceof Function<Object, Integer>;
        // const 1 2 R> 1 as full apply
        assert F.fullApply(1, 2).equals(1);
        // const 1 2 R> 1 as partial apply
        assert F.apply(1).apply(2).equals(1);
        // id (const 1) 2 R> id (\y .> id 1) 2 R> (\y .> id 1) 2 R> 1
        assert SimpleExpression.Id.apply(F.apply(1)).apply(2).equals(1);
    }

    // A let expressions makes it necessary to use some other functions inside the function,
    // but they should be anonymous -> more nested classes is probably the best option (this time they're private)
    public static class F {
        public static <X, Y> Function<X, Function<Y, X>> function() {
            return x -> y -> Id.apply(x);
        }

        private static class Id {
            public static <X> Function<X, X> function() {
                return x -> x;
            }

            public static <X> X apply(X x) {
                return x;
            }

            public static <X> X fullApply(X x) {
                return x;
            }
        }

        public static <X,Y> Function<Y,X> apply(X x) {
            return y -> Id.apply(x);
        }

        public static <X, Y> X fullApply(X x, Y y) {
            return Id.apply(x);
        }
    }
}
