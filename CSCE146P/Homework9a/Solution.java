//Justin Baum
//00426510


import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) throws FileNotFoundException {
    Graph5x5 kindaGraph = new Graph5x5();
    Scanner keyboard = new Scanner(System.in);
    String letters = "";

    while(letters.length() < 25) {
      letters += keyboard.nextLine().toUpperCase();
      letters = letters.replaceAll("\\s","");
    }
    int i = 0;
    for(char letter : letters.toCharArray()) {
      kindaGraph.addLetter(i,letter);
      i++;
    }
    String filename = "newdictionary.txt";
    File file = new File(filename);
    Scanner fileinput = new Scanner(file);
    String line = "";
    while(fileinput.hasNextLine()) {
      line = fileinput.nextLine();
      kindaGraph.addDictionary(line);
    }
    kindaGraph.generateWords();

    for(String word : kindaGraph.wordsfound){
      if(kindaGraph.dictionary.contains(word)) System.out.println(word);
    }
  }
}
