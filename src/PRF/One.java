package PRF;

import org.javatuples.Tuple;
import org.javatuples.Unit;
import utils.Utils;

public class One implements PrimitiveRecursiveFunction {
  private static final Zero zero = new Zero();
  private static final Sucessor sucessor = new Sucessor();
  private static final Composition composition = new Composition(sucessor, zero);

  @Override
  public Tuple call(Tuple arguments)
    throws IllegalArgumentException, NullPointerException {
    Utils.checkIfNull(arguments, "null arguments passed to zero function.");
    if (arity() != arguments.getSize())
      throw new IllegalArgumentException(
        "arity of function is different than arguments size.");

    Integer x = (Integer) arguments.getValue(0);
    return composition.call(Unit.with(x));
  }

  @Override
  public int arity() {
    return 1;
  }
}
