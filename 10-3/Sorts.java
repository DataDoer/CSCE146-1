import java.util.Random;
public class Sorts {
  public static void main(String[] args) {
    //TODO Auto generated method stub
    Random r = new Random();
    int[] a = new int[10];
    for(int i = 0; i < a.length; i++) {//Make new array
      a[i] = r.nextInt(100);;
    }//for
    //TODO sort
  }//main

  public static void mergeSort(int[] a) {
    int size = a.length;
    if(size < 2) return;
    int mid = size/2;
    int leftSize = mid;
    int rightSize = size-mid;

    int[] left = new int[leftSize];
    int[] right = new int[rightSize];
    //populate the left array
    for(int i = 0; i < mid; i++) {
      left[i] = a[i];
    }

    //populate the right array
    for(int i = mid; i < size; i++) {
      right[i-mid] = a[i];
    }
    mergeSort(left);
    mergeSort(right);
    //TODO Merge

  }//mergeSort

  private static void merge(int[] left, int[] right, int[] a) {
    int leftSize = left.length;
    int rightSize = right.length;
    int i = 0; //Left array index;
    int j = 0; //Right array index;
    int k = 0; //Sorted arrat index;

    while(i < leftSize && j < rightSize) {
      if(left[i] <= right[j]) {
        a[k] = left[i];
        i++;//Increase index for left
      } else {
        a[k] = right[j];
        j++;//Increase index for right
      }
      k++;
    }//while
    //If arrays are different size;
    //Fill out rest of values;
    while(i<leftSize) {
      a[k] = left[i];
      i++;
      k++;
    }//while
    while(j<rightSize) {
      a[k] = right[j];
      j++;
      k++;
    }//while
  }//merge

  public static void quickSortTail(int[] a, int left, int right) {
    if(left < right) {
      int partition = partition(a,left,right);
      quickSortTail(a,left,partition-1);
      quickSortTail(a,partition+1,right);
    }//if
  }//quickSortTail

  private static int partition(int[] a, int left, int right) {
    int pivot = a[right];//Set pivot to last value
    int i = left;
    int j = left;
    while(j<right) {
      if(a[j] < pivot) {
        //swap
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        i++;
      }//if
      j++;
    }//while
    //fix up swap
    int temp = a[i];
    a[i] = a[right];
    a[right] = temp;
    return i;
  }//partition
}//Sorts
