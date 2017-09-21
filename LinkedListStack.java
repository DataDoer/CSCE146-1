public class LinkedListStack<T> implements StackInterface {
  private ListNode head;

  private class ListNode {
    private T data;
    private ListNode link;
    public ListNode(T aData, ListNode aLink) {
      data = aData;
      link = aLink;
    }//ListNode
  }//ListNode

  public void push(Object data) {
    ListNode newNode = new ListNode((T)data,head);
    head = newNode;
  }//push

  public T pop() {
    if(head == null) return null;
    T retVal = head.data;
    head = head.link;
    return retVal;
  }//pop

  public T peek() {
    if(head == null) return null;
    return head.data;
  }//peek

  public void print() {
    ListNode temp = head;
    while(temp != null) {
      System.out.println(temp.data.toString());
      temp = temp.link;
    }//while
  }//print

  public void nothing() {
    
  }
}//LinkedListStack
