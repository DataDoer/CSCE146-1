//Justin Baum
//00426510
import java.util.Random;

public class AVLDriver2 {
  public static void main(String[] args) {
    AVLTree<Integer> avl = new AVLTree<Integer>();
    Random r = new Random();
    int[] numbs = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    for(int i : numbs) {
      avl.insert(i);
    }
    avl.printWKids();
  }
}
