//Justin Baum
//00426510

import java.util.Random;

public class JeepTest {
  public static void main(String[] args) {
    JeepHeap jeeps = new  JeepHeap();
    Random r = new Random();
    System.out.println("Adding 15 Jeep");
    for(int i = 0; i < 15; i++) {
      jeeps.addJeep(new Jeep("Jeep " + (i+1),randr(100,400,r),randr(300,450,r)*10));
    }
    System.out.println("Here's the 15 Jeep in breadth order.");
    System.out.println(jeeps.JeepRollCall());
    System.out.println("Here's the 15 Jeep in sorted order(by horsepower).");
    System.out.println(jeeps.JeepHeapSort());
    System.out.println("Removing 5 most powerful Jeep");
    for(int i = 0; i < 5; i++) {
      System.out.println("Removing: "+jeeps.removeJeep());
    }

    System.out.println("\nHere's the 10 Jeep in breadth order.");
    System.out.println(jeeps.JeepRollCall());
    System.out.println("Here's the 10 Jeep in sorted order(by horsepower).");
    System.out.println(jeeps.JeepHeapSort());
  }

  private static int randr(int x, int y, Random r) {
    int range = (y-x);
    return r.nextInt(range)+x;
  }
}
