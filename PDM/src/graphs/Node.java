package graphs;

public class Node {

	//the node's name
	private String name;
	
	//the edges connecting to this node
	Edge[] inboud;
	Edge[] outbound;
	
	//standard constructor
	public Node(String name) {
		this.name = name;
	}

	//getters
	public String getName() {
		return name;
	}

	public Edge[] getInboud() {
		return inboud;
	}

	public Edge[] getOutbound() {
		return outbound;
	}

}
