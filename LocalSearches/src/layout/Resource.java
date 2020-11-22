package layout;

public class Resource {

	//the resource's name
	final String name;
	
	//the movements to other resources
	Movement[] movements;

	//the resource's location
	Location location;
	
	//constructor
	public Resource(String name) {
		this.name = name;
	}
	
	//calculate this resource's contribution to the objective function
	public double calcObjective(){
		double solution = 0;
		for (Movement mov : movements){
			for (Distance dist : location.distances){
				if (mov.target.location == dist.target){
					solution += mov.quantity * dist.value;
					break;
				}
			}
		}
		return solution;
	}
}
