import java.util.function.Function;

import com.github.massimopavoni.funx.lib.JavaPrelude;

import com.github.massimopavoni.funx.lib.FunxPrelude;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class Chapter5AST {
  private Chapter5AST() {
    // private constructor to prevent instantiation
  }

  public static Function<Boolean, Boolean> tautology;

  static {
    tautology = (x -> ((x) ? (true) : (not.apply(x))));
  }
}
