//Justin Baum
//00426510

import java.util.*;


public class SearchAlgorithms {

  public SearchAlgorithms() {
    //Don't want to deal with static variable if I don't have to
  }



  public int SelectionSort(int[] array){
    int checks = 0;
    for(int i = 0; i < array.length; i++) {
      int minIndex = i;
      for(int j = i; j < array.length; j++) {//Get lowest value from i-end
        if(array[minIndex] > array[j]) minIndex = j; //swap lowest value for i and repeat
        checks++;
      }//for j
      Swap(array,minIndex,i);
    }//for i
    return checks;
  }//SelectionSort


  public int bubbleSort(int[] array) {
    int checks = 0;
    boolean swap = true;
    while(swap) {
      //WE keep swapping until there are no more swaps to be made
      swap = false;
      for(int i = 0; i < array.length-1; i++) {//I'm pretty sure it was shown in class
      checks++;
        if(array[i] > array[i+1]) {//Check if side by side r they in order?
          swap = true;//If one is out of order we have to redo everything
          //swap
          Swap(array,i,i+1);
        }//if
      }//for
    }//while
    return checks;
  }//BubbleSort


  /*QUICKSORT
  Goal: Pick pivot and move all values lower to the left, and higher to the right;
  1.  Pick a pivot
  2.  Take two indices and count from left and right
  3.  Left will be lower than pivot
  4.  Right will be higer than pivot
  5.**While left is less than pivot move right
  6.**While right is greater than pivot move left
  7.  If right and left do fall out of those, SWAP
  8.  If left >= right make new pivot and split?
  */


  public int quickSort(int[] array) {
    return QuickSort(array, 0, array.length-1);
  }

  public int QuickSort(int[] array, int left, int right) {
    int i = left;
    int j = right;
    int pivot = array[(left+right)/2];
    if(left > right) return 1;//I deviated from the algorithms online
    //I like this halt better

    while(i <= j) {
      while(array[i] < pivot) {//Push I to the first value greater than the pivot
        i++;
      }
      while(array[j] > pivot) {//Push J to the fitst value lesser than the pivot
        j--;
      }
      if(i <= j) {//I and J have flipped
        Swap(array, i, j);
        i++;
        j--;
      }//if
    }//while i<=j
    return QuickSort(array, left, j)+QuickSort(array, i, right);
  }//QuickSort

  public void Swap(int[] array, int i, int j) {
    //Swap to make my life easier
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public void heapSort(int[] nums) {
    int size = nums.length+5;
    ArrayBinaryHeap<Integer> Sorter = new ArrayBinaryHeap<Integer>(size);
    for(int number : nums) {
      Sorter.insert(number);
    }
    int[] newnums = new int[nums.length];
    int i = nums.length - 1;
    while(!Sorter.isEmpty() && i >= 0) {
      nums[i] = Sorter.remove();
      i--;
    }

  }
  public void Debug(int[] array) {
    System.out.print("[");
    for(int i = 0; i < array.length; i++) {
      System.out.print(array[i] + ",");
    }
    System.out.println("]");
  }



}
