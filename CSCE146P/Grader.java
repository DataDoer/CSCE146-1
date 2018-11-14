import java.util.*;
import java.io.*;

//Justin Baum
//00426510

public class Grader {
  //Asked in lab about extra credit, I'm told you can get half credits on your extra credit, so if you have 150/500
  //That's 5 assignments worth a maximum of 10 points, and you received 3 of them.
  private static final String[] headers = {
    "LABS",
    "EXAM 1",
    "EXAM 2",
    "LAB EXAM 1",
    "LAB EXAM 2",
    "FINAL",
    "HOMEWORK",
    "EXTRA CREDIT"//EXCEPTION
  };
  private static final String HOMEWORK = "HOMEWORK";
  private static final String EXTRACREDIT = "EXTRA CREDIT";
  private static final int CUTOFF = 7; //CUTOFF FOR EXCEPTIONS
  private static final String[] gradeLetters = {
    "F",
    "D",
    "D+",
    "C",
    "C+",
    "B",
    "B+",
    "A",
  };
  private static final int[] finalGrade = {
    60,
    65,
    70,
    75,
    80,
    85,
    90,
    125,//Everything above 90
  };
  private static final double[] gradeWeights = {
    0.20,
    0.10,
    0.10,
    0.10,
    0.10,
    0.10,//I made final 10 so the grades add up to 110
    0.30,//Homework
    0.02,//EXCEPTION
  };


  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter a filename: ");
    String fileName = "./"+keyboard.nextLine();
    String fileLine;
    int[] grades = new int[headers.length];
    int[] gradesCounter = new int[headers.length];
    int lowestHWGrade = 110;
    int currentGrade;
    try { //Try ask user for filename
      //GET GRADES
      File file = new File(fileName);//File
      Scanner fileScanner = new Scanner(file);//Find the file and load into scanner
      while(fileScanner.hasNextLine()) {
        fileLine = fileScanner.nextLine();//Get the header
        while(fileScanner.hasNextInt()) {//wild guess; it worked
          currentGrade = fileScanner.nextInt();
          //exception 1
          //Cut homework
          if(fileLine.equals(HOMEWORK)) {
            if(currentGrade < lowestHWGrade) lowestHWGrade = currentGrade; //Make lowest grade for dropping
          }//if
          grades[getGradeType(fileLine)] += currentGrade;
          gradesCounter[getGradeType(fileLine)]++;
        }//while
      }//while
      //close scanner
      fileScanner.close();

      //Drop lowest hw grade
      grades[getGradeType(HOMEWORK)] -= lowestHWGrade;
      gradesCounter[getGradeType(HOMEWORK)]--;

      //CALCULATE GRADES
      calculateGrades(grades,gradesCounter);

    } catch (Exception e) { //Filename does not exist
      System.out.println("File does not exist!");
    }//try-catch
  }//main

  public static String getGrade(double grade) {
    for(int i = 0; i < finalGrade.length; i++) {
      if(grade < finalGrade[i]) return gradeLetters[i]; //Return grade according to array
    }//for
    return null;
  }//getGrade

  public static int getGradeType(String gradeType) {
    for(int i = 0; i < headers.length; i++) {
      if(gradeType.equals(headers[i])) return i;
    }
    return 0;
  }//getGradeType

  public static void calculateGrades(int[] grades, int[] gradesCounter) {
    //Didn't want to make double[] function, so the gradecounter also lets user know grades
    double total = 0;
    double currentGrade;
    for(int i = 0; i < CUTOFF; i++) {//Add grade to total
      if(gradesCounter[i] <= 0) {//Get a 100 out of generosity, say a single homework was dropped
        currentGrade = 100;
      } else {
        currentGrade =  Math.ceil(1.0*grades[i]/gradesCounter[i]);
      }//if else
      total += currentGrade*gradeWeights[i];//add to total
      //Display to user
      System.out.println("Your " + headers[i] + " grade is " + currentGrade +".");
    }//for
    //EXTRACREDIT EXCEPTION
    currentGrade = Math.ceil(1.0*grades[getGradeType(EXTRACREDIT)]*gradeWeights[getGradeType(EXTRACREDIT)]);//Every 100 on a Extra credit is 0.02 points to your final grade
    System.out.println("You gained " + currentGrade + " extra credit points added to your grade.");
    total += currentGrade;
    total = Math.ceil(total);
    System.out.println("Your raw total is " + total + ".");

    //Output final
    System.out.println("Your final letter grade is " + getGrade(total) + ".");
  }//calculateGrades
}//Grader
