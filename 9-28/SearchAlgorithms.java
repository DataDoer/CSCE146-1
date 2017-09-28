public class SearchAlgorithms {

  public static void main(String[] args) {
    int[] a = {1,2,3,4,5,6,7,8,9,10};
  }//main

  public static boolean linSearchIter(int[] a, int value) {
    //Search one by one
    for(int i = 0; i < a.length; i++) {
      if(a[i] == value) return true;
    }//for
    return false;
  }//linSearchIter

  public static boolean linSearchRecur(int [] a, int value) {
    //Same as above recursively
    if(a[0] == value) return true;
    if(a.length <= 1) return false;
    return false;
  }//linSearchRecur

  public static boolean binSearchRecur(int[] a, int value, int minIndex, int maxIndex) {
    //Assume a is sorted
    int midIndex = (maxIndex+minIndex)/2;
    if(minIndex > maxIndex) {
      return false;
    }//if (halting condition)

    if(a[midIndex] == value) return true;//Found the value
    else {
      if(value > a[midIndex]) return binSearchRecur(a, value, midIndex+1, maxIndex);
      else return binSearchRecur(a,value,minIndex,midIndex-1);
    }//if else
  }//binSearchRecur

  public static void bubbleSort(int[] a) {
    boolean hasSwapped = true;
    while(hasSwapped) {//Keep running until no swaps are made
      hasSwapped = false;
      for(int i = 0; i< a.length-1; i++) {
        if(a[i] > a[i+1]) {//Out of order
          //Need to swap
          int temp = a[i];
          a[i] = a[i+1];
          a[i+1] = temp;
          hasSwapped = true;
        }//if
      }//for
    }//while
  }//bubbleSort
}//SearchAlgorithms

/*
Asymptotic
  Which is a better algorithm? How do we measure efficiency?
  How theoretically fast an algorithm fast an algorithm will perform or how much space in memory an algorithm will consume
  Once you understand this you can prove someone's code sucsk using math
Back up
  Let's look at the last problem we solved
  The worst case scenario for a search is the item we are looking for is not there
  Keep in mind you see "n" that corresponds to the data you're processing
Sequential Search
  Worst case scenario for: {1,2,3,4,5,6,7}
    Look for 8(not there)
    Takes n steps
  f(n) = O(n)
    O notation
Binary Search
  Worst case scenario for: {1,2,3,4,5,6,7}
    Look for 8(not there)
    Takes n steps
  f(n) = O(lg(n))
    log2(n) = lg(n)
    O notation

Common Big O
  O(1)        constant
  O(lg(n))    logaritmic
  O(n)        linear
  O(nlog(n))  linearithmic
  O(n^2)      quadratic
  O(2^n)      exponential
  O(n!)       factorial



*/
/*
public static boolean linSearchIter(int[] a, int value) {
  //Search one by one
  for(int i = 0; i < a.length; i++) { //O(n)
    if(a[i] == value) return true; //O(1)
  }//for
  return false; //O(1)
}//linSearchIter

//O(?) = (O(n)*O(1))+O(1)
//       for*(if+rtn)+rtn

public static boolean binSearchRecur(int[] a, int value, int minIndex, int maxIndex) {
  //Assume a is sorted
  int midIndex = (maxIndex+minIndex)/2;//O(1)
  if(minIndex > maxIndex) {//O(1)
    return false;//O(1)
  }//if (halting condition)

  if(a[midIndex] == value) return true;//Found the value//O(2)
  else {
    if(value > a[midIndex]) return binSearchRecur(a, value, midIndex+1, maxIndex);//O(lg(n))
    else return binSearchRecur(a,value,minIndex,midIndex-1);//O(lg(n))
  }
}
//(O(1)+O(1)+O(1)+O(1)+O(1))*(O(lg(n)) OR O(lg(n)))
//5*O(1) * (O(lg(n)))
//OR
//5*O(1) * (O(lg(n)))
//WORST CASE: O(lg(n))


public satic void bubbleSort(int[] a) {
  boolean hasSwapped = true;
  while(hasSwapped) {//Keep running until no swaps are made //O(n) --> Worst case scenario get backwards array
    hasSwapped = false;
    for(int(i = 0; i< a.length-1; i++)) {//O(n) --> Worst Case Make every swap
      if(a[i] > a[i+1]) {//Out of order //O(1)
        //Need to swap
        int temp = a[i];//O(1)
        a[i] = a[i+1];//O(1)
        a[i+1] = temp;//O(1)
        hasSwapped = true;//O(1)
      }//if
    }//for
  }//while
}//bubbleSort

//O(n)*(O(1)+... + O(n))
//O(n^2)
//Quadratic
*/
