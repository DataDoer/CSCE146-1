import java.util.*;
public class CarHashTable {
  private ArrayList<Car>[] table;
  private static final int TABLE_SIZE = 100;
  public CarHashTable() {
    table = new ArrayList[TABLE_SIZE];
    for(int i = 0; i < table.length; i++) {
      table[i] = new ArrayList<Car>();
    }//for
  }//CarHashTable
  private int calcIndex(Car aCar) {
    int index = 0;
    String makeAndModel = aCar.getModel();
    for(int i = 0; i < makeAndModel.length(); i++) {
      index += makeAndModel.charAt(i);
    }//for
    index %= TABLE_SIZE;
    return index;
  }//calcIndex

  public void add(Car aCar) {
    table[calcIndex(aCar)].add(aCar);
  }//add

  public void remove(Car aCar) {
    table[calcIndex(aCar)].remove(aCar);
  }//remove

  public void lookUp(Car aCar) {
    int index = calcIndex(aCar);
    if(table[index].contains(aCar)) {
      System.out.println(aCar.toString());
    } else System.out.println("Nope.");
  }//lookUp
}//CarHashTable
