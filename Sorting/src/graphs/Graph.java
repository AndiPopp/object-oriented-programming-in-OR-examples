package graphs;

import java.util.ArrayList;

/**
 * A graph, i.e. a set of nodes which are interconnect
 * by a set of edges.
 * @author Andreas Popp
 * @param <E> The type of edges this graph contains
 */
public class Graph<E extends Edge> {

	/**
	 * the graph's nodes
	 */
	protected Node<E>[] nodes;
	
	/**
	 * the graphs edges
	 */
	protected E[] edges;
	
	/**
	 * constructor setting both fields
	 * @param nodes value for {@link #nodes}
	 * @param edges value for {@link #edges}
	 */
	public Graph(Node<E>[] nodes, E[] edges) {
		this.nodes = nodes;
		this.edges = edges;
		setEdges();
	}
	
	/**
	 * getter for {@link #nodes}
	 * @return the content of field {@link #nodes}
	 */
	public Node<E>[] getNodes() {
		return nodes;
	}

	/**
	 * getter for {@link #edges}
	 * @return the content of field {@link #edges}
	 */
	public E[] getEdges() {
		return edges;
	}

	/**
	 * convenience function to link the edges to the nodes
	 */
	public void setEdges(){
		for(Node<E> node : nodes){
			setNodeEdges(node, edges);
		}
	}
	
	/**
	 * checks for edges inbound to or outbound from a node
	 * and add them to the node's fields
	 * @param node the node to be configured
	 * @param edges the set of edges
	 */
	void setNodeEdges(Node<E> node, E[] edges){
		//count the edges
		int countInbound = 0;
		int countOutbound = 0;
		for (E edge : edges){
			if (edge.start == node){
				countOutbound++;
			}
			if (edge.end == node){
				countInbound++;
			}
		}
		
		//create the array lists
		node.inboud = new ArrayList<E>(countInbound);
		node.outbound = new ArrayList<E>(countOutbound);
		
		//fill the arrays
		for (E edge : edges){
			if (edge.start == node){
				node.outbound.add(edge);
			}
			if (edge.end == node){
				node.inboud.add(edge);
			}
		}
	}
}
