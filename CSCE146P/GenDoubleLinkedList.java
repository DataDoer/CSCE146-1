//00426510
//Justin Baum



public class GenDoubleLinkedList <T> {
  private ListNode current;
  private ListNode head;

  private class ListNode {
    private ListNode prevLink;
    private ListNode nextLink;
    private T data;

    public ListNode() {
      prevLink = null;
      nextLink = null;
      data = null;
    }//ListNode

    public ListNode(T aData, ListNode aPrevLink, ListNode aNextLink) {
      prevLink = aPrevLink;
      nextLink = aNextLink;
      data = aData;
    }//ListNode
  }//ListNode

  public GenDoubleLinkedList() {
    head = current = null;
  }//Default Constructor

  public void goToNext() {
    if(current.nextLink == null) return;
    current = current.nextLink;
  }//goToNext

  public void goToPrev() {
    current = current.prevLink;
  }//goToPrev

  public T getDataAtCurrent() {
    return current.data;
  }//getDataAtCurrent

  public void setDataAtCurrent(T newData) {
    ListNode newNode = new ListNode();
    newNode.data = newData;
    if(head == null) {
      head = current = newNode;
    }//if
    current.data = newData;
  }//setDataAtCurrent

  public void insertNodeAfterCurrent(T newData) {
    ListNode node = new ListNode();
    node.data = newData;
    if(head == null) {//list is empty
      head = current = node;
    }//if
    current.nextLink = node;
    node.prevLink = current;

  }//insertAfterCurrent

  public void deleteCurrentNode() {
    ListNode prevNode = current.prevLink;
    ListNode nextNode = current.nextLink;

    prevNode.nextLink = nextNode;
    nextNode.prevLink = prevNode;
  }//deleteCurrentNode

  public void showList() {
    ListNode tmp = head;
    if(head == null) return;
    while(tmp != null && tmp.data != null) {
      System.out.println(tmp.data.toString());
      tmp = tmp.nextLink;
    }//while
  }//showList

  public boolean inList(T data) {
    ListNode tmp = head;
    while(tmp != null && tmp.data != null) {
      if(data.equals(tmp.data)) return true;
      tmp = tmp.nextLink;
    }//while
    return false;
  }//inList
}//DoublyLinkedList
