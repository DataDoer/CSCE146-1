public static void main(String[] args) {
  Scanner keyboard = new Scanner(System.in);
  System.out.print("Enter a filename: ");
  String fileName = "./"+keyboard.nextLine();
  String fileLine;
  try { //Try ask user for filename and read file
    File file = new File(fileName);//File
    Scanner fileScanner = new Scanner(file);//Find the file and load into scanner
    while(fileScanner.hasNextLine()) {
      System.out.println(fileScanner.nextLine());
      }//while
    }//while
    //close scanner
    fileScanner.close();


  } catch (Exception e) { //Filename does not exist
    System.out.println("File does not exist!");
  }//try-catch
}//main
