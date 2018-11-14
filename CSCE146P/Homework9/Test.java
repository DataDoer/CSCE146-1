import java.util.*;
import java.io.*;

public class Test {
  public static void main(String[] args) throws FileNotFoundException {
    Graph5x5 kindaGraph = new Graph5x5();
    String letters = "RAHJMYUWWKRXNFMQGEEBEOAPE";
    int i = 0;
    for(char letter : letters.toCharArray()) {
      kindaGraph.addLetter(i,letter);
      i++;
    }
    kindaGraph.printCycles();
    String filename = "newdictionary.txt";
    File file = new File(filename);
    Scanner fileinput = new Scanner(file);
    String line = "";
    while(fileinput.hasNextLine()) {
      line = fileinput.nextLine();
      kindaGraph.addDictionary(line);
    }

    for(String word : kindaGraph.wordsfound){
      if(kindaGraph.dictionary.contains(word)) System.out.println(word);
    }
  }
}
