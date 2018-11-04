package main;

import PRF.Pow;
import org.javatuples.Pair;
import org.javatuples.Tuple;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    int x, y;
    switch (args.length) {
      case 0:
        Scanner scanner = new Scanner(System.in);
        System.out.println("introduce x > ");
        x = Integer.parseInt(scanner.nextLine());
        System.out.println("introduce y > ");
        y = Integer.parseInt(scanner.nextLine());
        break;
      case 2:
        x = Integer.parseInt(args[0]);
        y = Integer.parseInt(args[1]);
        break;
        default:
          throw new IllegalArgumentException("wrong number of arguments");
    }

    Pow pow = new Pow();
    Integer result = (Integer) pow.call(Pair.with(x, y)).getValue(0);
    System.out.printf("pow(%d, %d) = %d", x, y, result);
  }
}
