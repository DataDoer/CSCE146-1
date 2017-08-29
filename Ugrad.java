public class Ugrad extends Student {
  private int level; //1 = fresh, 2 = soph, 3 = jun, 4 = sen, 5 = supersenior
  //Enum advised ^

  public Ugrad() {//Default constructor
    super();
    this.level = 1;
  }//Ugrad
  public Ugrad(String aName; int anID, int aLevel) {//Parameterized Constructor
    super(aName, anID);
    this.level = this.setLevel(aLevel);
  }//Ugrad parameterized

  public int getLevel() {//Accessor
    return this.level;
  }//getLevel

  public void setLevel(int anID) {//Mutator
    if(aLevel >= 1 && aLevel <= 5) {
      this.level = aLevel;
    }//if
  }//setLevel

  public boolean equals(Ugrad anUgrad) {
    return  anUgrad != null && //redundant again, the next statement will go all the way to person.equals method and return false
            super.equals(anUgrad) &&
            this.level == anUgrad;
  }//equals
}//Ugrad
