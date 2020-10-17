package lotsizing;

//a class reprensenting a single period in the
//Wagner-Whitin-problem
public class Period {
	
	//the demand in this period
	private double demand;
	
	//the partial optimal value from this period to
	//the end of the planning time frame
	private double partialOpt;
	
	//the index of the next setup period
	private int nextSetup;

	//Construct a period with a given demand setting
	//the solution parameters to -1 indicating unsolved
	public Period(double demand) {
		this.demand = demand;
		partialOpt = -1;
		nextSetup = -1;
	}

	//Getter for the demand
	public double getDemand() {
		return demand;
	}

	//Getter for the partial objective function
	public double getPartialOpt() {
		return partialOpt;
	}

	//Setter for the partial objective function
	public void setPartialOpt(double partialOpt) {
		this.partialOpt = partialOpt;
	}

	//Getter for the next setup period
	public int getNextSetup() {
		return nextSetup;
	}

	//Setter for the next setup period
	public void setNextSetup(int nextSetup) {
		this.nextSetup = nextSetup;
	}
}
