//Justin Baum
//00426510
public class ArrayBinaryHeap<T extends Comparable> {
  private T[] heap;
  private int lastIndex;
  private static final int normalSize = 25;
  private static final int root = 1;
  public ArrayBinaryHeap(int size) {
    init(size);
  }//ArrayBinaryHeap
  public ArrayBinaryHeap() {
    init(normalSize);
  }//ArrayBinaryHeap


  public boolean isEmpty() {
    return lastIndex == root;
  }//isEmpty

  public boolean isFull() {
    return lastIndex == heap.length;
  }//isFull

  public void empty() {
    lastIndex = root;
  }//empty

  public void insert(T x) {
    if(isFull()) return;//Our heap is full
    heap[lastIndex] = x;
    bubbleUp(lastIndex);
    lastIndex++;
  }//insert

  public T remove() {
    if(isEmpty()) return null;
    T val = heap[root];
    swap(root,lastIndex-1);
    heap[lastIndex-1] = null;
    lastIndex--;
    bubbleDown();
    return val;
  }//remove

  public String heapSort() {//heapSort without deleting
    String b = "";
    ArrayBinaryHeap<T> abh = copy();
    while(!abh.isEmpty()){
      b += abh.remove()+"\n";
    }
    return b;
  }//heapsort

  public String toString() {
    String b = "";
    for(int a = root; a < lastIndex; a++) {
      b += heap[a] +"\n";
    }//for
    return b;
  }//toString

  public ArrayBinaryHeap<T> copy() {//Doesn't matter order, only trying to make a new one so we can delete it for heapSort
    ArrayBinaryHeap<T> abh = new ArrayBinaryHeap<T>(heap.length);
    for(int i = root; i < lastIndex; i++) {
      abh.insert(heap[i]);
    }
    return abh;
  }

  //Private helpers
  private void init(int size) {
    heap = (T[])(new Comparable[size]);
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
    T temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  private void bubbleUp(int index) {
    //So we are going to swap until we reach root
    //This is a maxheap so if the child is greater than the parent we are going to swap
    while(index > root && isGreater(index, parent(index))) {//While index is greater than root and the child is greater than the parent
      swap(index, parent(index));
      index = parent(index);
    }//while
  }//bubbleUp

  private void bubbleDown() {
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
