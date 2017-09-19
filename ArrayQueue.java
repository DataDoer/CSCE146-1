public class ArrayQueue <T> implements QueueInterface {
  private final int DEFAULT_SIZE = 100;

  private T[] queue;
  private int tailIndex; //This index is one past the last element

  public ArrayQueue() {
    queue = new T[DEFAULT_SIZE];
    tailIndex = 0;
  }//ArrayQueue

  public ArrayQueue(int length) {
    queue = new T[length];
    tailIndex = 0;
  }//ArrayQueue
  
  public void enqueue(T data) {

  }//enqueue
  public T dequeue() {

  }//dequeue
  public T peek(){

  }//oeek
  public void print(){

  }//print
}//ArrayQueue
