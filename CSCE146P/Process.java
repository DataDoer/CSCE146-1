//Justin Baum
//00426510

public class Process {
  private String name;
  private double completionTime;

  public Process() {
    name = "Default Process";
    completionTime = 0.0;
  }//Process

  public Process(String aName, double aTime) {
    name = aName;
    completionTime = aTime;
  }//Process


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
	* Returns value of time
	* @return
	*/
	public double getCompletionTime() {
		return completionTime;
	}//getTime

	/**
	* Sets new value of time
	* @param
	*/
	public void setCompletionTime(double time) {
    if(time <= 0) time = 0.0;
		this.completionTime = time;
	}//setTime

  public String toString() {
    return "Process Name: " + name + " Completion Time: " + completionTime;
  }


}
