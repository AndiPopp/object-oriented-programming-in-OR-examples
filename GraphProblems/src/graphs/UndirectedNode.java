package graphs;

public class UndirectedNode extends Node {
	
	//constructor
	public UndirectedNode(String name) {
		super(name);
	}
	
	//method to populate the neighbors field
	public Edge[] getNeighbors(){
		Edge[] neighbors = 
				new Edge[getInboud().length + getOutbound().length];
		int i = 0;
		for(Edge edge : getInboud()){
			neighbors[i] = edge;
			i++;
		}
		for(Edge edge : getOutbound()){
			neighbors[i] = edge;
			i++;
		}
		
		return neighbors;
	}

}
