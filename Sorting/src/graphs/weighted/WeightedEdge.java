package graphs.weighted;

import sorting.*;
import graphs.*;

/**
 * A class representing an edge with a weight value
 * @author Andreas Popp
 */
public class WeightedEdge extends Edge implements Sortable {

	/**
	 * The edge's weight
	 */
	private double weight;

	/**
	 * Constructor setting all fields
	 * @param start the start node
	 * @param end the end node
	 * @param weight the weight
	 */
	public WeightedEdge(Node<? extends WeightedEdge> start, 
			Node<? extends WeightedEdge> end, double weight) {
		
		super(start, end);
		this.weight = weight;
	}
	
	/**
	 * getter for {@link #weight}
	 * @return the content of {@link #weight}
	 */
	public double getWeight() {
		return weight;
	}

	@Override
	public String toString(){
		return start.getName() + " -> " + end.getName() 
				+ " (" + this.weight + ")";
	}

	@Override
	public double sortValue() {
		return weight;
	}
}
