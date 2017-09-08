public class IntLinkedListTester {
  public static void main(String[] args) {
    IntLinkedList iList = new IntLinkedList();
    iList.insert(5);
    iList.insert(3);
    System.out.println(iList.getCurrent());
    iList.insert(5);
    for(int i = 0; i < 1; i++){
      System.out.println(i);
      iList.insert(i);
      System.out.println(iList.getCurrent());
    }
  }//main
}//IntLinkedListTester
