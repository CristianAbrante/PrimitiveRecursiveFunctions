package main;

import static org.junit.Assert.*;

import PRF.Pow;
import org.javatuples.Pair;
import org.junit.Test;

public class PowTest {
  @Test
  public void powTest() {
    Pow pow = new Pow();

    final int MAX = 6;
    for (int i = 0; i < MAX; i++) {
      for (int j = 0; j < MAX; j++) {
        assertEquals((int) Math.pow(i, j), pow.call(Pair.with(i, j)).getValue(0));
      }
    }
  }
}
