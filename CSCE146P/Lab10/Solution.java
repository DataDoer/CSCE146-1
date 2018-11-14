//Justin Baum
//00426510
import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    String message = "Enter:\n1.    To add a fear\n2.    To remove a fear\n3.    To look up a fear\n4.    Print all fears\n5.    Quit";
    int option = 0;
    Scanner keyboard = new Scanner(System.in);
    String a = "";
    String b = "";
    PhobiaHashTable phobias = new PhobiaHashTable();
    while(option != 5) {
      System.out.println(message);
      option = keyboard.nextInt();
      keyboard.nextLine();
      switch(option) {
        case 1:
          System.out.println("What is the fear’s name");
          a = keyboard.nextLine();
          System.out.println("Describe the fear");
          b = keyboard.nextLine();
          phobias.add(a,b);
          break;
        case 2:
          System.out.println("What is the fear’s name");
          a = keyboard.nextLine();
          phobias.remove(a);
          break;
        case 3:
          System.out.println("What is the fear’s name");
          a = keyboard.nextLine();
          b = phobias.lookUp(a);
          if(!b.equals("")) System.out.println(a+"\n"+b);
          else System.out.println("Sorry didn't find a phobia named: "+a);
          break;
        case 4:
          phobias.printHashTable();
          break;
      }
      System.out.println("Goodbye Fears");
    }
  }
}
