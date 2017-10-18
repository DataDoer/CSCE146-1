import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        int blues = 0;
        Scanner lineRead = new Scanner(System.in);
        int n = Integer.valueOf(lineRead.nextLine());
        String[] colors = lineRead.nextLine().split(" ");
        for(int i = 0; i < n; i++) {
            if(colors[i].equals("blue")) blues++;
        }

        System.out.println(blues);
    }
}
