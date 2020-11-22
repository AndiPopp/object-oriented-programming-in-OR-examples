package graphs.weighted;

import graphs.*;

/**
 * A class representing a graph with weighted edges
 * @author Andreas Popp
 */
public class WeightedGraph extends Graph<WeightedEdge> {

	/**
	 * Constructor setting all fields
	 * @param nodes the nodes
	 * @param edges the edges
	 */
	public WeightedGraph(Node<WeightedEdge>[] nodes, 
			WeightedEdge[] edges) {
		
		super(nodes, edges);
	}
}
