public class Fruit implements Comparable {
  private String name;
  private double weight;
  public Fruit(String aName, double aWeight) {
    setName(aName);
    setWeight(aWeight);
  }



	/**
	* Returns value of name
	* @return
	*/
	public String getName() {
		return name;
	}

	/**
	* Sets new value of name
	* @param
	*/
	private void setName(String name) {
		this.name = name;
	}

	/**
	* Returns value of weight
	* @return
	*/
	public double getWeight() {
		return weight;
	}

	/**
	* Sets new value of weight
	* @param
	*/
	private void setWeight(double weight) {
    if(weight < 0) weight = 0; //Can't have a negative weight
		this.weight = weight;
	}

	public String toString() {
		return name + "\t" + weight;
	}

  public boolean equals(Fruit aFruit) {
    return compareTo(aFruit) == 0 && aFruit.getName().equals(name);
  }

  public int compareTo(Object anObject) {
    Fruit aFruit = (Fruit)anObject;
    if(weight < aFruit.getWeight()) return -1;
    else if(weight > aFruit.getWeight()) return 1;
    else return 0;
  }
}
