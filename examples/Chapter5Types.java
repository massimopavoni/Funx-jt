import java.util.function.Function;

import com.github.massimopavoni.funx.lib.JavaPrelude;

import com.github.massimopavoni.funx.lib.FunxPrelude;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class Chapter5Types {
  private Chapter5Types() {
    // private constructor to prevent instantiation
  }

  public static void main(String[] args) {
    System.out.println(countdown.apply(1825L));
  }

  public static Function<Long, Long> countdown;

  public static <s>
      Function<Function<s, Boolean>, Function<Function<s, s>, Function<s, s>>> until() {
    return (p ->
        (f ->
            (new Let<>() {
                  private Function<s, s> until1;

                  @Override
                  public Function<s, s> _eval() {
                    until1 = (x -> ((p.apply(x)) ? (x) : (until1.apply(f.apply(x)))));

                    return until1;
                  }
                })
                ._eval()));
  }

  static {
    countdown =
        Chapter5Types.<Long>until()
            .apply(JavaPrelude.<Long>equalsEquals().apply(0L))
            .apply(FunxPrelude.<Long, Long, Long>flip().apply(subtract).apply(1L));
  }
}
