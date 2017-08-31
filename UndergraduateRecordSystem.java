import java.io.*;
import java.util.Scanner;

public class UndergraduateRecordSystem {
  public static final String DELIM = "\t"; //Delimiter

  //Record ugrads as file from array of objects
  public static void recordToFile(Ugrad[] uGrads, String fileName, boolean append) {
    if(uGrads == null || fileName == null) {
      return;
    }
    try {//If failure, goes to catch
      PrintWriter fileWriter =
                  new PrintWriter(new FileOutputStream(fileName, append));
      //Print header Data
      //This line is a problem, if append is true, then we're just adding new data, and we would just need to add new uGrads, and fix the header
      fielWriter.println("Number of students" + DELIM + uGrads.length);
      //Print body data
      for(int i = 0; i < uGrads.length; i++) { //cycle through uGrads
        fileWriter.println( uGrads[i].getName() + DELIM +
                            uGrads[i].getID() + DELIM +
                            uGrads[i].getLevel());//write into file
      }//for
      fileWriter.close()
    } catch (Exception e) {//Catch all
      System.out.println(e);//Let user know
    }//catch
  }//recordToFile

  //Return ugrads as array of objects from file
  public static Ugrad[] readFromFile(String fileName) {
    //TODO
    return null;
  }//readFromFile

  //Main loop
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    boolean quit = false;
    System.out.println("Welcome to the Undergraduate Record System");
    int input;
    while(quit == false) {
      System.out.println( "Enter 1 to create a new record\n" +
                          "Enter 2 to read from a file\n"+
                          "Enter 0 to quit.");
      input = keyboard.nextInt();
    }//while
  }//main
}//UndergraduateRecordSystem




//File format for our system
//Use tab to delimit (\t)
//Use new line for new data (\n)

/*
//Header Data
[Number of Students \t <<# of students>>]\n
[<<name>>\t<<ID>>\t<<level>>\n]
*/
