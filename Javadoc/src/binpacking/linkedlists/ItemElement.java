package binpacking.linkedlists;

import binpacking.Item;

/**
 * A linked list element representing an item
 * @author Andreas Popp
 */
public class ItemElement {
	
	/**
	 * the item element
	 */
	public Item head;
	
	/**
	 * the next element in the list
	 */
	public ItemElement tail;

	/**
	 * constructor
	 * @param head the {@link Item} object for the new element
	 * @param tail the element next in list
	 */
	public ItemElement(Item head, ItemElement tail) {
		this.head = head;
		this.tail = tail;
	}
}
