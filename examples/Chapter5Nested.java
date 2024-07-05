import java.util.function.Function;

import com.github.massimopavoni.funx.lib.JavaPrelude;

import com.github.massimopavoni.funx.lib.FunxPrelude;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class Chapter5Nested {
  private Chapter5Nested() {
    // private constructor to prevent instantiation
  }

  public static <h> Function<h, h> multipleIds() {
    return (x ->
        (new Let<>() {
              private <d> Function<d, d> id1() {
                return FunxPrelude.<d>id();
              }

              @Override
              public h _eval() {
                return (new Let<>() {
                      private <f> Function<f, f> id2() {
                        return JavaPrelude.<Function<f, f>>_instantiationCast(id1());
                      }

                      @Override
                      public h _eval() {
                        return this.<h>id2().apply(x);
                      }
                    })
                    ._eval();
              }
            })
            ._eval());
  }
}
