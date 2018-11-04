package PRF;

import org.javatuples.Tuple;
import org.javatuples.Unit;
import utils.Utils;

public class Sucessor
  implements PrimitiveRecursiveFunction {

  @Override
  public Tuple call(Tuple arguments)
    throws IllegalArgumentException, NullPointerException {
    Utils.checkIfNull(arguments, "null arguments passed to sucessor function.");
    if (arity() != arguments.getSize())
      throw new IllegalArgumentException(
        "arity of function is different than arguments size.");

    Integer x = (Integer) arguments.getValue(0);
    return Unit.with(x + 1);
  }

  @Override
  public int arity() {
    return 1;
  }
}
