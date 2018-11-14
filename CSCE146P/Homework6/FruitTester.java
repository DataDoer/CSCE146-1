//Justin Baum
//00426510

import java.util.*;
import java.io.*;

public class FruitTester {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter a filename: ");
    String fileName = "./"+keyboard.nextLine();
    String fileLine;
    BSTreeLL<Fruit> tree = new BSTreeLL<Fruit>();
    Fruit rotten = null;
    int counter = 0;
    int modcounter = 11;//Laziest way to do it
    try { //Try ask user for filename and read file
      File file = new File(fileName);//File
      Scanner fileScanner = new Scanner(file);//Find the file and load into scanner
      while(fileScanner.hasNext()) {
        Fruit fruit = new Fruit(fileScanner.next(),fileScanner.nextDouble());
        if(counter % modcounter == 2) rotten = fruit;
        tree.insert(fruit);
        counter++;
      }//while
      //close scanner
      fileScanner.close();

      //Print in order
      System.out.println("\nIn Order Tree:");
      tree.printInOrder();
      //Print pre order
      System.out.println("\nPre Order Tree:");
      tree.printPreOrder();
      //Print post order
      System.out.println("\nPost Order Tree:");
      tree.printPostOrder();
      //delete
      if(rotten != null) {
        System.out.println("\nDeleting: "+rotten);
        tree.delete(rotten);
      }
      //Print in order
      System.out.println("\nIn Order Tree:");
      tree.printInOrder();
      //Print pre order
      System.out.println("\nPre Order Tree:");
      tree.printPreOrder();
      //Print post order
      System.out.println("\nPost Order Tree:");
      tree.printPostOrder();


    } catch (Exception e) { //Filename does not exist
      System.out.println(e);
    }//try-catch



  }//main
}
