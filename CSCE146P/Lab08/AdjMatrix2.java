//Justin Baum
//00426510

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

  public void printCycles() {
    for(int i = 0; i < adjMatrix.length; i++) {//Been doing this on paper all day, finally got this to work
      printCycles(i, new ArrayList<Integer>());
    }
  }


  //privates
  private void init(int size) {
    if(size <= 0) return;
    adjMatrix = new double[size][size];
    markedVerts = new ArrayList<Integer>();
    visitedVerts = new ArrayList<Integer>();
  }//init


  public void DFS2(int fromVertex) {
    Stack<Integer> s = new Stack<Integer>();
    ArrayList<Integer> discovered = new ArrayList<Integer>();
    s.push(fromVertex);
    int v = fromVertex;
    while(!s.empty()) {
      v = s.pop();
      if(!discovered.contains(v)) {
        discovered.add(v);
        for(int edge : getEdges(v)) {
          s.push(edge);
        }
      }
    }
  }

  public void DFShelper(int fromVertex,ArrayList<Integer> visited) {
    visited.add(fromVertex);
    System.out.print(fromVertex+" ");

    for(int i = 0; i < adjMatrix.length; i++) {
      if(!visited.contains(i) && linked(fromVertex, i)) {
        DFShelper(i, visited);
      }
    }
  }

  private ArrayList<Integer> getEdges(int fromVertex) {
    ArrayList<Integer> edges = new ArrayList<Integer>();
    for(int i = 0; i < adjMatrix.length; i++) {
      if(linked(fromVertex,i)) edges.add(i);
    }
    return edges;
  }

  private void printTravelled(ArrayList<Integer> travelled) {
    if(travelled.size() == 1) return;
    for(int a : travelled) {
      System.out.print(a + " ");
    }
    System.out.println(travelled.get(0));
  }

  private ArrayList<Integer> deepCopyArrayList(ArrayList<Integer> arraylist) {//Don't want to use library for deepcopy
    ArrayList<Integer> newarray = new ArrayList<Integer>();
    for(Integer i : arraylist) newarray.add(i);
    return newarray;
  }

  private void printCycles(int index, ArrayList<Integer> travelled) {//This is the modificed DFS
    travelled.add(index);
    boolean leaf = true;
    for(int i = 0; i < adjMatrix.length; i++) {
      if(linked(index,i)) {
        leaf = false;
        if(!travelled.contains(i)) {//We have travelled here
          printCycles(i, deepCopyArrayList(travelled));
        } else if(travelled.get(0) == i) {//We have arived at the original, this is a cycle!
          printTravelled(travelled);
        }
      }
    }//for
    /* WE DON'T CARE ABOUT LEAVES
    Original algorithm I came up with gave every ending as well
    if(leaf){//This is a leaf
      printTravelled(travelled);
    }
    */
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
