//Justin Baum
//00426510

import java.util.*;
import java.lang.Math;

public class Sort {
  public static void main(String args[]) {
    int x = 1000;
    Random r = new Random(x);
    SearchAlgorithms sa = new SearchAlgorithms();
    int[] selectionArray = new int[x];
    int[] bubbleArray = new int[x];
    int[] quickArray = new int[x];
    int[] mergeArray = new int[x];
    for(int i = 0; i < x; i++) {
      //Initialize 4 identical arrays
      int n = r.nextInt(x);
      selectionArray[i] = n;
      bubbleArray[i] = n;
      quickArray[i] = n;
      mergeArray[i] = n;
    }
    //System.out.print("The array looks like: ");
    //sa.Debug(selectionArray);

    //SelectionSort
    System.out.println("SelectionSort");
    System.out.println("The system made " + sa.SelectionSort(selectionArray) + " comparisons.");
    System.out.println("The array looks " + ((sa.isSorted(selectionArray)) ? "sorted" : "unsorted"));
    //sa.Debug(selectionArray);

    //BubbleSort
    System.out.println("BubbleSort");
    System.out.println("The system made " + sa.BubbleSort(bubbleArray) + " comparisons.");
    System.out.println("The array looks " + ((sa.isSorted(bubbleArray)) ? "sorted" : "unsorted"));
    //sa.Debug(bubbleArray);

    //QuickSort
    System.out.println("QuickSort");
    System.out.println("The system made " + sa.QuickSort(quickArray) + " comparisons.");
    System.out.println("The array looks " + ((sa.isSorted(quickArray)) ? "sorted" : "unsorted"));
    //sa.Debug(quickArray);

    //MergeSort
    mergeArray = sa.MergeSort(mergeArray);
    int merges = (int)(x*(Math.log(x)/Math.log(2)));
    //I couldn't count merges
    System.out.println("MergeSort");
    System.out.println("The system made about " + merges + " comparisons.");
    System.out.println("The array looks " + ((sa.isSorted(mergeArray)) ? "sorted" : "unsorted"));
    //sa.Debug(mergeArray);
  }
}
