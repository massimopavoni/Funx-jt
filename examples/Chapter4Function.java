import java.util.function.Function;

import com.github.massimopavoni.funx.lib.JavaPrelude;

import com.github.massimopavoni.funx.lib.FunxPrelude;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class Chapter4Function {
  private Chapter4Function() {
    // private constructor to prevent instantiation
  }

  public static <a, b> Function<a, Function<b, a>> constant() {
    return (x -> (y -> x));
  }
}
