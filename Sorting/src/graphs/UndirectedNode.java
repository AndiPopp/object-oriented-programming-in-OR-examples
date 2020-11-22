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
	 * An array combining inbound and outbound
	 */
	private ArrayList<E> neighbors;
	
	/**
	 * constructor setting the node's name
	 * @param name the node's name
	 */
	public UndirectedNode(String name) {
		super(name);
	}
	
	/**
	 * method to populate {@link #neighbors}
	 */
	private void fillNeighbors(){
		int size = getInboud().size()+getOutbound().size();
		neighbors = new ArrayList<E>(size);
		for(E edge : getInboud()){
			neighbors.add(edge);
		}
		for(E edge : getOutbound()){
			neighbors.add(edge);
		}
	}
	
	/**
	 * getter for {@link #neighbors}
	 * @return the content of the field {@link #neighbors}
	 */
	public ArrayList<E> getNeighbors() {
		if (neighbors == null) {
			fillNeighbors();
		}
		return neighbors;
	}
}
