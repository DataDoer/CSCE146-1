public class Person {
  //Instance variables
  //
  private String name;

  //Constructors
  //
  public Person() {//Default Constructor
    this.name = "no name yet";
  }//Person

  public Person(String aName) {//Parameterized Constructor
    this.setName(aName);
  }//Person <<String>>

  //Accessors
  //
  public String getName() {
    return this.name();
  }//getName

  //Mutators
  //
  public void setName(String aName) {
    this.name = aName;
  }//setName

  //Other Methods
  //

  public boolean equals(Person aPerson) {
    //Check for a Null exception
    return aPerson != null && this.name.equals(aPerson.getName());
  }//equals

  public String toString() {//Return the name as String
    return this.name;
  }//toString

}//Person
