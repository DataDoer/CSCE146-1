//Justin Baum
//00426510
import java.util.Random;

public class Search {
  private static int maxlinear = 1000;
  private static int maxbinary = 10;
  public static void main(String[] args) {
    int linearavg = 0;
    int binaryavg = 0;
    System.out.println("Welcome to the search tester.  We are going to see which algorithm performs the best out of 20 tests");
    int[] ourarray = new int[1000];
    Random randomgenerator = new Random();
    for(int i = 0; i < 20; i++) {
      //Populate new array;
      for(int n = 0; n < 1000; n++) {
        ourarray[n] = randomgenerator.nextInt(1000);
      }//for n
      swapSort(ourarray);
      //search
      int looking = randomgenerator.nextInt(1000);
      //linearSearch
      int linear = linearSearch(ourarray,looking);
      System.out.println("Searching using linear search");
      System.out.println((linear == -1) ? "Not Found" : "Found!");
      //binarySearch
      int binary = binarySearch(ourarray,looking);
      System.out.println("Searching using binary search");
      System.out.println((binary == -1) ? "Not Found" : "Found!");
      //Check if maxes were taken
      linear = (linear == -1) ? maxlinear : linear;
      binary = (binary == -1) ? maxbinary : binary;
      //Display numbers
      System.out.println("Linear Checks: " +linear);
      System.out.println("Binary Checks: " +binary);
      System.out.println();
      linearavg += linear;
      binaryavg += binary;
    }//for i
    linearavg /= 20;
    binaryavg /= 20;
    System.out.println("The average number of checks for 20:");
    System.out.println("Linear Checks: " +linearavg);
    System.out.println("Binary Checks: " +binaryavg);

  }//main

  //Return -1 for not found
  //Return n for steps
  public static int binarySearch(int[] numbers, int search, int minIndex, int maxIndex, int counter) {
    int mid = (minIndex+maxIndex)/2;
    if(numbers[mid] == search) return counter+1;//Halt
    if(minIndex >= maxIndex) return -1;//Did not find it //Halt
    //Split binary search one of two ways
    return (search < numbers[mid]) ? binarySearch(numbers, search, minIndex,mid-1,counter+1) : binarySearch(numbers, search, mid+1, maxIndex,counter+1);
  }//binarySearch
  public static int binarySearch(int[] numbers, int search) {//Place defaults
    return binarySearch(numbers,search,0,numbers.length-1,0);
  }//binarySearch

  public static int linearSearch(int[] numbers, int search) {
    int counter = 0;
    for(int i = 0; i < numbers.length; i++) {
      counter++;
      if(numbers[i] == search) return counter;
    }//for
    return -1;
  }//linearSearch

  public static void swapSort(int[] numbers) {
    for(int a = 0; a < numbers.length; a++) {
      for(int b = a; b < numbers.length; b++) {
        if(numbers[a] > numbers[b]) {
          int temp = numbers[a];
          numbers[a] = numbers[b];
          numbers[b] = temp;
        }//if
      }//for b
    }//for a
  }//swapSort

  public static String toStringA(int[] numbers) {
    String a = "{";
    for(int i = 0; i < numbers.length; i++) {
      a += numbers[i];
      a += ",";
    }
    a += "}";
    return a;
  }
}//Search
