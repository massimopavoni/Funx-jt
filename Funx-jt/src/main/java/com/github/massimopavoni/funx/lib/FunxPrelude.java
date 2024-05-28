package com.github.massimopavoni.funx.lib;

import java.util.function.Function;

import com.github.massimopavoni.funx.lib.JavaPrelude;

import com.github.massimopavoni.funx.lib.FunxPrelude;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class FunxPrelude {
  private FunxPrelude() {
    // Private constructor to prevent instantiation
  }

  public static Function<Boolean, Boolean> not;

  public static Function<Boolean, Function<Boolean, Boolean>> and;

  public static Function<Boolean, Function<Boolean, Boolean>> or;

  public static <a> Function<a, a> id() {
    return (x -> x);
  }

  public static <b, c> Function<Function<b, c>, Function<b, c>> apply() {
    return (f -> (x -> f.apply(x)));
  }

  public static <d, e, f>
      Function<Function<d, e>, Function<Function<f, d>, Function<f, e>>> compose() {
    return (f -> (g -> (x -> f.apply(g.apply(x)))));
  }

  public static <g, h, i>
      Function<Function<g, Function<h, i>>, Function<h, Function<g, i>>> flip() {
    return (f -> (x -> (y -> f.apply(y).apply(x))));
  }

  static {
    not = (x -> ((x) ? (false) : (true)));

    and = (x -> (y -> ((x) ? (y) : (false))));

    or = (x -> (y -> ((x) ? (true) : (y))));
  }
}
