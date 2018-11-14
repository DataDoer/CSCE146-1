public class Jeep {
  private static final String UNITS = "lbs";
  private String name;
  private int horsepower;
  private int weight;
  public Jeep(String aName, int aHorsepower, int aWeight) {
    init(aName, aHorsepower, aWeight);
  }

  public int compareTo(Jeep aJeep) {
    return (horsepower - aJeep.getHorsepower());
  }//compareTo

  public String toString() {
    return name+" with "+horsepower+" horsepower weighs "+weight+" "+UNITS;
  }//toString



  //privates
  private void init(String aName, int aHorsepower, int aWeight) {
    name = aName;
    horsepower = aHorsepower;
    weight = aWeight;
    if(aName == null) name = "A Jeep";
    if(aHorsepower < 0) horsepower = 0;
    if(aWeight < 0) aWeight = 0;
  }

  //Getters
	/**
	* Returns value of name
	* @return
	*/
	public String getName() {
		return name;
	}
	/**
	* Returns value of horsepower
	* @return
	*/
	public int getHorsepower() {
		return horsepower;
	}
	/**
	* Returns value of weight
	* @return
	*/
	public int getWeight() {
		return weight;
	}
}//Jeep
