//Justin Baum
//00426510

import java.util.*;

public class BortSort {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    SearchAlgorithms SA = new SearchAlgorithms();
    //Want to make this into an array.
    QueueInterface strings = new LinkedListQueue<String>();
    String userin = "";
    int counter = 0;
    System.out.println("Enter any number of strings and I will sort by BORT’s.  Once you’re done entering sentences enter \"quit\".");
    while(!userin.toLowerCase().equals("quit")) {
      userin = in.nextLine();
      strings.enqueue(userin.toLowerCase());
      counter++;
    }
    //Get rid of last "quit"
    counter--;

    //Make array
    String[] stringsArray = new String[counter];
    for(int i = 0; i < counter; i++) {
      stringsArray[i] = (String)strings.dequeue();
      //System.out.println(stringsArray[i]);
    }
    System.out.println("In order it goes:");

    stringsArray = SA.MergeSortBort(stringsArray);
    for(int i = 0; i < counter; i++) {
      System.out.println(stringsArray[i]);
    }

  }
}
