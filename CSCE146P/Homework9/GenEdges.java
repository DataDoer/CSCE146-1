//Justin Baum
//00426z10

import java.util.*;

public class Solution {
  public static final int z = 5;
  public static void main(String[] args) {
    AdjMatrix adjmatrix = new AdjMatrix(8);
    //Add original edges
    int[][] matrix = new int[z][z];
    for(int i = 0; i < z; i++) {
      for(int j = 0; j < z; j++) {
        for(int a = -1; a <= 1; a++) {
          for(int b = -1; b <= 1; b++) {
            int x = i + a;
            int y = j + b;
            if(isLegal(x,y) && !(a==0 && b ==0)) {
              System.out.print("{"+adjSpot(i,j)+","+adjSpot(x,y)+"},");
            }
          }//forb
        }//fora
      }//forj
    }//fori
  }//main

  public static boolean isLegal(int x, int y) {
    return x < z && x >= 0 && y < z && y >= 0;
  }
  public static int adjSpot(int x, int y) {
    return x*z+y;
  }
}
