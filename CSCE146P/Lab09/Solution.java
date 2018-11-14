//Justin Baum
//00426510

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    AdjMatrix adjmatrix = new AdjMatrix(8);
    //Add original edges
    int[][] edges = {{1,2},{1,4},{2,4},{3,1},{3,5},{4,3},{4,5},{5,6},{5,7}};//These are the edges the prompt gave us
    //int[][] edges = {{1,2},{2,3}};
    for(int[] edge : edges) {//We're inserting the edges, I chose this way to make it very easy to show the functionality of AdjMatrix
      adjmatrix.addEdge(edge[0],edge[1],1.);
    }
    System.out.println("Depth First Search from Each Node.");
    adjmatrix.printDFS();
    System.out.println("Breadth First Search from Each Node.");
    adjmatrix.printBFS();
  }
}
