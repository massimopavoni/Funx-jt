package com.github.massimopavoni.funx.lib;

import java.util.function.Function;

public class Test {
    public static void main(String[] args) {
        new Let<>() {
            private <A,B,C> Function<Function<B,C>, Function<Function<A,B>, Function<A,C>>> compose(){
                return f -> g -> x -> f.apply(g.apply(x));
            }

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
}
