package binpacking.linkedlists;

import binpacking.Item;

/**
 * This class represents a bin in a bin packing problem. It
 * uses a linked list approach to save the packed items.
 * @author Andreas Popp
 */
public class Bin {

	/**
	 * This parameter determines the capacity for every
	 * instance of this class.
	 */
	public static double capacity = -1;
	
	/**
	 * A linked list element, pointing to the first item
	 * packed into the bin.
	 */
	public LinkedListElement<Item> first;


	/**
	 * Calculates the remaining capacity of the bin given the
	 * currently packed items.
	 * @return the remaining capacity
	 */
	public double remainingCapacity(){
		double capacity = Bin.capacity;
		LinkedListElement<Item> current = first;
		while(current != null){
			capacity -= current.head.getWeight();
			current = current.tail;
		}
		return capacity;
	}
	
	/**
	 * Tries to pack the given item. If this violates the
	 * constraints of the model, the item will not be packed.
	 * @param item the item to be packed
	 * @return true if the item was successfully packed, 
	 * 		false otherwise.
	 */
	public boolean pack(Item item){
		//first check the remaining capacity
		if (item.getWeight() > remainingCapacity()){
			return false;
		}
		
		//pack the item as new first item
		first = new LinkedListElement<Item>(item, first);
		return true;
	}
	
	@Override
	public String toString(){
		String string = "";
		LinkedListElement<Item> current = first;
		while(current != null){
			string += " " + current.head.getName();
			current = current.tail;
		}
		return string;
	}	
}