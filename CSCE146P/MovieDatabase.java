//00426510
//Justin Baum

import java.io.*;
import java.util.*;

public class MovieDatabase {
  private String DELIM = "\t";
  public GenLinkedList2<Movie> Movies = new GenLinkedList2<Movie>();

  public void addMovie(Movie aMovie) {
    Movies.insert(aMovie);
  }//addMovie

  public void removeMovie(Movie aMovie) {//Remove movie by name
    Movies.resetCurrent();
    //Use modulus to find if movies have similar names
    while(Movies.hasNext() && Movies.getCurrent().compareTo(aMovie) % 2 != 1) {//Cycle until we reach the intended one
      Movies.gotoNext();
    }//while
    if(Movies.getCurrent().compareTo(aMovie) % 2 == 1) {
      Movies.deleteCurrent();
    } else System.out.println("Movie not found... Error.");
  }//removeMovie

  public void removeMovie(String aName) {//Moviename search
    removeMovie(new Movie(aName));
  }//removeMovie

  public void gotoNext() {
    Movies.gotoNext();
  }//gotoNext

  public void gotoPrev() {
    Movies.gotoPrev();
  }//gotoPrev

  public MovieDatabase search(Movie aMovie, int compare) {
    MovieDatabase results = new MovieDatabase();
    Movies.resetCurrent();
    while(Movies.hasNext()) {
      if((aMovie.compareTo(Movies.getCurrent()) & compare) != 0) {
        results.addMovie(Movies.getCurrent());
      }//if
      Movies.gotoNext();
    }//while
    if((aMovie.compareTo(Movies.getCurrent()) & compare) != 0) {
      results.addMovie(Movies.getCurrent());
    }//if
    return results;
  }//search

  public Movie search(String aName) {
    return searchSingle(aName);
  }//search

  public Movie searchSingle(Movie aMovie) {
    Movies.resetCurrent();
    while(Movies.getCurrent() != null) {
      if(aMovie.compareTo(Movies.getCurrent()) % 2 == 1) {
        return Movies.getCurrent();
      }//if
      Movies.gotoNext();
    }//while
    if(aMovie.compareTo(Movies.getCurrent()) % 2 == 1) {
      return Movies.getCurrent();
    }//if
    return null;
  }//searchSingle

  public Movie searchSingle(String aName) {
    Movie newMovie = new Movie();
    newMovie.setName(aName);
    return searchSingle(newMovie);
  }//searchSingle

  public void printAllMovies() {
    if(Movies.empty()) return;
    Movies.resetCurrent();
    while(Movies.hasNext()) {
      System.out.println(Movies.getCurrent());
      Movies.gotoNext();
    }
    System.out.println(Movies.getCurrent());
  }

  public void readFromFile(String filename) {
    try {
      File file = new File(filename);//File
      Scanner fileScanner = new Scanner(file);//Find the file and load into scanner
      while(fileScanner.hasNextLine()) {
        String fileLine = fileScanner.nextLine();//Get the header
        String[] fileSplit = fileLine.split(DELIM);
        if(fileSplit.length != 5) continue;
        String name = fileSplit[0];
        int year = Integer.parseInt(fileSplit[1]);
        int rating = Integer.parseInt(fileSplit[2]);
        String director = fileSplit[3];
        double gross = Double.parseDouble(fileSplit[4]);
        addMovie(new Movie(name,year,rating,director,gross));
      }//while
      fileScanner.close();
    } catch(Exception e) {
      System.out.println("Error.");
      System.out.println(e);
    }
  }//readFromFile

  public void writeToFile(String filename) {
    if(filename == null || Movies == null) {
        return;
      }//if
    try {
      File file = new File(filename);
      FileOutputStream fop = new FileOutputStream(file);
      PrintWriter fileWriter =  new PrintWriter(fop);//Completely wipes the file clean
      if(Movies.empty()) return;
      Movies.resetCurrent();
      while(Movies.hasNext()) {
        fileWriter.println(Movies.getCurrent().toString(true));
        Movies.gotoNext();
      }
      fileWriter.println(Movies.getCurrent().toString(true));
      fileWriter.close();
    } catch(Exception e) {
      System.out.println("Error.");
      System.out.println(e);
    }//try-catch
  }//writeToFile

  public Movie getCurrent() {
    return Movies.getCurrent();
  }

}//MovieDatabase
