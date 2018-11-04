package PRF;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.javatuples.Tuple;
import org.javatuples.Unit;
import utils.Utils;

public class Add implements PrimitiveRecursiveFunction {

  private final static Sucessor sucessor = new Sucessor();
  private final static Projection identity = new Projection(0);
  private final static Projection projection2 = new Projection(2);
  private final static Composition composition = new Composition(sucessor, projection2);

  @Override
  public Tuple call(Tuple arguments)
    throws IllegalArgumentException,
    NullPointerException {
    Utils.checkIfNull(arguments, "arguments of add can not be null.");
    if (arity() != arguments.getSize())
      throw new IllegalArgumentException(
        "arguments size is not equal to arity.");

    Integer x = (Integer) arguments.getValue(0);
    Integer y = (Integer) arguments.getValue(1);
    if (y.equals(0)) {
      return identity.call(Unit.with(x));
    } else {
      Integer result = (Integer) this.call(Pair.with(x, y - 1)).getValue(0);
      Tuple args = Triplet.with(x, y - 1, result);
      return composition.call(args);
    }
  }

  @Override
  public int arity() {
    return 2;
  }
}
