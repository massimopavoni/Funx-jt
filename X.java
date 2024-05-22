import java.util.function.Function;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class X {
  private X() {
    // Private constructor to prevent instantiation
  }

  public static void main(String[] args) {
    System.out.println(weirdEquals().apply(17L).apply(17L));
  }

  public static <t2> Function<t2, Function<t2, Boolean>> weirdEquals() {
    return (x ->
        (y ->
            (new Let<>() {
                  private <t17> Function<t17, Function<t17, Function<Long, Boolean>>> even() {
                    return (a ->
                        (b ->
                            (c ->
                                ((equalsEquals().apply(a).apply(b))
                                    ? (odd.apply(a).apply(b).apply(subtract.apply(c).apply(1L)))
                                    : (false)))));
                  }

                  private <t17> Function<t17, Function<t17, Function<Long, Boolean>>> odd() {
                    return (a ->
                        (b ->
                            (c ->
                                ((equalsEquals().apply(a).apply(b))
                                    ? (even.apply(a).apply(b).apply(subtract.apply(c).apply(1L)))
                                    : (false)))));
                  }

                  @Override
                  public Boolean _eval() {
                    return even().apply(x).apply(y).apply(1000L);
                  }
                })
                ._eval()));
  }
}
