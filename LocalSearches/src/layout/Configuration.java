package layout;

import localsearch.LocalSearchSolution;

public class Configuration extends LocalSearchSolution {
	
	//a set of assignments determines the configuration
	final Assignment[] assignments;
	
	//constructor	
	public Configuration(Assignment[] assignments) {
		this.assignments = assignments;
	}

	//loads this configuration into the problem's objects
	private void load(){
		//load the new one
		for(Assignment assg : assignments){
			assg.location.resource = assg.resource;
			if(assg.resource != null){
				assg.resource.location = assg.location;
			}
		}
	}
	
	@Override
	public boolean toMaximize() {
		//minimize transport effort
		return false;
	}
	
	@Override
	public double calcObjective(){
		load();
		double solution = 0;
		for(Assignment assg : assignments){
			if (assg.resource != null){
				solution += assg.resource.calcObjective();
			}
		}
		return solution;
	}
	
	@Override
	public void print(){
		for(Assignment assg : assignments){
			System.out.println(assg.toString());
		}
		System.out.print("=> Obj: ");
		this.printObjective();
		System.out.println();
	}

	@Override
	public LocalSearchSolution[] getNeighbors() {
		//calculate the size of neighborhood via "small Gauß"
		int aux = assignments.length-1;
		Configuration[] neighbors = new Configuration[(aux*aux+aux)/2];
		
		//construct the neighbors
		int a = 0; //iteration variable for final array
		//i and j are the indexes to be swapped
		for(int i = 0; i < assignments.length; i++){
			for (int j = i+1; j < assignments.length; j++){
				//construct the new configuration and iterate a
				neighbors[a] = new Configuration(swap(assignments, i, j));
				a++;
			}
		}
		//all elements of neighbors have been filled
		return neighbors;
	}
	
	//swap assignments i and j
	private static Assignment[] swap(Assignment[] assignments, 
			int i, int j){
		//build a new array of assignments for the new configuration
		Assignment[] newAssg = new Assignment[assignments.length];
		
		//fill the array
		for (int k = 0; k < assignments.length; k++){
			//swap locations/resources for i and j
			if (k == i){
				newAssg[k] = new Assignment(assignments[j].resource,
						assignments[i].location);
			}else if (k == j){
				newAssg[k] = new Assignment(assignments[i].resource, 
						assignments[j].location); 
			}else{
				//do not swap other indexes
				newAssg[k] = assignments[k];
			}
		}
		//return the array
		return newAssg;
	}
}
