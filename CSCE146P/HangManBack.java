import java.util.Random;
import java.util.ArrayList;
//Justin Baum
//00426510

public class HangManBack {
  private final String[] library = {//library of words
    "hydrogen",
    "helium",
    "lithium",
    "beryllium",
    "boron",
    "carbon",
    "nitrogen",
    "oxygen",
    "fluorine",
    "neon",
    "sodium",
    "magnesium",
    "aluminum",
    "silicon",
    "phosphorous",
    "sulfur",
    "chlorine",
    "argon",
    "potassium",
    "calcium",
    "scandium",
    "titanium",
    "vanadium",
    "chromium",
    "managanese",
    "iron",
    "cobalt",
    "nickle",
    "copper",
    "zinc",
  };

  private final String[] HangMan = {//Have Hang dudes conveniently
    "_______\n|   |\n|\n|\n|\n|\n|\n",
    "_______\n|   |\n|   O\n|\n|\n|\n|\n",
    "_______\n|   |\n|   O\n|   |\n|   |\n|\n|\n",
    "_______\n|   |\n|   O\n|  \\|\n|   |\n|\n|\n",
    "_______\n|   |\n|   O\n|  \\|/\n|   |\n|\n|\n",
    "_______\n|   |\n|   O\n|  \\|/\n|   |\n|  /\n|\n",
    "_______\n|   |\n|   O\n|  \\|/\n|   |\n|  / \\\n|\n",

  };

  //variables
  private final int totalGuesses = HangMan.length;
  private ArrayList<Character> guessedLetters = new ArrayList<Character>();
  private int guesses = 0;
  private int incorrect = 0;
  private String word;
  private boolean winner = false;
  public HangManBack() {
    Random rand = new Random();
    //First choose word
    this.word = library[rand.nextInt(this.library.length)];
  }//HangManBack

  public String getWord() {
    return this.word;
  }//getWord

  public boolean gameOver() {
    if (this.incorrect >= this.totalGuesses) {
      this.winner = false;
      return true;
    }
    boolean winner = true;
    for(int i = 0; i < this.word.length(); i++) {
      winner &= guessedLetters.contains(this.word.charAt(i));
    }//for
    if(winner) this.winner = winner;
    return winner;
  }//gameOver

  public boolean isWinner() {
    return this.winner;
  }

  public void makeGuess(char letter) {
    //Return true if successful, false if it was already made
    if(!this.guessedLetters.contains(letter)) {//Check to see if guessed
      this.guessedLetters.add(letter);
      this.guesses++;
      if(this.word.indexOf(letter) != -1) {
      } else {//if letter is right
        this.incorrect++;
      }
    }//if guessed not repeated
  }//makeGuess

  private void printHangMan() {
    System.out.print(HangMan[(this.incorrect >= this.HangMan.length) ? this.HangMan.length-1 : this.incorrect]);
  }//printHangMan

  private void printWord() {
    for(int i = 0; i < this.word.length(); i++) {//for each letter in word
      System.out.print((this.guessedLetters.contains(this.word.charAt(i))) ? this.word.charAt(i) : "?");
    }//for
  }//printWord

  public void debug() {
    System.out.print("You have made " + this.guesses + " guesses.\n");
    this.printWord();
    System.out.print("\n");
    this.printHangMan();

  }//debug

}//HangManBack
