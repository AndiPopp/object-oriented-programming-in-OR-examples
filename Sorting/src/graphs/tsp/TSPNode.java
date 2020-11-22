package graphs.tsp;

import graphs.*;
import graphs.weighted.*;
import sorting.SortAlgorithms;

/**
 * This is class represents a node in an undirected graph,
 * which is (or will be) part of a round trip in a 
 * travelling salesman problem.
 * @author Andreas Popp
 */
public class TSPNode extends UndirectedNode<WeightedEdge> {

	/**
	 * Next stop on the round trip. If null, the round
	 * trip must go further from this node.
	 */
	Edge nextOnTrip;
	
	/**
	 * Previous stop on the round trip. If null, the node
	 * has not been visited yet.
	 */
	Edge previousOnTrip;
	
	/**
	 * Constructor setting the nodes name. It also initializes
	 * the round trip fields with null
	 * @param name
	 */
	public TSPNode(String name) {
		super(name);
		//initialize without round trip solution
		nextOnTrip = null;
		previousOnTrip = null;
	}
	
	/**
	 * find the nearest neighbor
	 * @return the nearest non visited neighbor, 
	 * 	null if all neighbors have been visited
	 */
	public TSPNode nearestNeighbor(){
		//sort the neighbors
		WeightedEdge[] neighbors = new WeightedEdge[0];
		neighbors = getNeighbors().toArray(neighbors);
		SortAlgorithms.selectionSort(neighbors, true);
		
		//go through the sorted neighbors
		for(Edge edge : neighbors){
			//determine the neighbor node
			TSPNode neighbor;
			if (edge.getStart() == this){
				neighbor = (TSPNode) edge.getEnd();
			}else{
				neighbor = (TSPNode) edge.getStart();
			}
			//Check if neighor has been visited
			if (neighbor.nextOnTrip == null){
				//neighbor has not been visited
				this.nextOnTrip = edge;
				neighbor.previousOnTrip = edge;
				return neighbor;
			}
		}
		
		//all neighbors have already been visited
		return null;
	}
}
