package graphs;

import java.util.ArrayList;

/**
 * A special type of node, which contains a list not 
 * distinguishing inbound and outbound edges.
 * @author Andreas Popp
 * @param <E> the type of edges connected to this node
 */
public class UndirectedNode<E extends Edge> extends Node<E> {
	
	/**
	 * constructor setting the node's name
	 * @param name the node's name
	 */
	public UndirectedNode(String name) {
		super(name);
	}
	
	/**
	 * create neighbors
	 * @return edges connected to the neighbors
	 */
	public ArrayList<E> getNeighbors() {
		int size = getInboud().size()+getOutbound().size();
		ArrayList<E> neighbors = new ArrayList<E>(size);
		for(E edge : getInboud()){
			neighbors.add(edge);
		}
		for(E edge : getOutbound()){
			neighbors.add(edge);
		}
		return neighbors;
	}
}
