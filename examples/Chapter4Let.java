import java.util.function.Function;

import com.github.massimopavoni.funx.lib.JavaPrelude;

import com.github.massimopavoni.funx.lib.FunxPrelude;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class Chapter4Let {
  private Chapter4Let() {
    // private constructor to prevent instantiation
  }

  public static Function<Long, Function<Long, Long>> hundredsSum;

  static {
    hundredsSum =
        (new Let<>() {
              private <a, b, c>
                  Function<
                          Function<a, Function<a, b>>,
                          Function<Function<c, a>, Function<c, Function<c, b>>>>
                      on() {
                return (op -> (f -> (x -> (y -> op.apply(f.apply(x)).apply(f.apply(y))))));
              }

              @Override
              public Function<Long, Function<Long, Long>> _eval() {
                return this.<Long, Long, Long>on().apply(add).apply(multiply.apply(100L));
              }
            })
            ._eval();
  }
}
