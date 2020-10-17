package graphs.weighted;

import graphs.*;

public class WeightedEdge extends Edge {

	//The edge's weight
	private double weight;

	//Constructor
	public WeightedEdge(Node start, Node end, double weight) {
		super(start, end);
		this.weight = weight;
	}
	
	//Getters
	public double getWeight() {
		return weight;
	}

	@Override
	public String toString(){
		return start.getName() + " -> " + end.getName() 
				+ " (" + this.weight + ")";
	}
}
