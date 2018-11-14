public interface StackInterface <T> {
  public void push(T data); //Add data
  public T pop();//Remove data
  public T peek();//Returns object but doesn't remove
  public void print();
}



/*
Stacks
  This data structure works on the principle last in first out
  Any kind of pile is a good way to think of a stack
    A stack of games
    Pile of exams
  Stakcs can be represented by any simple abstract data structure
    Arrays
    Linked Lists
  There are four methods
    Push:   Adds a new element to the stack before the head
    Pop:    Removes and returns the head of the stack
    Peek:   View the head
    Print:  View the stack

*/
