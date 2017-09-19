import java.util.*;
import java.io.File;
import java.io.*;

public class TacoManagerG {
  private GenLinkedList<Taco> tacos;
  //The files are assumed to be tab delimited. Think of a tab as indicating
  //the next column of an excel doument
  public static final String DELIM = "\t";

  public TacoManagerG() {
    this.tacos = new GenLinkedList<Taco>();
  }//Manager default Constructor

  //Don't do this
  public TacoManagerG(GenLinkedList<Taco> tacos) {
    //You need to safeguard your code; never assume the correct values are going to be passed
    this.tacos = tacos;
  }//TacoManager Tacos param

  public void writeToFile(String fileName,boolean append) {
    if(fileName == null || tacos == null) {
      return;
    }//if
    try {
      PrintWriter fileWriter =  new PrintWriter(
                                new FileOutputStream(fileName));//Completely wipes the file clean
      tacos.resetCurrent();//Reset to start
      while(tacos.hasMore()) {//Iterate through
        Taco aTaco = tacos.getCurrent();//Get taco`
        fileWriter.println( aTaco.getName() + DELIM +//Print out tacos
                            aTaco.getMaker() + DELIM +
                            aTaco.getPrincE() + DELIM +
                            aTaco.getRating() + DELIM);
        tacos.goToNext();//Go to next
      }//While iterator
      fileWriter.close();
    } catch (Exception e) {//catch all exceptions
      System.out.println(e);
    }//try/catch
  }//writeToFile

  public void readTacoFile(String fileName) {
    if(fileName == null) return;
    tacos = new GenLinkedList<Taco>();
    try {
      Scanner fileScanner = new Scanner(new File(fileName));
      while(fileScanner.hasNextLine()) {
        String fileLine = fileScanner.nextLine();
        String[] splitStrings = fileLine.split(DELIM);
        if(splitStrings.length != 4) continue;
        String name = splitStrings[0];
        String maker = splitStrings[1];
        double price = Double.parseDouble(splitStrings[2]);
        int rating = Integer.parseInt(splitStrings[3]);
        Taco aTaco = new Taco(name,maker,price,rating);
        tacos.insert(aTaco);
      }
    }

  }//readTacoFile

  public void printTacoList() {
    writeToFile("taco.txt", false);
  }//printTacoList

  public void addTaco(Taco newTaco) {
    for(int i = 0; i < tacos.length; i++) {//Found a open spot
      if(tacos[i] == null) {
        tacos[i] = newTaco;//Add taco to the end of this array
      }//if
    }//for
  }//addTaco

  public void removeTaco(String removeTaco) {
    //remove taco
    tacos.resetCurrent();
    while(!tacos.getCurrent().equals(removeTaco) && tacos.hasMore()) {
      tacos.goToNext();
    }//while
  }//removeTaco

}//TacoManagerG


//TACO FILE
// NO header
/*
<<name>>\t<<maker>>\t<<price>>\t<<rating>>\n
*/
