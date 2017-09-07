import java.util.*;
import java.io.*;
public class File {
  //Read a file using a scanner
  public static void afileRead(String[] args) {
    File file = new File("./turtles.txt");
    Scanner inputStream = new Scanner(file);//Find the file turtles.txt in current directory
    int tutyleAmt = inputStream.nextInt(); //Get the next int
    inputStream.closer();//Close the file; MUST BE CLOSED AT END
    /*!!!
    **Everything must be in a try-catch block
    **!!!*/
  }

  //Write to a file works like System out
  public static void afileWrite(String[] args) {
    PrintWriter outputStream =  PrintWriter(new FileOutputStream(fileName, true));//Make a new object to write to file
    outputStream.println("Hey");//write hey
    outputStream.close();//Always close the file
  }


}
