package PRF;

import org.javatuples.Tuple;
import utils.Utils;

public class Composition implements PrimitiveRecursiveFunction {
  PrimitiveRecursiveFunction f;
  PrimitiveRecursiveFunction g;

  public Composition(PrimitiveRecursiveFunction f,
                     PrimitiveRecursiveFunction g) {
    Utils.checkIfNull(f, "f function can not be null.");
    Utils.checkIfNull(g, "g function can not be null.");

    this.f = f;
    this.g = g;
  }

  @Override
  public Tuple call(Tuple arguments)
    throws IllegalArgumentException,
    NullPointerException {
    Utils.checkIfNull(arguments, "arguments can not be null.");
    return f.call(g.call(arguments));
  }

  @Override
  public int arity() {
    return g.arity();
  }
}