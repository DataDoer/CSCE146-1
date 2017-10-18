import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner writer = new Scanner(System.in);
        int n = writer.nextInt();
        int x = writer.nextInt();
        writer.nextLine();
        ArrayList<BigInteger> words = new ArrayList<BigInteger>();
        ArrayList<BigInteger> counters = new ArrayList<BigInteger>();
        String word = "";
        int index;
        BigInteger value;
        BigInteger counter = BigInteger.valueOf(0);
        BigInteger one =  BigInteger.valueOf(1);

        for(int i = 0; i < n; i++) {//O(n)
            value = BigInteger.valueOf(0);
            word = writer.nextLine();
            index = word.length()-x;
            for(int j = index; j < word.length(); j++) {
                value = value.add(BigInteger.valueOf(word.codePointAt(j)*(7*(j-index+2))));
            }
            index = words.indexOf(value);
            if(index == -1) {
                words.add(value);
                counters.add(one);
            } else {
                value = counters.get(index);
                counter = counter.add(value);
                value = value.add(BigInteger.valueOf(1));
                counters.set(index,value);
            }

        }

        System.out.println(counter);
    }

}

/*
For this problem you are given a list of words of size . Your task is to find all the rhyming pairs (order doesn’t matter) in the list and output the total number of pairs found. For this particular problem, we will slightly alter the definition of a rhyme. Two words rhyme if the last  letters, that we define, in the word match.

For example, given the list of words: slime, time, lime, meme, and we define  as 3. Slime rhymes with time, slime rhymes with lime, and time rhymes with lime. But nothing rhymes with meme.

Input Format

The first two lines of input are as followed:
 words that appear in the list
 the number of letters at the end of a word that qualify a rhyme.

The following lines contain a list of N words in the format:




Constraints

1  N  6000
1  X  6000

Output Format

One line containing the number of rhyming pairs in the list.

Sample Input 0

4
3
slime
time
lime
meme
Sample Output 0

3
Explanation 0

There are four words in the list. We want to find the pairs of words that "rhyme" if their last 3 letters are the same. Then we have our list of four words.

We output 3 because there are three pairs of words that "rhyme" with each other.

*/
