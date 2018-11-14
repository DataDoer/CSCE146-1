//Justin Baum
//00426510

//I use this to make the searchspace less

//javac dictionarydrop.java && cat dictionary.txt | java dictionarydrop > newdictionary.txt

import java.util.*;

public class dictionarydrop {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    String line;
    while(keyboard.hasNextLine()) {
      line = keyboard.nextLine();
      line = line.toUpperCase();
      if(line.length() < 6 && line.length() > 1) {
        System.out.println(line);
      }
    }

  }
}
