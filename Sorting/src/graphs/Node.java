package graphs;

import java.util.ArrayList;

/**
 * A node, i.e. a single element of a graph
 * @author Andreas Popp
 * @param <E> the type of edges this node connects to
 */
public class Node<E extends Edge> {

	/**
	 * the node's name
	 */
	private String name;
	
	/**
	 * the edges connecting to this node
	 */
	ArrayList<E> inboud;
	ArrayList<E> outbound;
	
	/**
	 * standard constructor
	 * @param name the value for field {@link #name}
	 */
	public Node(String name) {
		this.name = name;
	}

	/**
	 * Getter for {@link #name}
	 * @return the value of field {@link #name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for {@link #inboud}
	 * @return the value of field {@link #inboud}
	 */
	public ArrayList<E> getInboud() {
		return inboud;
	}

	/**
	 * Getter for {@link #outbound}
	 * @return the value of field {@link #outbound}
	 */
	public ArrayList<E> getOutbound() {
		return outbound;
	}

}
