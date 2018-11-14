public class ArrayBinaryHeapTest {
  public static void main(String[] args) {
    JeepHeap abh = new  JeepHeap();
    //ArrayBinaryHeap<Integer> abh = new ArrayBinaryHeap<Integer>();
    for(int i = 0; i < 5; i++) {
      abh.insert(new Jeep("Jeep " + i, i*20, i*200));
    }
    System.out.println(abh);
    System.out.println(abh.heapSort());
    System.out.println(abh.remove());
    System.out.println(abh.remove());
    System.out.println(abh.remove());
    System.out.println(abh.remove());

    System.out.println(abh.remove());
  }
}
