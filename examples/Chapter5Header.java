import java.util.function.Function;

import com.github.massimopavoni.funx.lib.JavaPrelude;

import com.github.massimopavoni.funx.lib.FunxPrelude;

import static com.github.massimopavoni.funx.lib.JavaPrelude.*;
import static com.github.massimopavoni.funx.lib.FunxPrelude.*;

public class Chapter5Header {
  private Chapter5Header() {
    // private constructor to prevent instantiation
  }

  public static void main(String[] args) {
    System.out.println(Chapter5Header.<Boolean>test().apply(false));
  }

  public static <c> Function<c, c> test() {
    return ((Function<Function<c, c>, Function<c, c>>) x -> x).apply(FunxPrelude.<c>id());
  }
}
