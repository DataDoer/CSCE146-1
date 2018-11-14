//00426510
//Justin Baum

public class ProcessHeap {
  private Process[] heap;
  public static final int DEFAULT_SIZE = 128;
  private int lastIndex;
  public ProcessHeap(int size) {
    init(size);
  }//ArrayBinaryHeap
  public ProcessHeap() {
    init(DEFAULT_SIZE);
  }///ArrayBinaryHeap
  private void init(int size) {
    if(size <= 0) return;

    heap = new Process[size];
    lastIndex = 0;
  }//init

  public void insert(Process value) {
    if(lastIndex >= heap.length) return;//Heap is full
    heap[lastIndex] = value;
    bubbleUp();
    lastIndex++;
  }//insert

  private void bubbleUp() {
    int index = lastIndex;
    while(index > 0 && heap[(index-1)/2].compareTo(heap[index]) < 0) {
      //Child was greater than the parent so swap
      swap((index-1)/2,index);
    }
  }//bubbleUp

  public Process peek() {
    if(heap==null) return null;
    return heap[0];
  }

  private void swap(int i, int j) {
    Process temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }//swap

  public Process remove() {
    if(lastIndex == 0) return null;
    Process retval = heap[0];
    heap[0] = heap[lastIndex-1];
    lastIndex--;
    bubbleDown();
    return retval;
  }//remove

  private void bubbleDown() {
    int index = 0;
    while(index*2+1 < lastIndex) {
      int bigIndex = index*2+1;
      if(index*2+2 < lastIndex && heap[bigIndex].compareTo(heap[index*2+2]) < 0) {
        //Right child existed and was larger
        bigIndex = index*2+2;
      }
      if(heap[index].compareTo(heap[bigIndex]) < 0) {
        //Parent was smaller, swap
        swap(index, bigIndex);
      } else break;//We are done
      index = bigIndex;
    }//while
  }//bubbleDown


    public boolean isEmpty() {
      return lastIndex == heap.length-1;
    }

    public void printHeap() {
      for(int i = lastIndex; i >= 0 && heap[i] != null; i--) {
        System.out.println(heap[i]);
      }
    }

    public void heapSort() {
      while(lastIndex != 0) {
        System.out.println(this.remove());
      }
    }//heapSort
}//ArrayBinaryHeap
