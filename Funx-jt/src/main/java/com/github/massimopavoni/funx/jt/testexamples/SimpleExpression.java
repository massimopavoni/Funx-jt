package com.github.massimopavoni.funx.jt.testexamples;

import java.util.function.Function;

// Let's try to implement the identity function
//
// id x = x
public class SimpleExpression {
    public static void main(String[] args) {
        // id 1 R> 1
        assert Id.apply(1).equals(1);
        // id id R> id
        assert Id.apply(Id.function()).equals(Id.function());
        // id id 1 R> id 1 R> 1
        assert Id.apply(Id.function()).apply(1).equals(1);
        // id (id 1) R> id 1 R> 1
        assert Id.apply(Id.apply(Id.function()).apply(1)).equals(1);
    }

    // Simple enough
    public static class Id {
        public static <X> Function<X, X> function() {
            return x -> x;
        }

        public static <X> X apply(X x) {
            return x;
        }
    }
}
