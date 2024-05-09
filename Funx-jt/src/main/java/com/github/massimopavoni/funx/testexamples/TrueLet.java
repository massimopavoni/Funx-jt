package com.github.massimopavoni.funx.testexamples;

import java.util.function.Function;

public class TrueLet {
    public static void main(String[] args) {
        System.out.println(f().apply(2).apply(3));
        System.out.println(a().apply(42));
    }

    // let a =
    //   let even x = if x == 0 then true else odd (x - 1)
    //   and odd x = if x == 0 then false else even (x - 1)
    //   in even
    public static Function<Integer, Boolean> a() {
        return new Let<>() {
            private Function<Integer, Boolean> even() {
                return new Function<Integer, Boolean>() {
                    @Override
                    public Boolean apply(Integer x) {
                        return x == 0 || odd().apply(x - 1);
                    }
                };
            }

            private Function<Integer, Boolean> odd() {
                // return x -> x != 0 && even().apply(x - 1); LAMBDA? or EXPLICIT?
                return new Function<Integer, Boolean>() {
                    @Override
                    public Boolean apply(Integer x) {
                        return x != 0 && even().apply(x - 1);
                    }
                };
            }

            @Override
            public Function<Integer, Boolean> _eval() {
                return even();
            }
        }._eval();
    }

    // f x = let g y = x + y in g
    public static Function<Integer, Function<Integer, Integer>> f() {
//        return x -> new Let<Function<Integer, Integer>>() {
//            private Function<Integer, Integer> g() {
//                // return y -> x + y; LAMBDA? or EXPLICIT?
//                return new Function<Integer, Integer>() {
//                    @Override
//                    public Integer apply(Integer y) {
//                        return x + y;
//                    }
//                };
//            }
//
//            @Override
//            public Function<Integer, Integer> _eval() {
//                return g();
//            }
//        }._eval(); LAMBDA? or EXPLICIT?
        return new Function<Integer, Function<Integer, Integer>>() {
            @Override
            public Function<Integer, Integer> apply(Integer x) {
                return new Let<Function<Integer, Integer>>() {
                    private Function<Integer, Integer> g() {
                        // return y -> x + y; LAMBDA? or EXPLICIT?
                        return new Function<Integer, Integer>() {
                            @Override
                            public Integer apply(Integer y) {
                                return x + y;
                            }
                        };
                    }

                    @Override
                    public Function<Integer, Integer> _eval() {
                        return g();
                    }
                }._eval();
            }
        };
    }
}
