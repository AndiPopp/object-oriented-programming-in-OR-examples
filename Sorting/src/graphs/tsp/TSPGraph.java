package graphs.tsp;

import graphs.*;
import graphs.weighted.*;

public class TSPGraph extends WeightedGraph{

	//constructor
	public TSPGraph(TSPNode[] nodes, WeightedEdge[] edges) {
		super(nodes, edges);
	}
	
	//find a round trip with the nearest neighbor heuristic
	public void solve(TSPNode start){
		TSPNode current = start;
		
		while(current != null){
			TSPNode nearest = current.nearestNeighbor();
			if (nearest == null){
				closeRoundTrip(start, current);
			}
			current = nearest;
		}
	}
	
	//close the two ends of an open rount trip
	private void closeRoundTrip(TSPNode start, TSPNode end){
		for (Edge edge : end.getNeighbors()){
			if (edge.getStart() == start || edge.getEnd() == start){
				end.nextOnTrip = edge;
				start.previousOnTrip = edge;
			}
		}
	}
	
	//print the round trip to the console
	public void printSolution(TSPNode start){
		TSPNode current = start;
		do{
			System.out.println(current.nextOnTrip.toString());
			if (current.nextOnTrip.getStart() == current){
				current = (TSPNode) current.nextOnTrip.getEnd();
			}else{
				current = (TSPNode) current.nextOnTrip.getStart();
			}
		}while(current != start);
	}
	
}
