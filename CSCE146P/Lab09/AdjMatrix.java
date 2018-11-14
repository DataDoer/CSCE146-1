//Justin Baum
//00426510

import java.util.*;

public class AdjMatrix {
  public static final int DEFAULT_SIZE = 10;
  private double[][] adjMatrix;

  public AdjMatrix() {
    init(DEFAULT_SIZE);
  }//AdjMatrix

  public AdjMatrix(int size) {
    init(size);
  }//AdjMatrix


  public void addEdge(int fromVertex, int toVertex, double weight) {
    if(fromVertex < 0 || toVertex < 0 || fromVertex >= adjMatrix.length || toVertex >= adjMatrix.length) return;//make sure our indices are inbounds
    adjMatrix[fromVertex][toVertex] = weight;
  }//addEdge

  public boolean linked(int fromVertex, int toVertex) {
    if(fromVertex < 0 || toVertex < 0 || fromVertex >= adjMatrix.length || toVertex >= adjMatrix.length) return false;//make sure our indices are inbounds
    return adjMatrix[fromVertex][toVertex] != 0.0;
  }

  public void printAdjMatrix() {
    for(int i = 0; i < adjMatrix.length; i++) {
      for(int j = 0; j < adjMatrix.length; j++) {
        System.out.print(adjMatrix[i][j]+" ");
      }//for
      System.out.println();
    }//for
  }//printAdjMatrix

  public void printDFS() {
    for(int i = 0; i < adjMatrix.length; i++) {
      System.out.print(i+"'s DFS: ");
      printDFS(i);
      System.out.println();
    }
  }
  public void printBFS() {
    for(int i = 0; i < adjMatrix.length; i++) {
      System.out.print(i+"'s BFS: ");
      printBFS(i);
      System.out.println();
    }
  }

  private void printDFS(int index){
    ArrayList<Integer> visited = new ArrayList<Integer>();
    visited.add(index);
    printDFS(index, visited);
  }


  private void printDFS(int index, ArrayList<Integer> visited) {
    for(int i = 0; i < adjMatrix.length; i++) {
      if(linked(index,i) && !visited.contains(i)) {
        visited.add(i);
        System.out.print(i+ " ");
        printDFS(i,visited);
      }
    }//for
  }

  private void printBFS(int index) {
    ArrayList<Integer> cannotVisit = new ArrayList<Integer>();
    cannotVisit.add(index);
    printBFS(index, cannotVisit);
  }

  private void printBFS(int index, ArrayList<Integer> cannotVisit) {
    //First check first breadth
    ArrayList<Integer> needtoVisit = new ArrayList<Integer>();
    for(int i = 0; i < adjMatrix.length; i++) {
      if(linked(index,i) && !cannotVisit.contains(i)) {
        needtoVisit.add(i);
        cannotVisit.add(i);
        System.out.print(i+" ");
      }
    }
    for(int i : needtoVisit) {
      printBFS(i, deepCopyArrayList(cannotVisit));
    }
  }

  private void init(int size) {
    if(size <= 0) return;
    adjMatrix = new double[size][size];
  }//init


  private ArrayList<Integer> deepCopyArrayList(ArrayList<Integer> arraylist) {//Don't want to use library for deepcopy
    ArrayList<Integer> newarray = new ArrayList<Integer>();
    for(Integer i : arraylist) newarray.add(i);
    return newarray;
  }


}//AdjMatrix


/*private void printCycles(int index, ArrayList<Integer> travelled) {
  travelled.add(index);
  boolean leaf = true;
  for(int i = 0; i < adjMatrix.length; i++) {
    if(linked(index,i)) {
      leaf = false;
      if(travelled.contains(i)) {//We have travelled here
        printTravelled(travelled);
      } else {
        printCycles(i, travelled);
      }
    }
  }//for
  if(leaf){//This is a leaf
    printTravelled(travelled);
  }
}*/
