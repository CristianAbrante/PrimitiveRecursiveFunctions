package PRF;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.javatuples.Tuple;
import org.javatuples.Unit;
import utils.Utils;

public class Pow
  implements PrimitiveRecursiveFunction {

  private static final One one = new One();
  private static final Product product = new Product();
  private static final Projection projection0 = new Projection(0);
  private static final Projection projection2 = new Projection(2);
  private static final Combination combination = new Combination(projection0, projection2);
  private static final Composition composition = new Composition(product, combination);

  @Override
  public Tuple call(Tuple arguments)
    throws IllegalArgumentException, NullPointerException {
    Utils.checkIfNull(arguments, "arguments can not be null.");
    if (arity() != arguments.getSize())
      throw new IllegalArgumentException("arguments size and arity must be equal.");

    Integer x = (Integer) arguments.getValue(0);
    Integer y = (Integer) arguments.getValue(1);
    if (y.equals(0)) {
      return one.call(Unit.with(x));
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
