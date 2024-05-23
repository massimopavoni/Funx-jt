import java.util.function.Function;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class Test {
  private Test() {
    // Private constructor to prevent instantiation
  }

  public static void main(String[] args) {
    System.out.println(even.apply(13L));
  }

  public static Function<Long, Long> factorial;

  public static <t14>
      Function<Function<Boolean, t14>, Function<Function<Boolean, Boolean>, Function<Boolean, t14>>>
          boolCompose() {
    return id().apply(compose());
  }

  public static Function<Long, Boolean> even;

  static {
    factorial =
        (n ->
            ((lessThan.apply(n).apply(1L))
                ? (1L)
                : (multiply.apply(n).apply(factorial.apply(subtract.apply(n).apply(1L))))));

    even =
        (x ->
            (new Let<>() {
                  private Function<Long, Boolean> even;

                  private Function<Long, Boolean> odd;

                  private <t37, t38, t36>
                      Function<Function<t37, t38>, Function<Function<t36, t37>, Function<t36, t38>>>
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
