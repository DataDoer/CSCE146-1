//Justin Baum
//00426510


//Lowest implementation level
public class GenLinkedList2 <T> {
  private ListNode head; //We need the head so we can go back
  private ListNode current; //Current data; movable ListNode
  private ListNode previous; //One node behind the current

  //Internal class
  //Will only be used internally
  private class ListNode {
    //Data and pointer?
    private T data;
    private ListNode link;//Singly linked list; next ListNode

    public ListNode() {
      data = null;
      link = null; //Always one node ahead
    }//ListNode

    public ListNode(T aData, ListNode aLink) {
      data = aData;
      link = aLink;
    }//ListNode
  }//ListNode

  public GenLinkedList2() {
    head = current = previous = null;
  }//IntLinkedList

  //Access the data
  public T getCurrent() {
    if (current != null) return current.data;
    else return null;
  }//getCurrent

  //Add a new element to the end of the list
  public void insert(T newData) {
    if(newData == null) return;
    //Create a new node, set data, link to null
    ListNode newNode = new ListNode(newData,null);
    if(head == null) {//Empty list
      head = newNode;//List needs head
      current = head;//List also has current
      return;
    }//if
    //List not empty
    ListNode temp = head;
    while(temp.link != null) {//We go to the end of the list
      temp = temp.link;
    }
    temp.link = newNode;
  }//insert

  //Add an element after current
  public void insertAfterCurrent(T newData) {//Does not move down the list
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
      previous = current;
      current = null;
      return;
    }//if
    previous = current;
    current = current.link;
  }//gotoNext


  public void gotoPrev() {
    if(previous == null) return;//At head
    if(previous == head){
      current = head;
      previous = null;
      return;
    };//At front
    ListNode originalCurrent = current;
    ListNode originalPrevious = previous;
    ListNode temp;
    ListNode newPrevious = null;
    resetCurrent();
    while(current != originalPrevious){
      temp = previous;
      newPrevious = temp;
      gotoNext();
    }//while
    current = originalPrevious;
    previous = newPrevious;
  }

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

  public void showList() {
    ListNode temp = head;
    int counter = 1;
    System.out.println("Printing List");
    while(temp != null) {
      System.out.println(counter + ". " +temp.data.toString());
      temp = temp.link;
      counter++;
    }//while
  }//printList

  public T getDataAtCurrent() {
    return getCurrent();
  }//getDataAtCurrent

  public void setDataAtCurrent(T newData) {
    current.data = newData;
  }//setDataAtCurrent

  public void addItem(T newData) {
    insert(newData);
  }//addItem

  public boolean hasNext() {
    return (current.link != null);
  }//hasNext

  public boolean empty() {
    return head == null;
  }


}//IntLinkedList


//head = beginning
