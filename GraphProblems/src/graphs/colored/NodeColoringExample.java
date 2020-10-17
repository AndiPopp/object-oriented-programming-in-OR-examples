package graphs.colored;

import graphs.Edge;

public final class NodeColoringExample {

	public static void main(String[] args) {
		ColoredGraph example = exampleGraph();
		example.solve();
		example.printColors();
	}
	
	private static ColoredGraph exampleGraph(){
		//nodes
		ColoredNode[] nodes = new ColoredNode[7];
		nodes[0] = new ColoredNode("I");
		nodes[1] = new ColoredNode("II");
		nodes[2] = new ColoredNode("III");
		nodes[3] = new ColoredNode("IV");
		nodes[4] = new ColoredNode("V");
		nodes[5] = new ColoredNode("VI");
		nodes[6] = new ColoredNode("VII");
		
		//edges
		Edge[] edges = new Edge[11];
		edges[ 0] = new Edge(nodes[0], nodes[1]);
		edges[ 1] = new Edge(nodes[0], nodes[2]);
		edges[ 2] = new Edge(nodes[1], nodes[2]);
		edges[ 3] = new Edge(nodes[1], nodes[3]);
		edges[ 4] = new Edge(nodes[2], nodes[3]);
		edges[ 5] = new Edge(nodes[2], nodes[4]);
		edges[ 6] = new Edge(nodes[2], nodes[5]);
		edges[ 7] = new Edge(nodes[3], nodes[4]);
		edges[ 8] = new Edge(nodes[4], nodes[5]);
		edges[ 9] = new Edge(nodes[4], nodes[6]);
		edges[10] = new Edge(nodes[5], nodes[6]);
		
		return new ColoredGraph(nodes, edges);
	}

}
