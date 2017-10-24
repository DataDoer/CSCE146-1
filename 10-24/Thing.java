public class Thing implements Comparable {
  private int thing;

  public Thing() {
    thing = 0;
  }
  public Thing(int number) {
    thing = number;
  }
  public int getThing() {
    return this.thing;
  }
  public int compareT(Object aThing) {
    Thing aThing2 = (Thing)aThing;
    if(this.thing < aThing2.getThing()) return -1;
    else if(this.thing > aThing2.getThing()) return 1;
    else return 0;
  }
}
