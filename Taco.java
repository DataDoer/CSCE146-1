public class Taco {
  private String name;
  private String maker;
  private double price;
  private int rating; //0-5

  public Taco() {
    this.name = this.maker = "No name yet."; //All in one shot
    this.price = 0.0;
    this.rating = 0;
  }//Taco Constructor; No params

  public Taco (String aName, String aMaker, double aPrice, int aRating) {
    //TODO
  }//Taco Constructor; params

  public String getName() {
    return this.name;
  }//getName

  public void setName(String name) {
    this.name = name;
  }//setName

  public String getMaker() {
    return this.maker;
  }//getMaker

  public void setMaker(String maker) {
    this.maker = maker;
  }//setMaker

  public double getPrice() {
    return this.price;
  }//getPrice

  public void setPrice(double price) {
    if (price >= 0.0) this.price = price;
  }//setPrice

  public int getRating() {
    return this.rating;
  }//getRating

  public void setRating(int rating) {
    if(rating >= 0 && rating <= 5) this.rating = rating;
  }//setRating

  public boolean equals(Taco aTaco) {
    return aTaco != null &&
        this.name.equals(aTaco.getName()) &&
        this.maker.equals(aTaco.getMaker()) &&
        this.price == aTaco.getPrice() &&
        this.rating == aTaco.getRating();
  }//equals


}//Taco Class
