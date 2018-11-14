public class Movie {
  private String DELIM = "\t";
  private String name;
  private int year;
  private int rating; //1-5
  private String director;
  private double gross;
  private static final int DEFAULT_YEAR = 2017;
  private static final int MINIMUM_YEAR = 1800;//They didn't make movies before
  private static final double GROSS_SPREAD = 1.0;//$1 dollar in difference is negligible
  //Could've done a percent difference but a $1 trick looks neater


  public Movie() {
    setName("");
    setYear(DEFAULT_YEAR);
    setRating(0);
    setDirector("");
    setGross(0.0);
  }//Movie

  public Movie(String aName, int aYear, int aRating, String aDirector, double aGross) {
    setName(aName);
    setYear(aYear);
    setRating(aRating);
    setDirector(aDirector);
    setGross(aGross);
  }//Movie Params

  public Movie(String aName) {
    setName(aName);
  }



  //Checks if two Movies are equal
  public boolean equals(Movie aMovie) {
    if(aMovie == null) return false;
    return name.equals(aMovie.getName()) &&
      year == aMovie.getYear() &&
      rating == aMovie.getRating() &&
      director.equals(aMovie.getDirector()) &&
      Math.abs(gross - aMovie.getGross()) < GROSS_SPREAD;
  }//equals

  public String toString(boolean delimitted) {
    if(!delimitted) return toString();
    return getName()+DELIM+getYear()+DELIM+getRating()+DELIM+getDirector()+DELIM+getGross();
  }//toString
  public String toString() {
    return "Name: " + getName()+"\tYear: "+getYear()+"\tRating(0-5): "+getRating()+"\tDirector: "+getDirector()+"\tGross: $"+getGross();
  }//toString

  public int compareTo(Movie aMovie) {
    //0bABCDE
    //^ With this can do boolean comparisons to see what are the same and what are not
    //0b11111 are equals
    //r = 1 same name
    //r = 2 same rating
    //r = 3 same name and rating
    //etc.
    int r = 0;
    if(aMovie == null) return 0;
    if(equals(aMovie)) return 31;
    if(name.equals(aMovie.getName())) r += 1;
    if(rating == aMovie.getRating()) r += 2;
    if(year == aMovie.getYear()) r += 4;
    if(director.equals(aMovie.getDirector())) r+= 8;
    if(Math.abs(gross - aMovie.getGross()) < GROSS_SPREAD) r += 16;
    return r;
  }//compareTo
	/**
	* Returns value of name
	* @return
	*/
	public String getName() {
		return name;
	}//getName

	/**
	* Sets new value of name
	* @param
	*/
	public void setName(String name) {
		this.name = name;
	}//setName

	/**
	* Returns value of year
	* @return
	*/
	public int getYear() {
		return year;
	}//getYear

	/**
	* Sets new value of year
	* @param
	*/
	public void setYear(int year) {
		this.year = (year > MINIMUM_YEAR) ? year : DEFAULT_YEAR;
	}//setYear

	/**
	* Returns value of rating
	* @return
	*/
	public int getRating() {
		return rating;
	}//getRating

	/**
	* Returns value of director
	* @return
	*/
	public String getDirector() {
		return director;
	}//getDirector

	/**
	* Sets new value of director
	* @param
	*/
	public void setDirector(String director) {
		this.director = director;
	}//setDirector

	/**
	* Returns value of gross
	* @return
	*/
	public double getGross() {
		return gross;
	}//getGross


  public void setRating(int aRating) {//Put bounds
    rating = (aRating > 0 && aRating <= 5) ? aRating : 0;
  }//setRating

  public void setGross(double aGross) {//Put bounds
    gross = (aGross > 0) ? aGross : 0;
  }//setGross
}//Movie
