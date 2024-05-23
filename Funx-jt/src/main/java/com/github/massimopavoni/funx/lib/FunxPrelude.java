package com.github.massimopavoni.funx.lib;

import java.util.function.Function;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class FunxPrelude {
  private FunxPrelude() {
    // Private constructor to prevent instantiation
  }

  public static Function<Boolean, Boolean> not;

  public static Function<Boolean, Function<Boolean, Boolean>> and;

  public static Function<Boolean, Function<Boolean, Boolean>> or;

  public static <t12> Function<t12, t12> id() {
    return (x -> x);
  }

  public static <t14, t15> Function<Function<t14, t15>, Function<t14, t15>> apply() {
    return (f -> (x -> f.apply(x)));
  }

  public static <t19, t20, t18>
      Function<Function<t19, t20>, Function<Function<t18, t19>, Function<t18, t20>>> compose() {
    return (f -> (g -> (x -> f.apply(g.apply(x)))));
  }

  public static <t23, t22, t25>
      Function<Function<t23, Function<t22, t25>>, Function<t22, Function<t23, t25>>> flip() {
    return (f -> (x -> (y -> f.apply(y).apply(x))));
  }

  static {
    not = (x -> ((x) ? (false) : (true)));

    and = (x -> (y -> ((x) ? (y) : (false))));

    or = (x -> (y -> ((x) ? (true) : (y))));
  }
}
