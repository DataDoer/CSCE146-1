public class Student extends Person {
  //Initializers
  //
  private int id;

  //Constructors
  //
  public Student() {
    super(); //Call parent's Constructor
    this.id = 0;
  }//Student default
  public Student(String aName, int anID) {
    super(aName); //Call parent with parameter
    this.setID(anID); //Set the ID
  }//Student with parameters

  //Accessors
  //
  public int getID() {
    return this.id;
  }//getID

  //Mutators
  //
  public void setID(int anID) {
    if(anID >= 0) {//Check for errors
      this.id = anID;
    }//if
  }//setID

  public boolean equals(Student aStudent) {
    return  aStudent != null && //First argument is redundant; super equals will return false if null
            super.equals(aStudent) && //A student is always a person but not necessarily vice versa, POLYMORPHISM
            this.id == aStudent.getID();
  }//equals

  public String toString() {
    return super.toString() + " " + this.id;
  }
}//Student
