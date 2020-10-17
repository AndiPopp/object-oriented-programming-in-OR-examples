package graphs.tsp;

import graphs.*;
import graphs.weighted.*;

public class TSPNode extends UndirectedNode {

	//fields for the round trip solution, if null
	//the node has not been visited yet
	Edge nextOnTrip;
	Edge previousOnTrip;
	
	//constructor
	public TSPNode(String name) {
		super(name);
		//initialize without round trip solution
		nextOnTrip = null;
		previousOnTrip = null;
	}
	
	//Convenience method to default weight of standard edges to 0
	private static double getWeight(Edge edge){
		if (edge instanceof WeightedEdge){
			return ((WeightedEdge)edge).getWeight();
		}
		return 0;
	}
	
	//sort the neighbors by distance
	public Edge[] sortNeighbors(){
		Edge[] neighbors = this.getNeighbors();
		for(int i = 0; i < neighbors.length; i++){
			//find smallest element
			int min = i;
			for(int j = i+1; j<neighbors.length; j++){
				if (getWeight(neighbors[j]) < getWeight(neighbors[min])){
					min = j;
				}
			}
			//swap
			Edge swap = neighbors[i];
			neighbors[i] = neighbors[min];
			neighbors[min] = swap;
		}
		
		return neighbors;
	}
	
	//returns the nearest (non visited) neighbor
	//null if all neighbors have been visited
	public TSPNode nearestNeighbor(){
		//go through the sorted neighbors
		for(Edge edge : sortNeighbors()){
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
