package localsearch;

public abstract class LocalSearchSolution {

	//construct to neighborhood of a solution
	public abstract LocalSearchSolution[] getNeighbors();
	
	//calculate the objective function
	public abstract double calcObjective();
	
	//indicate if the objective function is to be maximized.
	//false indicates minimization
	public abstract boolean toMaximize();
	
	//a convenience function to print the solution to console
	public abstract void print();
	
	//a convenience function to print the solution's objective
	//function value to the console
	public void printObjective(){
		System.out.println(calcObjective());
	}
}
