import java.io.*;
import java.util.Scanner;

public class MovieDatabaseFrontEnd {
  private static final String prompt = "Enter 1: To Add a Movie\n"+
                  "Enter 2: To Remove a Movie by its Title\n"+
                  "Enter 3: To search for a Title\n"+
                  "Enter 4: To search for moves by a Director\n"+
                  "Enter 5: To search for movies of a given Year\n"+
                  "Enter 6: To search for movies of a certain Rating\n"+
                  "Enter 7: To print out all movies\n"+
                  "Enter 8: To print to a database file\n"+
                  "Enter 9: To load a database file\n"+
                  "Enter 0: To quit";
  public static void main(String[] args) {

    MovieDatabase Movies = new MovieDatabase();
    Scanner keyboard = new Scanner(System.in);
    System.out.println(prompt);
    int answer = keyboard.nextInt();
    while(answer != 0) {
      switch(answer) {
        case 0: break;
        case 1: add(keyboard, Movies);
                break;
        case 2: remove(keyboard, Movies);
                break;
        case 3: searchTitle(keyboard, Movies);
                break;
        case 4: searchDirector(keyboard, Movies);
                break;
        case 5: searchYear(keyboard, Movies);
                break;
        case 6: searchRating(keyboard, Movies);
                break;
        case 7: printAll(keyboard, Movies);
                break;
        case 8: toFile(keyboard, Movies);
                break;
        case 9: fromFile(keyboard, Movies);
                break;
        default: System.out.println("Error.");
                break;
      }//switch
      System.out.println(prompt);
      answer = keyboard.nextInt();
    }//while
  }//main

  private static void add(Scanner keyboard, MovieDatabase Movies) {
    System.out.print("Please enter a name for the movie: ");
    keyboard.nextLine();
    String name = keyboard.nextLine();
    System.out.print("Please enter a year for "+name+": ");
    int year = keyboard.nextInt();
    System.out.print("Please enter a rating for "+name+": ");
    int rating = keyboard.nextInt();
    System.out.print("Please enter a director for "+name+": ");
    keyboard.nextLine();
    String director = keyboard.nextLine();
    System.out.print("Please enter the box office for "+name+": ");
    double gross = keyboard.nextDouble();
    Movie newMovie = new Movie(name, year, rating, director, gross);
    Movies.addMovie(newMovie);
    System.out.println("You have successfully added the following movie.");
    System.out.println(newMovie);
  }//add

  private static void remove(Scanner keyboard, MovieDatabase Movies) {
    System.out.print("Please enter a name for the movie: ");
    keyboard.nextLine();
    String rMovie = keyboard.nextLine();
    Movie rMovie2 = new Movie();
    rMovie2.setName("Error.");
    try {
      rMovie2 = Movies.searchSingle(rMovie);
      Movies.removeMovie(rMovie);
    } catch (Exception e) {
      //I'm very tired
    }
    System.out.println("You have deleted the following movie.");
    System.out.println(rMovie2);

  }//remove

  private static void printAll(Scanner keyboard, MovieDatabase Movies) {
    Movies.printAllMovies();
  }//printAllMovies

  private static void searchTitle(Scanner keyboard, MovieDatabase Movies) {
    System.out.print("Please enter a movie to search for: ");
    keyboard.nextLine();
    Movie movie = Movies.searchSingle(keyboard.nextLine());
    if(movie != null) System.out.println(movie);
  }//searchTitle

  private static void search(Scanner keyboard, MovieDatabase Movies, Movie aMovie, int c) {
    MovieDatabase results = Movies.search(aMovie,c);
    results.printAllMovies();
  }//search general

  private static void searchDirector(Scanner keyboard, MovieDatabase Movies) {
    System.out.print("Please enter a director to search for: ");
    keyboard.nextLine();
    String director = keyboard.nextLine();
    Movie aMovie = new Movie();
    aMovie.setDirector(director);
    System.out.println("Results: ");
    search(keyboard, Movies, aMovie, 8);
  }//searchDirector

  private static void searchYear(Scanner keyboard, MovieDatabase Movies) {
    System.out.print("Please enter a year to search for: ");
    keyboard.nextLine();
    int year = keyboard.nextInt();
    Movie aMovie = new Movie();
    aMovie.setYear(year);
    System.out.println("Results: ");
    search(keyboard, Movies, aMovie, 4);
  }//searchYear

  private static void searchRating(Scanner keyboard, MovieDatabase Movies) {
    System.out.print("Please enter a rating to search for: ");
    keyboard.nextLine();
    int rating = keyboard.nextInt();
    Movie aMovie = new Movie();
    aMovie.setYear(rating);
    System.out.println("Results: ");
    search(keyboard, Movies, aMovie, 2);
  }//searchRating

  private static void toFile(Scanner keyboard, MovieDatabase Movies) {
    System.out.print("Please enter a filename: ");
    keyboard.nextLine();
    String filename = keyboard.nextLine();
    Movies.writeToFile(filename);
  }//toFile

  private static void fromFile(Scanner keyboard, MovieDatabase Movies) {
    System.out.print("Please enter a filename: ");
    keyboard.nextLine();
    String filename = keyboard.nextLine();
    Movies.readFromFile(filename);
  }//toFile

}
