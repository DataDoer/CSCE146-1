public class LinkedListQueue <T> implements QueueInterface {
  ListNode head;//Can't add objects to middle
  ListNode tail;//Only can remove at head, add at tail, FIFO Rules

  private class ListNode {
    T data;
    ListNode link;
    public ListNode(T aData, ListNode aLink) {
      data = aData;
      link = aLink;
    }//ListNode
    public ListNode() {
      data = null;
      link = null;
    }
  }//ListNode

  public LinkedListQueue() {
    head = tail = null;
  }//LinkedListQueue

  public void enqueue(Object data) {
    ListNode newNode = new ListNode((T)data,null);
    if(head == null) {
      head = newNode;
      tail = newNode;
      return;
    }//if list is empty
    tail.link = newNode;
    tail = newNode;
  }//enqueue

  public T dequeue() {
    if(head == null) return null;
    ListNode temp = head;
    head = head.link;
    return temp.data;
  }

  public T peek() {
    if(head != null) {
      return head.data;
    }
    return null;
  }//peek

  public void print() {
    ListNode temp = head;
    while(temp != null) {
      System.out.println(temp.data.toString());
      temp = temp.link;
    }//while
  }//print


}//LinkedListQueue
