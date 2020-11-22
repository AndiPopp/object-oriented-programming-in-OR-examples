package binpacking.collections;

import java.util.*;
import binpacking.*;

/**
 * This class represents a bin in a bin packing problem. It
 * uses Java's native collection classes.
 * @author Andreas Popp
 */
public class Bin {

	/**
	 * This parameter determines the capacity for every
	 * instance of this class.
	 */
	public static double capacity = -1;
	
	/**
	 * A linked list containing the items
	 */
	public LinkedList<Item> items;

	/**
	 * Construct an empty bin
	 */
	public Bin() {
		this.items = new LinkedList<Item>();
	}

	/**
	 * Calculates the remaining capacity of the bin given the
	 * currently packed items.
	 * @return the remaining capacity
	 */
	public double remainingCapacity(){
		double capacity = Bin.capacity;
		for(Iterator<Item> it = items.iterator(); it.hasNext();){
			capacity -= it.next().getWeight();
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
		
		//pack the item
		items.add(item);
		return true;
	}
	
	@Override
	public String toString(){
		String string = "";
		for(Item item : items){
			string += " " + item.getName();
		}
		return string;
	}	
}