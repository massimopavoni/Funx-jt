package com.github.massimopavoni.funx.jt.testexamples;

import java.util.List;
import java.util.function.Function;

public class Fold {
    public static void main(String[] args) {
        System.out.println(foldr().apply(a -> b -> b + a.length()).apply(0).apply(List.of("a", "bb", "ccc", "dddd")));
    }

    public static Function<
            Function<
                    String,
                    Function<
                            Integer,
                            Integer
                            >
                    >,
            Function<
                    Integer,
                    Function<
                            List<String>,
                            Integer
                            >
                    >
            > foldr() {
        return f -> b -> as -> as.isEmpty() ?
                b :
                f.apply(as.getFirst()).apply(foldr().apply(f).apply(b).apply(as.subList(1, as.size())));
    }
}
