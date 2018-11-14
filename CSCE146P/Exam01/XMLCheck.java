//Justin Baum
//00426510

import java.util.*;
import java.io.*;

public class XMLCheck {
  public static void main(String[] args) {
    System.out.println("Welcome to the simple XML tester. Time to test simple XML's");
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter a filename: ");
    String filename = keyboard.nextLine();
    File file = new File(filename);
    LinkedListStack<String> stack = new LinkedListStack<String>();
    boolean format = false;
    String errors = "";
    int linecounter = 0;
    LinkedListStack<String> tags = new LinkedListStack<String>();
    try {
      Scanner fileScanner = new Scanner(file);
      while(fileScanner.hasNextLine()) {
        linecounter++;
        String line = fileScanner.nextLine();
        switch(lineReader(line)) {
          case 0:
            /*if(stack.peek() == null) {//If nothing on stack
              format = true;
              errors += "Value found outside tags on line:"+ linecounter+"\n";
            }*/
            //Realized values outside tags is fine
            break;
          case 1:
            if(lineReaderGet(line) == null) {
              format = true;
              errors += "Likely you forgot a '>' on line: "+linecounter+"\n";
            } else {
              stack.push(lineReaderGet(line));
            }
            break;
          case 2:
            if(lineReaderGet(line) == null) {
              format = true;
              errors += "Likely you forgot a '>' on line: "+linecounter+"\n";
            } else {
              if(stack.peek().equals(lineReaderGet(line))) {
                stack.pop();//Looks like everythings good
              } else {
                format = true;
                errors += "The error for tag " + stack.peek()+" occurs on line: "+linecounter+"\n";
                tags.push(stack.peek());//Get tag with missing close
              }
            }
            break;
          default:
            System.out.println("Unplanned Error");
        }
      }//while

      while(stack.peek() != null) {
        //Stack is not empty;
        format = true;
        tags.push(stack.pop());
      }

      System.out.println(((!format)?"This XML File was formatted correctly" : "This XML file is not formatted correctly"));
      System.out.print(errors);
      while(tags.peek() != null) {
        System.out.println("The tag " + tags.pop() +" seems incorrectly formatted.");
      }
    } catch (Exception e) {
      System.out.println("Likely a bad file name, try again!");
    }//try-catch

  }//main

  public static int lineReader(String line) {//0 --> bad format; 1 --> push to stack; 2 --> pop from stack
    if(line.length() < 2) return 0;
    while(line.charAt(0) == '	' || line.charAt(0) == '\t' || line.charAt(0) == ' ') {
      if(line.length() < 2) return 0;
      line = line.substring(1,line.length());
    }
    if(line.charAt(0) == '<') {
      if(line.charAt(1) == '/') return 2;
      return 1;
    }//if
    return 0;
  }//lineReader

  public static String lineReaderGet(String line) {//return null if no closed bracket
    String newLine = "";
    while(line.charAt(0) == '	' || line.charAt(0) == '\t' || line.charAt(0) == ' ') {
      if(line.length() < 2) return null;
      line = line.substring(1,line.length());
    }
    for(int i = 1; i < line.length(); i++) {

      if(line.charAt(i) == '>') {
        return newLine;
      }
      if(line.charAt(i) != '/') newLine += line.substring(i,i+1);
    }
    return null;
  }
}//XMLCheck
