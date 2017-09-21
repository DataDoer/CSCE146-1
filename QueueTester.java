import java.util.*;

public class QueueTester {
  public static void main(String[] args) {
    QueueInterface<Integer> queue = new ArrayQueue<Integer>();
    QueueInterface<Integer> linkedQueue = new LinkedListQueue<Integer>();

    for(int i = 0; i < 10; i++) {
      queue.enqueue(i);
    }

    for(int i = 0; i < 10; i++) {
      System.out.println(queue.dequeue());
    }

    for(int i = 0; i < 10; i++) {
      linkedQueue.enqueue(i);
    }

    for(int i = 0; i < 10; i++) {
      System.out.println(linkedQueue.dequeue());
    }


    //JAVA BUILTIN
    Queue<Integer> queue2 = new LinkedList<Integer>();

  }
}
