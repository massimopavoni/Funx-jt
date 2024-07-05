import java.util.function.Function;

import com.github.massimopavoni.funx.lib.JavaPrelude;

import com.github.massimopavoni.funx.lib.FunxPrelude;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class Chapter4Generics {
  private Chapter4Generics() {
    // private constructor to prevent instantiation
  }

  public static Function<Long, Long> sumToN;

  static {
    sumToN =
        (new Let<>() {
              private <a, b, c>
                  Function<Function<a, Function<b, c>>, Function<Function<a, b>, Function<a, c>>>
                      ap() {
                return (op -> (f -> (x -> op.apply(x).apply(f.apply(x)))));
              }

              @Override
              public Function<Long, Long> _eval() {
                return FunxPrelude.<Long, Long, Long>compose()
                    .apply(FunxPrelude.<Long, Long, Long>flip().apply(divide).apply(2L))
                    .apply(this.<Long, Long, Long>ap().apply(multiply).apply(add.apply(1L)));
              }
            })
            ._eval();
  }
}
