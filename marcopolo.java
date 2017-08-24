//Dr. JJ Shepherd
from java.util import Random;
public class MarcoPolo {

  public static final int BOARD_SIZE = 10; //Board Size

  //Enumerations
  enum Spaces {
    Empty,
    Player,
    Goal,
    Walked_Path
  };

  public static void main(String[] args) {

    int numberOfMoves = 0; //Counter
    int pX = 0; //Positon Horizontal
    int pY = 0; //Position Vertical
    Random r = new Random();

    //Get random variable for goals
    int gX = r.nextInt(BOARD_SIZE);
    int gY = r.nextInt(BOARD_SIZE);

    Scanner keyboard = new Scanner(System.in); //Get input

    Spaces[][] board  = new Spaces[BOARD_SIZE][BOARD_SIZE]; //Board

    //Set board to Empty
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[i].length, j++) {
        board[i][j] = Spaces.Empty;
      }
    }
    //Welcome user
    System.out.println("Hey you\nHow goes it?\nLet's play the Marco Polos.");

    boolean gameOver = false;

    while(not gameOver) {
      //Draw the board
      //Double for loop for multidimensional array
      for(int i = 0; i < board.length; i++) {
        for(int j = 0; j < board[i].length; j++) {
          //Switch case for iterating and displaying board.
          switch(board[i][j]) {
            case Empty:
              System.out.print("_");
              break;
            case Player:
              System.out.print("X");
              break;
            case Goal:
              System.out.print("_");
              break;
            case Walked_Path:
              System.out.print("#");
              break;
            default:
              System.out.print("?");
          }
        }
        //To make rows(Not sure if this was in class.)
        System.out.println("");
      }

      int test = keyboard.nextInt();
    }//Game loop


  }
}
