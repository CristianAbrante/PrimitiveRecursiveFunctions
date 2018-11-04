package PRF;

import org.javatuples.Tuple;
import org.javatuples.Unit;
import utils.Utils;

import java.util.List;

public class Projection
  implements PrimitiveRecursiveFunction {

  private int index;

  public Projection(int index) {
    if (index < 0)
      throw new IllegalArgumentException("index can be negative.");
    this.index = index;
  }

  @Override
  public Tuple call(Tuple arguments)
    throws IllegalArgumentException, NullPointerException {
    Utils.checkIfNull(arguments, "arguments are null.");
    if (index >= arguments.getSize())
      throw new IllegalArgumentException(
        "index of projection is not in bounds");

    return Unit.with(arguments.getValue(index));
  }

  @Override
  public int arity() {
    return -1;
  }
}