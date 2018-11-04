package PRF;

import org.javatuples.Tuple;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Combination
  implements PrimitiveRecursiveFunction {

  PrimitiveRecursiveFunction f;
  PrimitiveRecursiveFunction g;

  public Combination(PrimitiveRecursiveFunction f,
                     PrimitiveRecursiveFunction g) {
    Utils.checkIfNull(f, "f function can not be null.");
    Utils.checkIfNull(g, "g function can not be null.");
    if (f.arity() != g.arity())
      throw new IllegalArgumentException("arity of f and g must be equal.");

    this.f = f;
    this.g = g;
  }

  @Override
  public Tuple call(Tuple arguments)
    throws IllegalArgumentException,
    NullPointerException {
    Utils.checkIfNull(arguments, "arguments can not be null.");
    Tuple fResult = f.call(arguments);
    List<Object> result = new ArrayList<>();
    for (Object obj : fResult) {
      result.add(obj);
    }
    result.addAll(g.call(arguments).toList());
    return Utils.convertToTuple(result);
  }

  @Override
  public int arity() {
    return f.arity();
  }
}