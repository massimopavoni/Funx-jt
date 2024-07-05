import java.util.function.Function;

import com.github.massimopavoni.funx.lib.JavaPrelude;

import com.github.massimopavoni.funx.lib.FunxPrelude;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class Chapter5Monomorphic {
  private Chapter5Monomorphic() {
    // private constructor to prevent instantiation
  }

  public static void main(String[] args) {
    System.out.println(add.apply(add.apply(fun1).apply(fun2)).apply(letFun));
  }

  public static Long fun1;

  public static Long fun2;

  public static Long letFun;

  static {
    fun1 = 1L;

    fun2 = 2L;

    letFun =
        (new Let<>() {
              private Long a;

              private Long b;

              @Override
              public Long _eval() {
                a = 3L;

                b = 4L;

                return add.apply(a).apply(b);
              }
            })
            ._eval();
  }
}
