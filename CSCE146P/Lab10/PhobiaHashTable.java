//Justin Baum
//00426510

import java.util.*;
public class PhobiaHashTable {
  private class Phobia {
    private String phobia;
    private String def;
    public Phobia(String aWord, String aDef) {
      phobia = aWord;
      def = aDef;
    }//WordAndDef

    public boolean equals(Phobia aPhobia) {
      return phobia.equals(aPhobia.phobia);
    }
  }//WordAndDef

  private ArrayList<Phobia>[] table;
  private static final int CAP_A = 'A';
  public PhobiaHashTable() {
    table = new ArrayList[26];
    for(int i = 0; i < table.length; i++) {//Initialize array of arraylist
      table[i] = new ArrayList<Phobia>();
    }//for
  }//DictionaryHashTable

  private int calcIndex(String aWord) {
    return aWord.toUpperCase().charAt(0) - CAP_A;
  }//calcIndex

  public void add(String aWord, String aDef) {
    Phobia newWord = new Phobia(aWord, aDef);
    table[calcIndex(aWord)].add(newWord);
  }//add

  public String lookUp(String aWord) {
    int index = calcIndex(aWord);
    for(Phobia word : table[index]) {
      if(word.phobia.equals(aWord)) {
        return word.def;
      }//if
    }//for
    return "";
  }//lookUp

  public void remove(String aWord) {
    int index = calcIndex(aWord);
    for(Phobia word : table[index]) {
      if(word.phobia.equals(aWord)) {
        table[index].remove(word);
      }//if
    }//for
  }//lookUp

  public void printHashTable() {
    for(int i = 0; i < table.length; i++) {
      for(Phobia phobia : table[i]) {
        System.out.println(phobia.phobia);
        System.out.println(phobia.def+"\n");
      }
    }
  }
}//DictionaryHashTable
