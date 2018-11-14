//00426510
//Justin Baum

public class Process {
  private int priority;
  private double time;
  private String name;

  public Process(String aName, int aPriority, double aTime) {
    name = aName;
    priority = aPriority;
    time = aTime;
  }

  public String toString() {
    return name + " " + priority + " " + time;
  }

  public int compareTo(Process other) {
    if(priority < other.getPriority()) return -1;
    else if(priority > other.getPriority()) return 1;
    return 0;
  }


	/**
	* Returns value of priority
	* @return
	*/
	public int getPriority() {
		return priority;
	}

	/**
	* Sets new value of priority
	* @param
	*/
	public void setPriority(int priority) {
    if(priority <= 0) return;
		this.priority = priority;
	}

	/**
	* Returns value of time
	* @return
	*/
	public double getTime() {
		return time;
	}

	/**
	* Sets new value of time
	* @param
	*/
	public void setTime(double time) {
    if(time <= 0) return;
		this.time = time;
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
	public void setName(String name) {
		this.name = name;
	}
}
