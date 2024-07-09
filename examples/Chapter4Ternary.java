import java.util.function.Function;

import com.github.massimopavoni.funx.lib.JavaPrelude;

import com.github.massimopavoni.funx.lib.FunxPrelude;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class Chapter4Ternary {
  private Chapter4Ternary() {
    // private constructor to prevent instantiation
  }

  public static Function<Long, Function<Long, Long>> power;

  public static Function<Boolean, Function<Boolean, Boolean>> xor;

  static {
    power =
        (b ->
            (e ->
                ((JavaPrelude.<Long>equalsEquals().apply(e).apply(0L))
                    ? (1L)
                    : (multiply
                        .apply(b)
                        .apply(power.apply(b).apply(subtract.apply(e).apply(1L)))))));

    xor = (a -> (b -> ((((a) ? (true) : (b))) ? (not.apply(((a) ? (b) : (false)))) : (false))));
  }
}
