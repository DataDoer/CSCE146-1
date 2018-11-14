//Justin Baum
//00426510


import java.util.*;
import java.io.*;


public class RevPol {
  private static final String[] operators = {
      "+",
      "-",
      "*",
      "/"
    };

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Welcome to the reverse Polish Calculator!\nEnter in the name of the file: ");
    String filename = keyboard.nextLine();
    try {
      File file = new File(filename);
      Scanner fileScanner = new Scanner(file);
      while(fileScanner.hasNextLine()) {
        StackInterface stack = new LinkedListStack<Integer>();
        String line = fileScanner.nextLine();
        perLine(line);
      }//while
    } catch (Exception e) {
      System.out.println(e);
    }//try-catch
  }//main

  private static void perLine(String line) {
    StackInterface stack = new LinkedListStack<Integer>();
    String[] lineSplit = line.split(" ");
    for(int i = 0; i < lineSplit.length; i++) {
      //Check if operator
      boolean operate = false;
      for(int j = 0; j < operators.length; j++) {
        if(lineSplit[i].equals(operators[j])) {
          operate = true;
          try {
            int b = (int)stack.pop();
            int a = (int)stack.pop();
            switch (j) {
              case 0:
                stack.push(a+b);
                break;
              case 1:
                stack.push(a-b);
                break;
              case 2:
                stack.push(a*b);
                break;
              case 3:
                if(b == 0) {
                  System.out.println("Can't divide by zero!");
                  break;
                }
                stack.push(a/b);
                break;
              default:
                System.out.println("Something went wrong!");
                break;
              }//switch
          } catch(Exception intraise) {
            System.out.println("Ill formatted expression.");
          }//try catch
        }//if
      }//for
      if(!operate){
          try {
            stack.push((int)Integer.parseInt(lineSplit[i]));
          } catch (Exception ayo) {
            System.out.println("Well that wasn't an integer or an operator.");
          }//try-catch
        }//if we didn't operate
    }//for
    System.out.println("Calculating "+line);
    int answer = (int)stack.pop();
    if(stack.peek() == null) System.out.println("Result is " + answer);
    else System.out.println("Ill formatted expression");
  }//perLine
}//RevPol
