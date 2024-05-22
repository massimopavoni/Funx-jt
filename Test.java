import java.util.function.Function;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class Test {
  private Test() {
    // Private constructor to prevent instantiation
  }

  public static void main(String[] args) {
    System.out.println(a.apply(13L));
  }

  public static Function<Long, Long> factorial;

  public static <t13> Function<t13, t13> id() {
    return (g -> g);
  }

  public static <t18>
      Function<Function<Boolean, t18>, Function<Function<Boolean, Boolean>, Function<Boolean, t18>>>
          boolCompose() {
    return compose();
  }

  public static <t17, t18, t16>
      Function<Function<t17, t18>, Function<Function<t16, t17>, Function<t16, t18>>> compose() {
    return (f -> (g -> (x -> f.apply(g.apply(x)))));
  }

  public static Function<Long, Boolean> a;

  static {
    factorial =
        (n ->
            ((lessThan.apply(n).apply(1L))
                ? (1L)
                : (multiply.apply(n).apply(factorial.apply(subtract.apply(n).apply(1L))))));

    a =
        (x ->
            (new Let<>() {
                  private Function<Long, Boolean> even;

                  private Function<Long, Boolean> odd;

                  private <t40, t41, t39>
                      Function<Function<t40, t41>, Function<Function<t39, t40>, Function<t39, t41>>>
                          compose() {
                    return (f -> (g -> (x -> f.apply(g.apply(x)))));
                  }

                  @Override
                  public Boolean _eval() {
                    even =
                        (a ->
                            ((equalsEquals().apply(a).apply(0L))
                                ? (true)
                                : (odd.apply(subtract.apply(a).apply(1L)))));

                    odd =
                        (a ->
                            ((notEquals().apply(a).apply(0L))
                                ? (even.apply(subtract.apply(a).apply(1L)))
                                : (false)));

                    return compose()
                        .apply(and.apply(true))
                        .apply(or.apply(false))
                        .apply(even.apply(x));
                  }
                })
                ._eval());
  }
}
