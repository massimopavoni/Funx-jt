package com.github.massimopavoni.funx.testexamples;

import java.util.function.Function;

public class SomeMorePolymorphicFunctions {
    public static void main(String[] args) {
        assert Apply
                .apply1(Const.function())
                .apply(1)
                .apply("ignore").equals(1);
        // This cannot work with the weak typesystem system of Java
        // System.out.println(ReverseApply.apply1(1).apply(Const.function()).apply("ignore"));
        // So that's why we need to use the apply2 method
        assert ReverseApply
                .apply2(2, Const.function())
                .apply("ignore").equals(2);
        // A not so bad possible solution to this problem could be to use typesystem witnesses
        assert ReverseApply
                .<Integer, Function<String, Integer>>apply1(3)
                .apply(Const.function())
                .apply("ignore").equals(3);
        // Might not actually be a big problem, since we can probably implement some rules to
        // always use the apply method with the most arguments available (there will still be
        // some cases where types will be annoying like this, and we can always resort to
        // typesystem witnesses, once again)
        // Another solution is to embrace the object-oriented paradigm and use normal parametrized classes,
        // instead of static classes with static methods (this might not be a good shot, though)
        // ---- Other examples ----
        assert Flip
                .apply1(Const.function())
                .apply(4)
                .apply("no ignore").equals("no ignore");
        assert Fix
                .<Long>apply1(f -> n -> n <= 1 ? 1 : n * f
                        .apply(f)
                        .apply(n - 1))
                .apply(20L).equals(2432902008176640000L);
        System.out.println(Fix
                .<Long>apply1(f -> n -> n <= 1 ? 1 : n * f
                        .apply(f)
                        .apply(n - 1))
                .apply(10000L));
        assert Compose
                .apply2(Id.function(), Flip
                        .apply2(Const.function(), "ignore"))
                .apply(5).equals(5);
    }

    // Fix forces us to create and use a recursive typesystem, but does in the end work and allows us to
    // use recursion with anonymous functions
    public interface RecursiveFunction<T> extends Function<RecursiveFunction<T>, Function<T, T>> {
    }

    public static class Apply {
        public static <A, B> Function<Function<A, B>, Function<A, B>> function() {
            return f -> f;
        }

        public static <A, B> Function<A, B> apply1(final Function<A, B> f) {
            return f;
        }

        public static <A, B> B apply2(final Function<A, B> f, final A a) {
            return f.apply(a);
        }
    }

    public static class Id {
        public static <A> Function<A, A> function() {
            return a -> a;
        }

        public static <A> A apply1(final A a) {
            return a;
        }
    }

    public static class Compose {
        public static <A, B, C> Function<Function<B, C>, Function<Function<A, B>, Function<A, C>>> function() {
            return f -> g -> a -> f.apply(g.apply(a));
        }

        public static <A, B, C> Function<Function<A, B>, Function<A, C>> apply1(final Function<B, C> f) {
            return g -> a -> f.apply(g.apply(a));
        }

        public static <A, B, C> Function<A, C> apply2(final Function<B, C> f, final Function<A, B> g) {
            return a -> f.apply(g.apply(a));
        }

        public static <A, B, C> C apply3(final Function<B, C> f, final Function<A, B> g, final A a) {
            return f.apply(g.apply(a));
        }
    }

    public static class Const {
        public static <A, B> Function<A, Function<B, A>> function() {
            return a -> b -> a;
        }

        public static <A, B> Function<B, A> apply1(final A a) {
            return b -> a;
        }

        public static <A, B> A apply2(final A a, final B b) {
            return a;
        }
    }

    public static class Fix {
        public static <A> Function<RecursiveFunction<A>, Function<A, A>> function() {
            return f -> f.apply(f);
        }

        public static <A> Function<A, A> apply1(final RecursiveFunction<A> f) {
            return f.apply(f);
        }
    }

    public static class Flip {
        public static <A, B, C> Function<Function<A, Function<B, C>>, Function<B, Function<A, C>>> function() {
            return f -> b -> a -> f.apply(a).apply(b);
        }

        public static <A, B, C> Function<B, Function<A, C>> apply1(final Function<A, Function<B, C>> f) {
            return b -> a -> f.apply(a).apply(b);
        }

        public static <A, B, C> Function<A, C> apply2(final Function<A, Function<B, C>> f, final B b) {
            return a -> f.apply(a).apply(b);
        }

        public static <A, B, C> C apply3(final Function<A, Function<B, C>> f, final B b, final A a) {
            return f.apply(a).apply(b);
        }
    }

    public static class ReverseApply {
        public static <A, B> Function<A, Function<Function<A, B>, B>> function() {
            return a -> f -> f.apply(a);
        }

        public static <A, B> Function<Function<A, B>, B> apply1(final A a) {
            return f -> f.apply(a);
        }

        public static <A, B> B apply2(final A a, final Function<A, B> f) {
            return f.apply(a);
        }
    }
}
