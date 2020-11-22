package graphs;

/**
 * A edge, i.e. a pair of two connected nodes in a graph
 * @author Andreas Popp
 */
public class Edge{

	/**
	 * the edge's start node
	 */
	protected Node<?>  start;
	
	/**
	 * the edge's end node
	 */
	protected Node<?> end;
	
	/**
	 * constructor setting all fields
	 * @param start the edge's start node
	 * @param end the edge's end node
	 */
	public Edge(Node<? extends Edge> start, Node<? extends Edge> end) {
		this.start = start;
		this.end = end;
	}

	/**
	 * getter for {@link #start}
	 * @return the content of field {@link #start}
	 */
	public Node<? extends Edge> getStart() {
		return start;
	}

	/**
	 * getter for {@link #end}
	 * @return the content of field {@link #end}
	 */
	public Node<? extends Edge> getEnd() {
		return end;
	}
	
	@Override
	public String toString(){
		return start.getName() + " -> " + end.getName();
	}
}
