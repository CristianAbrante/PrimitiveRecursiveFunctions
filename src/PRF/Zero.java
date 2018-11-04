package PRF;

import org.javatuples.Tuple;
import org.javatuples.Unit;
import utils.Utils;

public final class Zero
  implements PrimitiveRecursiveFunction {
  private final int ZERO = 0;

  @Override
  public Tuple call(Tuple arguments)
    throws IllegalArgumentException, NullPointerException {
    Utils.checkIfNull(arguments, "null arguments passed to zero function.");
    if (arity() != arguments.getSize())
      throw new IllegalArgumentException(
        "arity of function is different than arguments size.");
    return Unit.with(ZERO);
  }

  @Override
  public int arity() {
    return 1;
  }
}
