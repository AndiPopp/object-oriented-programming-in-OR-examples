package binpacking.arrays;

import binpacking.Item;

public class Bin {

	//the capacity of all bins
	public static double capacity = -1;
	
	//the list of items in this bin
	public Item[] items;

	//construct an empty bin
	public Bin(int maxItems) {
		this.items = new Item[maxItems];
	}
	
	//calculate the remaining capacity
	public double remainingCapacity(){
		double capacity = Bin.capacity;
		for(Item item : items){
			if (item != null){
				capacity -= item.getWeight();
			}
		}
		return capacity;
	}
	
	//try to pack an item, return true if it was
	//packed, false otherwise
	public boolean pack(Item item){
		//first check the remaining capacity
		if (item.getWeight() > remainingCapacity()){
			//immediately return false
			return false;
		}
		
		//check for an empty place in the array
		for(int i = 0; i < items.length; i++){
			if (items[i] == null){
				items[i] = item;
				return true;
			}
		}
		
		//could not find an empty place
		return false;
	}
	
	//to string
	public String toString(){
		String string = "";
		for(Item item : items){
			if (item != null){
				string += " " + item.getName();
			}
		}
		return string;
	}	
}
