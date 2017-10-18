import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner writer = new Scanner(System.in);
        int a = writer.nextInt();
        int b = writer.nextInt();
        System.out.println(Math.abs(a-b));
    }
}


/*
Mercy needs help figuring how how to heal her team mates that are in a line. If Mercy is at position  on the line and one of her team mates is at position  in the line how far away is Mercy from her team mate?

Input Format



Constraints



Output Format

One line containing a positive number corresponding to how far away Mercy is from her teammate.

Sample Input 0

3 5
Sample Output 0

2
Sample Input 1

6 1
Sample Output 1

5
*/
