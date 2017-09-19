public class test {
  public static void main(String[] args) {
    ArrayQueue queue = new ArrayQueue<Integer>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    Integer i = (Integer)queue.dequeue();
    System.out.println(i);
    i = (Integer)queue.dequeue();
    System.out.println(i);
    i = (Integer)queue.dequeue();
    System.out.println(i);
    i = (Integer)queue.dequeue();
    System.out.println(i);

  }
}
