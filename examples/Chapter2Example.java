import java.util.function.Function;

import com.github.massimopavoni.funx.lib.JavaPrelude;

import com.github.massimopavoni.funx.lib.FunxPrelude;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class Chapter2Example {
  private Chapter2Example() {
    // private constructor to prevent instantiation
  }

  public static void main(String[] args) {
    System.out.println(factorial.apply(20L));
  }

  public static Function<Long, Long> factorial;

  public static Function<Long, Boolean> even;

  public static Function<Long, Function<Long, Long>> gcd;

  public static Function<Boolean, Function<Boolean, Boolean>> xor;

  static {
    factorial =
        (n ->
            ((JavaPrelude.<Long>equalsEquals().apply(n).apply(0L))
                ? (1L)
                : (multiply.apply(n).apply(factorial.apply(subtract.apply(n).apply(1L))))));

    even =
        (new Let<>() {
              private Function<Long, Boolean> even1;

              private Function<Long, Boolean> odd;

              @Override
              public Function<Long, Boolean> _eval() {
                even1 =
                    (n ->
                        ((JavaPrelude.<Long>equalsEquals().apply(n).apply(0L))
                            ? (true)
                            : (odd.apply(subtract.apply(n).apply(1L)))));

                odd =
                    (n ->
                        ((JavaPrelude.<Long>equalsEquals().apply(n).apply(0L))
                            ? (false)
                            : (even1.apply(subtract.apply(n).apply(1L)))));

                return even1;
              }
            })
            ._eval();

    gcd =
        (a ->
            (b ->
                ((JavaPrelude.<Long>equalsEquals().apply(b).apply(0L))
                    ? (a)
                    : (gcd.apply(b).apply(modulo.apply(a).apply(b))))));

    xor = (a -> (b -> ((((a) ? (true) : (b))) ? (not.apply(((a) ? (b) : (false)))) : (false))));
  }
}
