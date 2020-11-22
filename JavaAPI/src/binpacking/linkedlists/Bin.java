package binpacking.linkedlists;

import javax.swing.JOptionPane;

import binpacking.Item;

public class Bin {

	//the capacity of all bins
	public static double capacity = -1;
	
	//the list of items in this bin
	public ItemElement first;

	//calculate the remaining capacity
	public double remainingCapacity(){
		double capacity = Bin.capacity;
		ItemElement current = first;
		while(current != null){
			capacity -= current.head.getWeight();
			current = current.tail;
		}
		return capacity;
	}
	
	//try to pack an item, return true if it was
	//packed, false otherwise
	public boolean pack(Item item){
		//first check the remaining capacity
		if (item.getWeight() > remainingCapacity()){
			return false;
		}
		
		//pack the item as new first item
		first = new ItemElement(item, first);
		return true;
	}
	
	//to string
	public String toString(){
		String string = "";
		ItemElement current = first;
		while(current != null){
			string += " " + current.head.getName();
			current = current.tail;
		}
		return string;
	}	
	
	//read the capacity from user input
	public static void readCapacity(){
		while (capacity < 0){
			String userInput = JOptionPane.showInputDialog(
					"Please enter the bin capacity:");
			try{
				capacity = Double.valueOf(userInput);
			}catch(NumberFormatException ex){
				System.out.println("Parsing failed "
						+ ex.getMessage());
			}
		}
	}
}