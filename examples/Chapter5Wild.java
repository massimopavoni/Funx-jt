import java.util.function.Function;

import com.github.massimopavoni.funx.lib.JavaPrelude;

import com.github.massimopavoni.funx.lib.FunxPrelude;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class Chapter5Wild {
  private Chapter5Wild() {
    // private constructor to prevent instantiation
  }

  public static <j, k> Function<j, Function<Function<j, k>, k>> reverseApply() {
    return FunxPrelude.<Function<j, k>, j, k>flip()
        .apply(
            (Function<Function<j, k>, Function<j, k>>)
                (new Let<>() {
                      private <h, i> Function<Function<h, i>, Function<h, i>> apply1() {
                        return (f -> (x -> f.apply(x)));
                      }

                      @Override
                      public Function<Function<j, k>, Function<j, k>> _eval() {
                        return this.<j, k>apply1();
                      }
                    })
                    ._eval());
  }

  public static <n> Function<n, n> anonymousIds() {
    return ((Function<Function<n, n>, Function<n, n>>) x -> x).apply(((Function<n, n>) x -> x));
  }
}
