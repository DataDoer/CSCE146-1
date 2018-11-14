import java.util.*;

public class TestCases {
  public static void main(String[] args) {
    Random rand = new Random();
    for(int i = 0; i < 5; i++) {
      for(int x = 0; x < 5; x++) {
        char s = (char)(rand.nextInt(26)+65);
        System.out.print(s);
      }
      System.out.println();
    }
  }
}
