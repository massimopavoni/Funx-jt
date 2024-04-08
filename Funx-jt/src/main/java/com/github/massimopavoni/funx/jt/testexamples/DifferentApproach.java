package com.github.massimopavoni.funx.jt.testexamples;

import java.util.function.Function;

// What if we can make every function be...a function? (a method)
// It could be possible, but it would probably limit the choice to currying
// (or anyway implementing the full application as another method with the same name,
// meaning we could not have halfway partial application methods such as apply2, apply3, etc.)
// Maybe we could actually just create a function method, a fully apply with one parameter,
// and a partial apply with just the first parameter (but this would be weird when the function
// interested only has one parameter, unless we specify names (e.g. f, fApply, fFull)
public class DifferentApproach {
    public static void main(String[] args) {
        // id const R> const
        assert SimpleExpression.Id.apply(constant()).equals(constant());
        // const 1 R> \y .> 1
        // Apparently, the type inferred also has to work with objects, which might be limiting,
        // or might actually not make a big difference, since we would always be using objects anyway
        assert constant().apply(1) instanceof Function<Object, Object>;
        // const 1 2 R> 1 as full apply
        assert constant(1, 2).equals(1);
        // const 1 2 R> 1 as partial apply
        assert constant().apply(1).apply(2).equals(1);
        // id (const 1) 2 R> id (\y .> 1) 2 R> (\y .> 1) 2 R> 1
        assert SimpleExpression.Id.apply(constant().apply(1)).apply(2).equals(1);
    }

    // It might make for a slightly cleaner look, but it would also force multiple methods,
    // resulting in a less organized program compared to the "function-class" based approach
    public static <X, Y> Function<X, Function<Y, X>> constant() {
        return x -> y -> x;
    }

    public static <X, Y> X constant(X x, Y y) {
        return x;
    }
}
