//Justin Baum
//00426510
import java.io.*;
import java.util.*;

public class Graph5x5 extends AdjMatrix {
  private static final int[][] edges = {{0,1},{0,5},{0,6},{1,0},{1,2},{1,5},{1,6},{1,7},{2,1},{2,3},{2,6},{2,7},{2,8},
  {3,2},{3,4},{3,7},{3,8},{3,9},{4,3},{4,8},{4,9},{5,0},{5,1},{5,6},{5,10},{5,11},{6,0},{6,1},{6,2},{6,5},
  {6,7},{6,10},{6,11},{6,12},{7,1},{7,2},{7,3},{7,6},{7,8},{7,11},{7,12},{7,13},{8,2},{8,3},{8,4},{8,7},
  {8,9},{8,12},{8,13},{8,14},{9,3},{9,4},{9,8},{9,13},{9,14},{10,5},{10,6},{10,11},{10,15},{10,16},{11,5},{11,6},
  {11,7},{11,10},{11,12},{11,15},{11,16},{11,17},{12,6},{12,7},{12,8},{12,11},{12,13},{12,16},{12,17},{2,18},{13,7},
  {13,8},{13,9},{13,12},{13,14},{13,17},{13,18},{13,19},{14,8},{14,9},{14,13},{14,18},{14,19},{15,10},{15,11},
  {15,16},{15,20},{15,21},{16,10},{16,11},{16,12},{16,15},{16,17},{16,20},{16,21},{16,22},{17,11},{17,12},
  {17,13},{17,16},{17,18},{17,21},{17,22},{17,23},{18,12},{18,13},{18,14},{18,17},{18,19},{18,22},{18,23},{18,24},
  {19,13},{19,14},{19,18},{19,23},{19,24},{20,15},{20,16},{20,21},{21,15},{21,16},{21,17},{21,20},{21,22},{22,16},
  {22,17},{22,18},{22,21},{22,23},{23,17},{23,18},{23,19},{23,22},{23,24},{24,18},{24,19},{24,23}};
  private static final int size = 25;
  private static final int max = 5;
  public ArrayList<String> dictionary;
  public ArrayList<String> wordsfound;

  private char[] letters;

  public Graph5x5() {
    super(size);
    for(int[] edge : edges) {//Generate a 5x5 board
      addEdge(edge[0],edge[1],1);
    }
    letters = new char[size];
    dictionary = new ArrayList<String>();
    wordsfound = new ArrayList<String>();
  }//Graph

  public void addDictionary(String word) {
    dictionary.add(word);
  }
  public void wordsfound() {
    System.out.print(wordsfound);
  }
  public void addLetter(int index, char letter) {
    if(index >= 0 && index < size) letters[index] = letter;
  }//addLetter
  public void printCycles() {
    for(int i = 0; i < adjMatrix.length; i++) {//Been doing this on paper all day, finally got this to work
      wordsfound.add("STARTING "+(i/max)+" "+(i%max));
      printCycles(i, new ArrayList<Integer>());
    }
  }
  public void printCycles(int index, ArrayList<Integer> travelled) {//This is the modificed DFS
    travelled.add(index);
    boolean leaf = true;
    for(int i = 0; i < adjMatrix.length; i++) {
      if(linked(index,i)) {
        leaf = false;
        if(!travelled.contains(i) && travelled.size() < 5) {//We have travelled here
          printCycles(i, deepCopyArrayList(travelled));
        } else if(travelled.get(0) == i) {//We have arived at the original, this is a cycle!
          String wordfound = printTravelled(travelled);
          if(wordfound.length() > 1) wordsfound.add(wordfound);
        }
      }
    }
  }

  public String printTravelled(ArrayList<Integer> travelled) {
    String s = "";
    for(int a : travelled) {
      s += getletter(a);
    }
    return s;
  }

  public char getletter(int index) {
    return letters[index];
  }

  private ArrayList<Integer> deepCopyArrayList(ArrayList<Integer> arraylist) {//Don't want to use library for deepcopy
    ArrayList<Integer> newarray = new ArrayList<Integer>();
    for(Integer i : arraylist) newarray.add(i);
    return newarray;
  }

}
