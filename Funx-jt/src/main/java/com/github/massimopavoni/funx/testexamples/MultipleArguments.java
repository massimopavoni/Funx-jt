package com.github.massimopavoni.funx.testexamples;

import java.util.function.Function;

// What about a multiple arguments function?
//
// const x y = x
public class MultipleArguments {
    public static void main(String[] args) {
        // id const R> const
        assert SimpleExpression.Id.apply(Const.function()).equals(Const.function());
        // const 1 R> \y .> 1
        assert Const.apply(1) instanceof Function<Object, Integer>;
        // const 1 2 R> 1 as full apply
        assert Const.fullApply(1, 2).equals(1);
        // const 1 2 R> 1 as partial apply
        assert Const.apply(1).apply(2).equals(1);
        // id (const 1) 2 R> id (\y .> 1) 2 R> (\y .> 1) 2 R> 1
        assert SimpleExpression.Id.apply(Const.apply(1)).apply(2).equals(1);
    }

    // The concept of partial application and currying is introduced
    public static class Const {
        public static <X, Y> Function<X, Function<Y, X>> function() {
            return x -> y -> x;
            // or return x -> Const.apply(x); ?
        }

        public static <X,Y> Function<Y,X> apply(X x) {
            return y -> x;
        }

        public static <X, Y> X fullApply(X x, Y y) {
            return x;
        }
    }
}
