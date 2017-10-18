import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] array = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = reader.nextInt();
        }
        int high = 1000000;
        int low = 0;
        boolean buy = true;
        int counter1 = 10;
        for(int i = 0; i < n; i++) {
            counter1 = i;
            if(buy) {
                while(counter1 + 1 < n && array[counter1] >= array[counter1+1]) {
                    counter1++;
                }
                if(counter1 + 1 == n) {
                }else {
                    System.out.println(counter1 + " BUY");
                    buy = false;
                }
                i = counter1;
            } else {
                while(i + 1 < n && array[i] <= array[i+1]) {
                    i++;
                }
                if(i + 1 == n) {

                } else {
                    System.out.println(i + " SELL");
                }
                buy = true;
            }

        }
    }
}

/*
Ash is getting ready to invest in the booming Pokéball industry so that he can make money to buy a revive for his Pikachu, who has been in a coma for months. The prices of Pokéballs fluctuate greatly from day to day. Ash wants to invest, so he has been keeping track of the price of Pokéballs for the past  days (all while poor Pikachu has been plugged into the wall to survive). To determine an investing strategy for the future, Ash has decided to figure out what he should have done in the past. Ash is a millennial, so he has decided that every time he is going to invest in the Pokéball market he will invest 100% of his capital, and every time he sells off his Pokéballs he will sell all of them.

Fortunately for Ash, the price of Pokéballs stays constant on a given day. Ash can only make one trade a day.

Given the prices of Pokéballs for the past  days, print out the index of the day in Ash's list and BUY on the days that Ash should have bought Pokéballs, and print out the index of the day in Ash's list and SELL on the days that Ash should have sold his Pokéballs. Your output should have alternating BUY and SELLS, since Ash spends all his money each time he buys and dumps all his Pokéballs each time he sells.

Ash also loves procrastinating (Pikachu can stay under just a little longer right?) and will wait as long as possible before making any investment decisions. If Ash can sell on consecutive days for the same total profit, he will wait until the last day before selling. Similarly, if Ash can buy for the same price on multiple consecutive days, he will wait until the last day possible before buying.

Input Format

The first line contains a single number , which is the number of days that Ash has recorded the Pokéball prices. The next  lines contain a single positive integer  which is the price of Pokéballs on that day.

Constraints



Output Format

Each line should contain the index of the day in Ash's list that Ash is buying or selling on, and then the word BUY if Ash should buy or SELL if Ash should sell. Keep in mind that your output not end on a SELL. There is an example demonstrating this.

Sample Input 0

5
1
2
3
4
5
Sample Output 0

0 BUY
Explanation 0

Ash should buy on day 1 because the price of Pokéballs is cheap. The price keeps going up and up, so Ash neves sells his Pokéballs. We cannot say whether Ash should buy or sell on the last day (because we do not know tomorrows prices) so we do not output anything for the last day.

Sample Input 1

10
9
10
9
5
8
6
6
2
4
9
Sample Output 1

0 BUY
1 SELL
3 BUY
4 SELL
7 BUY
Explanation 1

image

Ash hand drew this graph to better understand the market. He wants to buy on day 0 because he can sell on day 1 to make a profit. However, if he bought on day 2 then he would start losing money, so he holds on to his money until day 3 where he buys. On day 4 he can sell his Pokéballs for a profit, and doesn't buy again until Pokéballs drop down to 2. Similar to the first example, Ash doesn't know if he should sell or not on day 10, so we output nothing.

Sample Input 2

10
3
8
10
3
5
9
8
2
8
7
Sample Output 2

0 BUY
2 SELL
3 BUY
5 SELL
7 BUY
8 SELL
Explanation 2

image

Ash hand drew another graph to better understand the market (wow this Ash character is a real nice guy!) Since Pokéballs start cheap, he buys on Day 0 and doesn't sell until they peak on day 2. A sudden drop makes Ash buy again, and he holds onto them until day 5 where he sells them back for 9 a piece. He waits until day 7 to buy for cheap, and then sells on day 8 for a nice profit. On day 10, the Pokéball price is at 7. Ash isnt sure if the price will continue to rise or fall, so he can't make a good decision thus we output nothing. (In general, we can never make a decision on the last day, so nothing should eves be output with the last index.)

*/
