public class StackTester {
  public static void main(String[] args) {
    StackInterface<Integer> aStack = new ArrayStack<Integer>();
    StackInterface<Integer> lStack = new LinkedListStack<Integer>();

    for(int i = 0; i < 10; i++) {
      aStack.push(i);
      lStack.push(i*3);
    }//for

    for(int i = 0; i < 10; i++) {
      System.out.println(aStack.pop());
    }//for

    for(int i = 0; i < 10; i++) {
      System.out.println(lStack.pop());
    }//for

    String b = "34500000000";
    try {
      int c = Integer.parseInt(b);
      System.out.println(c);
    } catch (Exception e) {
      System.out.println(e);
    }

  }
}
