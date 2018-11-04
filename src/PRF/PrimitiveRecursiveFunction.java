package PRF;

import org.javatuples.Tuple;

/**
 * This interface is used to implement
 * a primitive recursive function, that
 * can be called with several parameters.
 */
public interface PrimitiveRecursiveFunction {

  /**
   * Call to the function with
   * a tuple of parameters.
   *
   * @param arguments tuple of arguments.
   * @return the tuple of the return value.
   *
   * @throws IllegalArgumentException if arity of function
   *                                  is not equal as arity
   *                                  of arguments.
   * @throws NullPointerException if arguments are null.
   */
  Tuple call(Tuple arguments)
    throws IllegalArgumentException, NullPointerException;

  /**
   * Returns the arity of the function.
   * or the number of arguments it accepts.
   *
   * @return arity of the function
   */
  int arity();
}
