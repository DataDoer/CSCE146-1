//Justin Baum
//00426510

public class JeepHeap {
  private Jeep[] heap;
  private int lastIndex;
  private static final int normalSize = 25;
  private static final int root = 1;
  public JeepHeap(int size) {
    init(size);
  }//JeepHeap
  public JeepHeap() {
    init(normalSize);
  }//JeepHeap


  public boolean isEmpty() {
    return lastIndex == root;
  }//isEmpty

  public boolean isFull() {
    return lastIndex == heap.length;
  }//isFull

  public void empty() {
    lastIndex = root;
  }//empty

  public void addJeep(Jeep x) {
    if(isFull()) return;//Our heap is full
    heap[lastIndex] = x;
    driveUp(lastIndex);
    lastIndex++;
  }//insert

  public Jeep removeJeep() {
    if(isEmpty()) return null;
    Jeep val = heap[root];
    swap(root,lastIndex-1);
    heap[lastIndex-1] = null;
    lastIndex--;
    driveDown();
    return val;
  }//remove

  public String JeepHeapSort() {//heapSort without deleting
    String b = "";
    JeepHeap abh = copy();
    while(!abh.isEmpty()){
      b += abh.removeJeep()+"\n";
    }
    return b;
  }//heapsort

  public String JeepRollCall() {
    String b = "";
    for(int a = root; a < lastIndex; a++) {
      b += heap[a] +"\n";
    }//for
    return b;
  }//toString

  public JeepHeap copy() {//Doesn't matter order, only trying to make a new one so we can delete it for heapSort
    JeepHeap abh = new JeepHeap(heap.length);
    for(int i = root; i < lastIndex; i++) {
      abh.addJeep(heap[i]);
    }
    return abh;
  }

  //Private helpers
  private void init(int size) {
    heap = new Jeep[size];
    lastIndex = root;
    /*
    I use a magic number(root =1) for this reason I want the tree to look like the one in class
              1
          2          3
        4    5     6      7
      8,9  10,11  12,13  14,15
    */
  }//init

  private int parent(int i) {
    return (i)/2;
  }//parent

  private int childRight(int i) {
    return child(i)+1;
  }//childRight

  private int childLeft(int i) {
    return child(i);
  }//childLeft

  private int child(int i) {
    return i*2;
  }//child

  //"Bubble up and down" percolation functions

  private void swap(int i, int j) {
    Jeep temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  private void driveUp(int index) {
    //So we are going to swap until we reach root
    //This is a maxheap so if the child is greater than the parent we are going to swap
    while(index > root && isGreater(index, parent(index))) {//While index is greater than root and the child is greater than the parent
      swap(index, parent(index));
      index = parent(index);
    }//while
  }//bubbleUp

  private void driveDown() {
    int index = root;
    while(index < lastIndex) {
      if(childRight(index) < lastIndex) { //If our childRight is still in play
        if(isGreater(childRight(index),index) || isGreater(childLeft(index),index)) { //If our children are greater than their parents
          if(isGreater(childRight(index),childLeft(index))) {//Our right child is bigger
            swap(index, childRight(index));
            index = childRight(index);
            continue;
          } else {
            swap(index, childLeft(index));
            index = childLeft(index);
            continue;
          }//if else
        } else return;//if else
      } else if(childLeft(index) < lastIndex) {
        if(isGreater(childLeft(index),index)) {
          swap(index, childLeft(index));
          index = childLeft(index);
          continue;
        } else return;
      } else return;//We reached a leaf

    }
  }//bubbleDown

  public boolean isGreater(int index1, int index2) {
    return heap[index1].compareTo(heap[index2]) > 0;
  }//isGreater
}
