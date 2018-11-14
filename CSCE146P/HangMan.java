import java.util.Scanner;
//Justin Baum
//00426510

public class HangMan {
  public static void main(String[] args) {
    //Some stuff
    HangManBack MrHangMan;
    Scanner reader;
    reader = new Scanner(System.in);
    char guess;
    String again = "yes";//User input for Again

    //Main Game Loop
    while(again.toLowerCase().contains("yes")) {
      MrHangMan = new HangManBack();
      while(! MrHangMan.gameOver()) {//while the game isn't over
        MrHangMan.debug();//display board etc
        System.out.print("Enter a letter\n");//ask user for letter
        guess = reader.next().toLowerCase().charAt(0);//get letter
        MrHangMan.makeGuess(guess);//make that guess
      }//single game loop
      System.out.println((MrHangMan.isWinner()) ? "Congrats! You won!" : "Sorry, you lost.");//let user know whats up
      System.out.println("The word was " + MrHangMan.getWord() +".");
      System.out.println("Play again? yes/no");//ask again?
      again = reader.next();//get input
    }//play again game loop
  }//main
}//HangMan
