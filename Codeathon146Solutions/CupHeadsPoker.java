import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner writer = new Scanner(System.in);
        int x = writer.nextInt();
        int z = writer.nextInt();
        int magic = 0;
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i = 0; i < x; i++) {
            int b = writer.nextInt();
            array.add(b);
            if(i == z) magic = b;
        }
        Collections.sort(array);
        int magicindex = array.indexOf(magic);
        array.remove(magicindex);
        array.add(z,magic);
        for(int i = 0; i < x; i++) {
            System.out.print(array.get(i) + " ");
        }
    }
}


/*
Cuphead has way too many bags of poker chips and needs help organizing them. Cuphead has  bags of poker chips, and each bag has some number of chips  inside. Right now his bags of chips are organized in a line, but he wants them to be organized by ascending order, with a catch. Cuphead has a bag of lucky chips at position  in the line. After organizing all his other chips, he wants to put the lucky chip bag back where it was originally, at position

Input Format





The first two lines of input contain:
- X the number of poker chip bags
- Z the position of the lucky chip bag in the line with 0 being the first bag in the list - Y_{1} Y_{2} .. Y_{X} the line of poker chip bags before organization.

Constraints

1    40000

0    39999

0    100

Output Format


Your output is one line with the poker chip bag values separated by spaces.

Sample Input 0

7
4
6 14 14 28 29 25 8
Sample Output 0

6 8 14 14 29 25 28
Sample Input 1

7
2
3 11 14 5 17 5 4
Sample Output 1

3 4 14 5 5 11 17

*/
