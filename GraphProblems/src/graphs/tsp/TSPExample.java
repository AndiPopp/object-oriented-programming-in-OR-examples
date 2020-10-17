package graphs.tsp;

import graphs.weighted.WeightedEdge;

public final class TSPExample {

	public static void main(String[] args) {
		TSPGraph example = exampleGraph();
		example.solve((TSPNode)example.getNodes()[0]);
		example.printSolution((TSPNode)example.getNodes()[0]);
	}
	
	private static TSPGraph exampleGraph(){
		//nodes
		TSPNode[] nodes = new TSPNode[5];
		nodes[0] = new TSPNode("A");
		nodes[1] = new TSPNode("B");
		nodes[2] = new TSPNode("C");
		nodes[3] = new TSPNode("D");
		nodes[4] = new TSPNode("E");
		
		//edges
		WeightedEdge[] edges = new WeightedEdge[10];
		edges[0] = new WeightedEdge(nodes[0], nodes[1], 3);
		edges[1] = new WeightedEdge(nodes[0], nodes[2], 8);
		edges[2] = new WeightedEdge(nodes[0], nodes[3], 2);
		edges[3] = new WeightedEdge(nodes[0], nodes[4], 6);
		edges[4] = new WeightedEdge(nodes[1], nodes[2], 5);
		edges[5] = new WeightedEdge(nodes[1], nodes[3], 4);
		edges[6] = new WeightedEdge(nodes[1], nodes[4], 4);
		edges[7] = new WeightedEdge(nodes[2], nodes[3], 5);
		edges[8] = new WeightedEdge(nodes[2], nodes[4], 2);
		edges[9] = new WeightedEdge(nodes[3], nodes[4], 5);
		
		return new TSPGraph(nodes, edges);
	}

}
