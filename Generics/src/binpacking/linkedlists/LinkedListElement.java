package binpacking.linkedlists;

/**
 * A generic linked list element
 * @author Andreas Popp
 * @param <E> the data type of the stored element
 */
public class LinkedListElement<E> {

	/**
	 * the item element
	 */
	public E head;
	
	/**
	 * the next element in the list
	 */
	public LinkedListElement<E> tail;
	
	/**
	 * Constructor with parameters
	 * @param head the object for the new element
	 * @param tail the element next in list
	 */
	public LinkedListElement(E head, LinkedListElement<E> tail) {
		this.head = head;
		this.tail = tail;
	}
	
	/**
	 * empty constructor
	 */
	public LinkedListElement(){}
	
	/**
	 * print content to console
	 * @param prefix the prefix to be print befor the content
	 */
	public void print(String prefix){
		int i = 1;
		LinkedListElement<E> current = this;
		while(current != null){
			System.out.print(prefix + " " + i +":");
			System.out.println(current.head.toString());
			//next bin
			current = current.tail;
			i++;
		}
	}
}
