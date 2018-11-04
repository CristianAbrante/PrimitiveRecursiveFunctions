package utils;

import org.javatuples.*;

import java.util.List;

public class Utils {
  public static void checkIfNull(Object obj, String errorMsg)
    throws NullPointerException {
    if (obj == null) {
      throw new NullPointerException(errorMsg);
    }
  }
  
  public static Tuple convertToTuple(List<Object> list)
    throws NullPointerException {
    Utils.checkIfNull(list, "list of objects is null.");
    Tuple resultTuple;
    switch (list.size()) {
      case 1:
        resultTuple = Unit.fromCollection(list);
        break;
      case 2:
        resultTuple = Pair.fromCollection(list);
        break;
      case 3:
        resultTuple = Triplet.fromCollection(list);
        break;
      case 4:
        resultTuple = Quartet.fromCollection(list);
        break;
      case 5:
        resultTuple = Quintet.fromCollection(list);
        break;
      case 6:
        resultTuple = Sextet.fromCollection(list);
        break;
      case 7:
        resultTuple = Septet.fromCollection(list);
        break;
      case 8:
        resultTuple = Octet.fromCollection(list);
        break;
      case 9:
        resultTuple = Ennead.fromCollection(list);
        break;
      case 10:
        resultTuple = Decade.fromCollection(list);
        break;
      default:
        resultTuple = null;
    }

    return resultTuple;
  }
}
