import java.util.*;

public class AdjMatrix {
  public static final int DEFAULT_SIZE = 10;
  private double[][] adjMatrix;
  private ArrayList<Integer> markedVerts;
  private ArrayList<Integer> visitedVerts;

  public AdjMatrix() {
    init(DEFAULT_SIZE);
  }//AdjMatrix

  public AdjMatrix(int size) {
    init(size);
  }//AdjMatrix


  public addEdge(int fromVertex, int toVertex, double weight) {
    if(fromVertex < 0 || toVertex < 0 || fromVertex >= adjMatrix.length || toVertex >= adjMatrix.length) return;//make sure our indices are inbounds
    adjMatrix[fromVertex][toVertex] = weight;
  }//addEdge

  public void printAdjMatrix() {
    for(int i = 0; i < adjMatrix.length; i++) {
      for(int j = 0; j < adjMatrix.length; j++) {
        System.out.print(adjMatrix[i][j]+" ");
      }//for
    }//for
    System.out.println();
  }//printAdjMatrix

  public void printDFS() {
    markedVerts.clear();
    printDFS(0);
  }//printDFS

  public void printBFS() {
    markedVerts.clear();
    visitedVerts.clear();
    printBFS(0);
  }//printBFS

  //privates
  private void init(int size) {
    if(size <= 0) return;
    adjMatrix = new double[size][size];
    markedVerts = new ArrayList<Integer>();
    visitedVerts = new ArrayList<Integer>();
  }//init

  private void printDFS(int index) {
    System.out.println(index);
    markedVerts.add(index);
    for(int i = 0; i < adjMatrix[index].length; i++) {
      if(adjMatrix[index][i] != 0 && !markedVerts.contains(i)) printDFS(i);
    }//for
  }//printDFS recursive

  private void printBFS(int index) {
    if(!visitedVerts.contains(index)) {
      System.out.println(index);
      visitedVerts.add(index);
    }
    markedVerts.add(index);
    //Visit Neighbors
    for(int i = 0; i < adjMatrix[index].length; i++) {
      if(adjMatrix[index][i] != 0 && !visitedVerts.contains(i)) {
        System.out.println(i);
        visitedVerts.add(i);
      }//if
    }//for
    for(int i = 0; i < adjMatrix[index].length; i++) {
      if(adjMatrix[index][i] != 0 && !markedVerts.contains(i)) {
        printBFS(i);
      }//if
    }//for
  }//printBFS recursive
}//AdjMatrix
