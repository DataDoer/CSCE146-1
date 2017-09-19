import java.util.*;
import java.io.File;
import java.io.*;

public class TacoManager {
  private Taco[] tacos;
  public static final int DEFAULT_SIZE = 100;
  //The files are assumed to be tab delimited. Think of a tab as indicating
  //the next column of an excel doument
  public static final String DELIM = "\t";

  public TacoManager() {
    this.tacos = new GenLinkedList<Taco>();
  }//Manager default Constructor

  public TacoManager(int size) {
    if (size > 0) this.tacos = new Taco[size];
  }//TacoManager size param

  //Don't do this
  public TacoManager(Taco[] tacos) {
    //You need to safeguard your code; never assume the correct values are going to be passed
    this.tacos = tacos;
  }//TacoManager Tacos param

  public void writeToFile(String fileName) {
    if(fileName == null) {
      return;
    }//if
    try {
      PrintWriter fileWriter =  new PrintWriter(
                                new FileOutputStream(fileName));//Completely wipes the file clean
      for(Taco taco : tacos) { //for each loop
        if(taco == null) break; //reached the end
        fileWriter.println(taco.getName()+DELIM+taco.getMaker()+DELIM+taco.getPrice()+DELIM+taco.getRating());

      }//for each
      fileWriter.close();
    } catch (Exception e) {//catch all exceptions
      System.out.println(e);

    }//try/catch
  }//writeToFile

  public void readTacoFile(String fileName) {
    if(fileName == null) return;

    try {
      File file = new File(fileName);
      Scanner fileScanner = new Scanner(file);
      int arraySize = 0;

      //COUNT TACOS
      while(fileScanner.hasNextLine()) {
        fileScanner.nextLine();
        arraySize++;
      }//while
      if(arraySize <= 0){
        fileScanner.close();
        return;
      }//if

      tacos = new Taco[arraySize];

      //POPULATE TACOS
      fileScanner = new Scanner(new File(fileName));//reconstruct to reset
      currTacoIndex = 0;
      while(fileScanner.hasNextLine()) {
        String fileLine = fileScanner.nextLine();//Read the line
        String[] splitString = fileLine.split(DELIM);//Split the line
        if(splitString.length == 4) {//If the line is formatted correctly
          //Parse out info
          String name = spitString[0];
          String maker = splitString[1];
          double price = Dobule.parseDouble(splitString[2]);
          int rating = Integer.parseInt(splitString[3]);
          tacos[currTacoIndex] = new Taco(name,maker,price,rating); //add taco to list
          currTacoIndex++; //increase the index by one
        }//if
      }//while
      fileScanner.close();
    } catch(Exception e) {
      System.out.println(e);
    }//try-catch
  }//readTacoFile

  public void printTacoList() {
    //TODO
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
    for(int i = 0; i < tacos.length; i++) {
      if(tacos[i].getName().equals(removeTaco)) {//Found taco
        for(int j = i; j < tacos.length -1; j++) {//Shift tacos to the left
          tacos[j] = tacos[j+1];
        }//for
        tacos[tacos.length-1] = null;
      }//if
    }//for
  }//removeTaco

}//TacoManager


//TACO FILE
// NO header
/*
<<name>>\t<<maker>>\t<<price>>\t<<rating>>\n
*/
