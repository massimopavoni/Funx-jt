package com.github.massimopavoni.funx.lib;

import java.util.function.Function;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class FunxPrelude {
  private FunxPrelude() {
    // Private constructor to prevent instantiation
  }

  public static Function<Boolean, Boolean> not() {
    return (x -> ((x) ? (false) : (true)));
  }
}
