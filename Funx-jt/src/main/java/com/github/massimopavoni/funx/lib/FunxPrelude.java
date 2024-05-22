package com.github.massimopavoni.funx.lib;

import java.util.function.Function;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class FunxPrelude {
  private FunxPrelude() {
    // Private constructor to prevent instantiation
  }

  public static Function<Boolean, Boolean> not = null;

  static {
    not = (x -> ((x) ? (false) : (true)));
  }

  public static Function<Boolean, Function<Boolean, Boolean>> and = null;

  static {
    and = (x -> (y -> ((x) ? (y) : (false))));
  }

  public static Function<Boolean, Function<Boolean, Boolean>> or = null;

  static {
    or = (x -> (y -> ((x) ? (true) : (y))));
  }
}
