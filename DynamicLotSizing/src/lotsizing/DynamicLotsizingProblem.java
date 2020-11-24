package lotsizing;

public class DynamicLotsizingProblem {

	//the setup cost factor
	double setupCost;
	
	//the inventory holding cost factor
	double inventoryCost;
	
	//the array of periods
	Period[] periods;

	//constructor setting all fields	
	public DynamicLotsizingProblem(double setupCost, 
			double inventoryCost, Period[] periods) {
		this.setupCost = setupCost;
		this.inventoryCost = inventoryCost;
		this.periods = periods;
	}
	
	//calculates the partial objective function for time frame setup...T,
	//i.e. C(setup, nextSetup) + C*(nextSetup)
	public double calcPartialObjective(int setup, int nextSetup){
		//count the demand to get the lot size
		double lotSize = 0;
		for(int i = setup; i < nextSetup; i++){
			lotSize += periods[i].getDemand();
		}
		
		//start with the setup cost
		double partialObj = setupCost;
		
		//calculate the inventory at the end of each period
		//and add the inventory costs 
		for(int i = setup; i < nextSetup; i++){
			lotSize -= periods[i].getDemand();
			partialObj += inventoryCost * lotSize;
		}
		
		//if the next setup period is within the time frame
		//of our problem, add its partial objective function
		if (nextSetup < periods.length) {
			partialObj += periods[nextSetup].getPartialOpt();
		}
		
		//return the value
		return partialObj;
	}
	
	//solves a single setup period
	private void solve(int setup){
		//initialize with single period lot
		periods[setup].setPartialOpt(
				calcPartialObjective(setup, setup+1));
		periods[setup].setNextSetup(setup+1);
		
		//go through rest of the time frame
		for(int i = setup+2; i < periods.length+1; i++){
			//check if this partial solution is better
			if (calcPartialObjective(setup, i) <
				periods[setup].getPartialOpt()){
				
				//save this partial solution
				periods[setup].setPartialOpt(
						calcPartialObjective(setup, i));
				periods[setup].setNextSetup(i);
			}
		}
	}
	
	//solves the problem
	public void solve(){
		for(int i = periods.length-1; i >= 0; i--){
			solve(i);
		}
	}
	
	//builds a string representation of the solution
	public String getSolution(){
		String output = "Solution with total cost of ";
		output += periods[0].getPartialOpt();
		output += " and setup periods: ";
		
		int setupPeriod = 0;
		while (setupPeriod < periods.length){
			output += setupPeriod +" ";
			setupPeriod = periods[setupPeriod].getNextSetup();
		}
		
		return output;
	}
}