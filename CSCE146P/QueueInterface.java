public interface QueueInterface <T> {
  public void enqueue(T data); //Add data
  public T dequeue();//Remove data
  public T peek();//Returns object but doesn't remove
  public void print();
}

/*
Queues
  FIFO - First in first out
  Waiting in line is a great example
  Can be represented by any simple abstract data structure
  Arrays or Linked

Four methods
    Enqueue - add
    Dequeue - remove
    Peek - look at head
    Print - print
*/
