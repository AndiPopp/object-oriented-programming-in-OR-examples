package graphs;

public class UndirectedNode extends Node {

	//An array combining inbound and outbound
	private Edge[] neighbors;
	
	//constructor
	public UndirectedNode(String name) {
		super(name);
	}
	
	//method to populate the neighbors field
	private void fillNeighbors(){
		neighbors = new Edge[getInboud().length + getOutbound().length];
		int i = 0;
		for(Edge edge : getInboud()){
			neighbors[i] = edge;
			i++;
		}
		for(Edge edge : getOutbound()){
			neighbors[i] = edge;
			i++;
		}
	}

	//getter for neighbors
	public Edge[] getNeighbors() {
		if (neighbors == null) {
			fillNeighbors();
		}
		return neighbors;
	}
}
