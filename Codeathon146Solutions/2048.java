import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner writer = new Scanner(System.in);
        int moves = writer.nextInt();
        String move = writer.nextLine();
        int rows = writer.nextInt();
        int columns = writer.nextInt();
        int[][] matrix = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                matrix[i][j] = writer.nextInt();
            }

        }
        int[][] newmatrix;
        int[][] newnewmatrix;

        switch(move) {
            case " R":
                newmatrix = rotate(rotate(matrix));
                for(; moves > 0; moves--){
                    L(newmatrix);
                }
                newnewmatrix = rotate(rotate(newmatrix));
                break;
            case " L":
                newmatrix = matrix;
                for(; moves > 0; moves--){
                    L(newmatrix);
                }
                newnewmatrix = newmatrix;
                break;
            case " D":
                newmatrix = rotate(rotate(rotate((matrix))));
                for(; moves > 0; moves--){
                    L(newmatrix);
                }
                newnewmatrix = rotate(newmatrix);
                break;
            case " U":
                newmatrix = rotate(matrix);
                for(; moves > 0; moves--){
                    L(newmatrix);
                }
                newnewmatrix = rotate(rotate(rotate(newmatrix)));
                break;
            default:
                newnewmatrix = rotate(rotate(rotate(rotate(matrix))));
                break;
        }
        print(newnewmatrix);

    }//main

    public static int[][] rotate(int[][] matrix){//rotates board, I'm lazy and frankly I was writing separate algorithms for each way, and would always get something wrong
        int[][] newmatrix = new int[matrix[0].length][matrix.length];
        for(int i = 0; i < matrix.length;i++) {
            for(int j = 0; j < matrix[0].length;j++) {
                newmatrix[matrix[0].length-j-1][i] = matrix[i][j];
            }
        }
        return newmatrix;
    }

    public static void print(int[][] matrix) {
        for(int i = 0; i < matrix.length;i++) {
            for(int j = 0; j < matrix[0].length;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printrow(int[] row) {
        for(int i = 0; i < row.length; i++) {
            System.out.print(row[i] + " ");
        }
        System.out.println();
    }

    public static void L(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            L1(matrix[i]);
        }

    }

    public static void L1(int[] row) {
        L2(row);
        L3(row);
    }

    public static void L2(int[] row) {//Moves everything down;
        int counter;
        for(int i = 1; i < row.length; i++) {
            counter = i;
            while(counter > 0 && row[counter-1] == 0) {
                counter--;
            }
            if(counter != i) {
                row[counter] = row[i];
                row[i] = 0;
            }
        }
    }

    public static void L3(int[] row) {//Moves everything into eachother
        for(int i = 1; i < row.length; i++) {
            if(row[i-1] == row[i]) {
                row[i-1] += row[i];
                row[i] = 0;
                L2(row);//If something collides, we need to make sure no more space again
            }
        }
    }

}//Solution


/*
Given a board of numbers similar to the game 2048, e.g.:

0 2 4 2
2 2 4 4
2 2 0 4
0 0 8 2
give the output after a given number of moves in one direction, for instance 1 R (1 move to the right):

0 2 4 2
0 0 4 8
0 0 4 4
0 0 8 2
Or, 2 D (2 moves down):

0 0 0 0
0 0 0 2
0 2 0 8
4 4 16 2
The rules for a move are as follows:

Tiles slide as far as possible in the chosen direction until they are stopped by either another tile or the edge of the grid. If two tiles of the same number collide while moving, they will merge into a tile with the total value of the two tiles that collided. The resulting tile cannot merge with another tile again in the same move

If you've never played 2048, or just need to brush up on how it works, you can find it here:

http://gabrielecirulli.github.io/2048/

Just don't spend too much time playing and forget to code!

Input Format









There will be three lines of informational input:

, the type of move to make (e.g. '', '', '')
, the number of rows on the board
, the number of columns on the board
And  lines of board information in the format:

X X X ... X
X X X ... X
  .
  .
  .
X X X ... X
Where X can be any number  (of the form )

Constraints

 will consist of a number  and a character  seperated by a space which represent moves in a direction

 and  have these constraints:



   (L corresponds to Left, R to Right, U to up, D to Down)

The number of rows and columns will be limited to:





Output Format

Print  lines consisting of  space seperated numbers, corresponding to the board state after .

For example, if  and , your output might look something like:

0 0 0 0 0 2 4
0 0 0 0 0 0 2
0 0 0 0 0 0 8
0 0 0 2 4 16 2048
Sample Input 0

2 R
6
8
2 2 2 2 2 2 2 2
0 2 0 2 4 2 2 4
0 0 0 0 0 0 0 16
0 0 4 4 0 0 8 16
2 2 2 2 2 2 2 4
0 2 0 2 0 2 0 2
Sample Output 0

0 0 0 0 0 0 8 8
0 0 0 0 0 0 8 8
0 0 0 0 0 0 0 16
0 0 0 0 0 0 16 16
0 0 0 0 0 2 8 8
0 0 0 0 0 0 0 8

*/
