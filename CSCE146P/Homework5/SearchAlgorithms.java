//Justin Baum
//00426510

import java.util.*;


public class SearchAlgorithms {

  public SearchAlgorithms() {
    //Don't want to deal with static variable if I don't have to
  }

  //BORT VALUE FOR SEARCH
  public int value(String aValue, String bort) {
    int aValueLen = aValue.length();
    int bortLen = bort.length();
    int counter = 0;
    for(int i = 0; i <= aValueLen - bortLen; i++) {//Give us index to search for borts;
      String substring = aValue.substring(i,i+bortLen);
      if(substring.equals(bort)) {
        counter++;
      }//if
    }//for
    return counter;
  }//value bort


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

  public void SelectionSortBort(String[] array){//Code for bort
    for(int i = 0; i < array.length; i++) {
      int minIndex = i;
      for(int j = i; j < array.length; j++) {
        if(value(array[minIndex],"bort") > value(array[j],"bort")) minIndex = j;//Search for how many borts
      }//for j
      //SWAP
      Swap(array,minIndex,i);
    }//for i
  }//SelectionSort

  public int BubbleSort(int[] array) {
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


  public int QuickSort(int[] array) {
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

  public void Swap(String[] array, int i, int j) {
    String temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public int[] MergeSort(int[] array) {
    int length = array.length;
    if(length <= 1) {
      return array;
    }
    int[] array1 = Arrays.copyOfRange(array, 0, length/2);
    int[] array2 = Arrays.copyOfRange(array, length/2, length);
    array1 = MergeSort(array1);
    array2 = MergeSort(array2);
    int[] fullarray = Merge(array1, array2);

    return fullarray;
  }

  public int[] Merge(int[] array1, int[] array2) {
    int total = array1.length+array2.length;
    int[] newArray = new int[total];
    int i = 0; //index for array1
    int j = 0; //index for array2
    while(i < array1.length && j < array2.length) {//Merge the two arrays, can't figure another way, supposedly some guides say to use another sorting algorithm
      if(array1[i] < array2[j]) {
        newArray[i+j] = array1[i];
        i++;
      } else {
        newArray[i+j] = array2[j];
        j++;
      }
    }//while
    if(i+j < total) {
      while(i < array1.length) {
        newArray[i+j] = array1[i];
        i++;
      }
      while(j < array2.length) {
        newArray[i+j] = array2[j];
        j++;
      }
    }
    return newArray;
  }

  public String[] MergeBort(String[] array1, String[] array2) {
    int total = array1.length+array2.length;
    String[] newArray = new String[total];
    int i = 0; //index for array1
    int j = 0; //index for array2
    while(i < array1.length && j < array2.length) {//Merge the two arrays, can't figure another way, supposedly some guides say to use another sorting algorithm
      if(value(array1[i],"bort") < value(array2[j],"bort")) {
        newArray[i+j] = array1[i];
        i++;
      } else {
        newArray[i+j] = array2[j];
        j++;
      }
    }//while
    if(i+j < total) {
      while(i < array1.length) {
        newArray[i+j] = array1[i];
        i++;
      }
      while(j < array2.length) {
        newArray[i+j] = array2[j];
        j++;
      }
    }
    return newArray;
  }

  public String[] MergeSortBort(String[] array) {
    int length = array.length;
    if(length <= 1) {
      return array;
    }
    String[] array1 = Arrays.copyOfRange(array, 0, length/2);
    String[] array2 = Arrays.copyOfRange(array, length/2, length);
    array1 = MergeSortBort(array1);
    array2 = MergeSortBort(array2);
    return MergeBort(array1, array2);
  }

  public boolean isSorted(int[] array) {
    //For the check in the homework
    for(int i = 0; i < array.length-1; i++) {
      if(array[i] > array[i+1]) return false;
    }
    return true;
  }

  public void Debug(int[] array) {
    System.out.print("[");
    for(int i = 0; i < array.length; i++) {
      System.out.print(array[i] + ",");
    }
    System.out.println("]");
  }

}
