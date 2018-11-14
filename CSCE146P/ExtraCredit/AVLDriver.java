//Justin Baum
//00426510
import java.util.Random;

public class AVLDriver {
  public static void main(String[] args) {
    AVLTree<Integer> avl = new AVLTree<Integer>();
    Random r = new Random(20);
    for(int i = 0; i < 2000; i++) {
      avl.insert(r.nextInt(10000));
    }
    avl.printPreOrder();
    System.out.println("Is Tree balanced: "+avl.isBalanced());
  }
}
/*
int[] numbers = {50,75,25,24,23,22,21,20,19,18,26,27,28,29};
for(int i : numbers) avl.insert(i);
*/
