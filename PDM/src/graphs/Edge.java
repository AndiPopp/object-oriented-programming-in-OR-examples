package graphs;

public class Edge {

	//the edge's start and end point
	protected Node start;
	protected Node end;
	
	//constructor
	public Edge(Node start, Node end) {
		this.start = start;
		this.end = end;
	}

	//getters
	public Node getStart() {
		return start;
	}

	public Node getEnd() {
		return end;
	}
	
	//toString
	public String toString(){
		return start.getName() + " -> " + end.getName();
	}
}
