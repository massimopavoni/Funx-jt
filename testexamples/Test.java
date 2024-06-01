package com.github.massimopavoni.funx.lib;

import java.util.function.Function;

public class Test {
    public static void main(String[] args) {
        new Let<>() {
            private <A,B,C> Function<Function<B,C>, Function<Function<A,B>, Function<A,C>>> compose(){
                return f -> g -> x -> f.apply(g.apply(x));
            }

            private final Function<Boolean,Boolean> not = b -> !b;

            @Override
            public Void _eval() {
                System.out.println(this.<Boolean,Boolean,Boolean>compose().apply(FunxPrelude.not()).apply(FunxPrelude.not()).apply(false));
                return null;
            }
        }._eval();
    }

    @FunctionalInterface
    public interface Let<T> {
        T _eval();
    }

    public static final Function<Boolean,Boolean> doubleNot = b -> Test.<Boolean,Boolean,Boolean>compose().apply(FunxPrelude.not()).apply(FunxPrelude.not()).apply(b);

    public static <A,B,C> Function<Function<B,C>, Function<Function<A,B>, Function<A,C>>> compose(){
        return f -> g -> x -> f.apply(g.apply(x));
    }
}
