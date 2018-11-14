//Justin Baum
//00426510

import java.util.*;

public class AdjMatrix {
  public static final int DEFAULT_SIZE = 10;
  public double[][] adjMatrix;

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


  private void init(int size) {
    if(size <= 0) return;
    adjMatrix = new double[size][size];
  }//init


  public ArrayList<Integer> deepCopyArrayList(ArrayList<Integer> arraylist) {//Don't want to use library for deepcopy
    ArrayList<Integer> newarray = new ArrayList<Integer>();
    for(Integer i : arraylist) newarray.add(i);
    return newarray;
  }


}//AdjMatrix
