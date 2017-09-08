
//Lowest implementation level
public class IntLinkedList {
  private ListNode head; //We need the head so we can go back
  private ListNode current; //Current data; movable ListNode
  private ListNode previous; //One node behind the current

  //Internal class
  //Will only be used internally
  private class ListNode {
    //Data and pointer?
    private int data;
    private ListNode link;//Singly linked list

    public ListNode() {
      data = 0;
      link = null; //Always one node ahead
    }//ListNode

    public ListNode(int aData, ListNode aLink) {
      data = aData;
      link = aLink;
    }//ListNode
  }//ListNode

  public IntLinkedList() {
    head = current = previous = null;
  }//IntLinkedList

  //Access the data
  public int getCurrent() {
    if (current != null) return current.data;
    else return 0;
  }//getCurrent

  //Add a new element to the end of the list
  public void insert(int newData) {
    //Create a new node, set data, link to null
    ListNode newNode = new ListNode(newData,null);
    if(head == null) {//Empty list
      head = newNode;//List needs head
      current = head;//List also has current
      return;
    }//if
    //List not empty
    ListNode temp = head;
    while(temp.link != null) { //Loops ahead until at end of list
      temp = head.link;
    }
    temp.link = newNode;//Link the end of list to newNode
  }//insert

  //Add an element after current
  public void insertAfterCurrent(int newData) {
    //Adding links to the middle of this chain
    //Create a newNode
    ListNode newNode = new ListNode(newData,null);
    if(current != null) {//List is not empty
      //newNode should point to where the current pointed
      newNode.link = current.link;
      //current should point to new
      current.link = newNode;
    } else if(head != null) {
      System.out.println("Current is outside of the list.");
    } else {
      System.out.println("The list is empty.");
      insert(newData);
    }//else
  }//insertAfterCurrent

  //Iterate to the next
  public void gotoNext() {
    if(current == null) return; //Already at end
    if(current.link == null) {//Outside
      resetCurrent();
      return;
    }//if
    previous = current;
    current = current.link;
  }//gotoNext

  //Reset the current
  public void resetCurrent() {
    current = head;
    previous = null;
  }//resetCurrent

  public void deleteCurrent() {
    if(current != null && previous != null) {//Middle of list
      previous.link = current.link;
      current = current.link;
    } else if (current != null && previous == null) {//Deleting the head
      head = current.link;
      current = head;
    } else {
      //If current == null, list should be empty
      System.out.println("List is empty!!!");
    }//if else
  }//deleteCurrent

  public void printList() {
    ListNode temp = head;
    while(temp != null) {
      System.out.println(temp.data);
      temp = temp.link;
    }//while
  }//printList
}//IntLinkedList


//head = beginning
