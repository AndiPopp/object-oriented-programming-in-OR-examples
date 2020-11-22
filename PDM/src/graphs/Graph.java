package graphs;

public class Graph {

	//the graph's elements
	protected Node[] nodes;
	protected Edge[] edges;
	
	//constructor	
	public Graph(Node[] nodes, Edge[] edges) {
		this.nodes = nodes;
		this.edges = edges;
		setEdges();
	}
	
	//getters
	public Node[] getNodes() {
		return nodes;
	}

	public Edge[] getEdges() {
		return edges;
	}

	//convenience function to link the edges to the nodes
	public void setEdges(){
		for(Node node : nodes){
			setNodeEdges(node, edges);
		}
	}
	
	//checks for edges inbound to or outbound from a node
	//and add the to the node's fields
	static void setNodeEdges(Node node, Edge[] edges){
		//count the edges
		int countInbound = 0;
		int countOutbound = 0;
		for (Edge edge : edges){
			if (edge.start == node){
				countOutbound++;
			}
			if (edge.end == node){
				countInbound++;
			}
		}
		
		//create the arrays
		node.inboud = new Edge[countInbound];
		node.outbound = new Edge[countOutbound];
		
		//fill the arrays
		countInbound = 0;
		countOutbound = 0;
		for (Edge edge : edges){
			if (edge.start == node){
				node.outbound[countOutbound] = edge;
				countOutbound++;
			}
			if (edge.end == node){
				node.inboud[countInbound] = edge;
				countInbound++;
			}
		}
	}
}
