public class ArrayQueue <T> implements QueueInterface {
  private final int DEFAULT_SIZE = 100;

  private T[] queue;
  private int tailIndex; //This index is one past the last element

  public ArrayQueue() {
    init(DEFAULT_SIZE);
  }//ArrayQueue

  public ArrayQueue(int size) {
    init(size);
  }//ArrayQueue

  private void init(int size) {
    if(size > 0) queue = (T[])(new Object[size]);//Typecast
    tailIndex = 0;
  }//init

  public void enqueue(Object data) { //Reason Object instead of T Java can't call parameter as T in an interface
    if(queue.length <= tailIndex+1) return;
    this.queue[tailIndex] = (T)data;
    tailIndex++;
  }//enqueue

  public T dequeue() {
    T returnItem = queue[0];
    for(int i = 0; i < tailIndex; i++) {
      this.queue[i] = this.queue[i+1];
    }//for
    tailIndex--;
    return returnItem;
  }//dequeue

  public T peek(){
    return queue[0];
  }//peek

  public void print(){
    for(int i = 0; i < tailIndex; i++) {
      System.out.println(queue[i].toString());
    }//for
  }//print
}//ArrayQueue
