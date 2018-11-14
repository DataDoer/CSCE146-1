//Justin Baum
//00426510

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    AdjMatrix adjmatrix = new AdjMatrix();
    //Add original edges
    int[][] edges = {{1,5},{2,1},{3,1},{4,2},{5,2},{5,3},{5,7},{6,3},{7,4},{7,6}};//These are the edges the prompt gave us
    //int[][] edges = {{1,2},{2,3}};
    for(int[] edge : edges) {//We're inserting the edges, I chose this way to make it very easy to show the functionality of AdjMatrix
      adjmatrix.addEdge(edge[0],edge[1],1.);
    }
    adjmatrix.printCycles();
  }
}
