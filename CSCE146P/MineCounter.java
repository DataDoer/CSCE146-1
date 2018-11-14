import java.util.Random;
//Justin Baum
//00426510

public class MineCounter {
  public static final int BOARD_SIZE = 10;
  public static final int MINE = -1;
  public static final int BLANK = -2;
  public static void main(String[] args) {
    Random numberGen = new Random();
    int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    //Generate Board and Print
    System.out.println("Generating Empty Board.");
    boardGen(board);
    printBoard(board);
    System.out.println("Filling Board With Mines.");
    //Fill Board with mines
    fillBoard(board);
    printBoard(board);
    System.out.println("Filling Board with Neighbor counts.");
    //Fill Board with neighbor counts
    fillBoardNeighbors(board);
    printBoard(board);
  }//main


  public static void printBoard(int[][] board) {
    for(int i = 0; i < BOARD_SIZE; i++) {
      for(int j = 0; j < BOARD_SIZE; j++) {
        System.out.print((board[i][j] == MINE) ? "*" : (board[i][j] == BLANK) ? "-" : board[i][j]); //So the board before it is fully generated does the dash instead of the zero I had originally.
      }//j loop
      System.out.println("");
    }//i loop
  }//printboard

  public static void boardGen(int[][] board) {
    //Generate board
    boolean currentSpot;
    int counter = 0;
    for(int i = 0; i < BOARD_SIZE; i++) {
      for(int j = 0; j < BOARD_SIZE; j++) {
        board[i][j] = BLANK;
      }//j loop
    }//i loop
  }//boardGen

  public static void fillBoard(int[][] board) {
    int rI, rJ;
    Random rand = new Random();
    while (countBoard(board) < 10) {
      rI = rand.nextInt(BOARD_SIZE);
      rJ = rand.nextInt(BOARD_SIZE);
      board[rI][rJ] = MINE;
    }//while loop
  }//fillBoard

  public static void fillBoardNeighbors(int[][] board) {
    for(int i = 0; i < BOARD_SIZE; i++) {
      for(int j = 0; j < BOARD_SIZE; j++) {
        board[i][j] = (board[i][j] == MINE) ? board[i][j] : neighbors(board,i,j);
      }//j loop
    }//i loop
  }//filleBoardNeighbors

  public static int countBoard(int[][] board) {
    int count = 0;
    for(int i = 0; i < BOARD_SIZE; i++) {
      for(int j = 0; j < BOARD_SIZE; j++) {
        count += (board[i][j] == MINE) ? 1 : 0;
      }//j loop
    }//i loop
    return count;
  }//countBoard

  public static int neighbors(int[][] board, int I, int J) {
    int count = 0;
    for(int i = -1; i <= 1; i++) {//Go through neighbors
      for(int j = -1; j <= 1; j++) {
        if(!(I+i > BOARD_SIZE-1 || I+i < 0 || J+j > BOARD_SIZE-1 || J+j < 0)) {//Check if out of bounds
          count += (board[I+i][J+j] == -1) ? ((i == 0 && j == 0) ? 0 : 1) : 0;//Count only if board is a mine and not the same
        }
      }//j loop
    }//i loop
    return count;
  }//neighbors


}//MineCounter
