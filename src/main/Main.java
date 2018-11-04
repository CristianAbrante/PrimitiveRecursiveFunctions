package main;

import PRF.Pow;
import org.javatuples.Pair;
import org.javatuples.Tuple;

public class Main {
  public static void main(String[] args) {
	  // write your code here
    Pow pow = new Pow();
    Tuple t = pow.call(Pair.with(3,3));
    System.out.println(t.getValue(0));
  }
}
