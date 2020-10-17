package binpacking.linkedlists;

import binpacking.Item;

public class ItemElement {
	
	//the item element
	public Item head;
	
	//the next element in the list
	public ItemElement tail;

	//constructor
	public ItemElement(Item head, ItemElement tail) {
		this.head = head;
		this.tail = tail;
	}
}
