package binpacking.linkedlists;

import binpacking.Item;

/**
 * A class which contains static methods implementing
 * the fit heuristics for the bin packimg problem.
 * @author Andreas Popp
 */
public class FitHeuristics {

	/**
	 * solving the example problem
	 * @param args command line parameters (unused)
	 */
	public static void main(String[] args) {
		//set bin capacity
		Bin.capacity = 12;
		
		//create example items
		Item[] items = new Item[8];
		items[0] = new Item("A", 7.5);
		items[1] = new Item("B", 6.8);
		items[2] = new Item("C", 9.3);
		items[3] = new Item("D", 1.2);
		items[4] = new Item("E", 2.4);
		items[5] = new Item("F", 8.5);
		items[6] = new Item("G", 3.9);
		items[7] = new Item("H", 5.1);
		
		//next fit heuristic
		System.out.println("Result of Next-fit:");
		System.out.println("-------------------");
		nextFit(items).print("Bin");
		System.out.println(); //print empty line
		
		//first fit heuristic
		System.out.println("Result of First-fit:");
		System.out.println("--------------------");
		firstFit(items).print("Bin");
		System.out.println();  //print empty line
		
		//first fit heuristic
		System.out.println("Result of First-fit-decreasing:");
		System.out.println("-------------------------------");
		firstFitDecreasing(items).print("Bin");;
		System.out.println();  //print empty line
	}

	/**
	 * The next fit heuristic
	 * @param items the items to be packed
	 * @return the first element of the linked list 
	 * 	containing the packed bins
	 */
	public static LinkedListElement<Bin> nextFit(Item[] items){
		//create the first bin and a marker for the last
		LinkedListElement<Bin> first = new LinkedListElement<Bin>();
		first.head = new Bin();
		LinkedListElement<Bin> last = first;
		
		//go through the items
		for (Item item : items){
			if (!last.head.pack(item)){
				last.tail = new LinkedListElement<Bin>();
				last = last.tail;
				last.head = new Bin();
				last.head.pack(item);
			}
		}
		
		//all items are packed
		return first;
	}
	
	/**
	 * the first fit heuristic
	 * @param items the items to be packed
	 * @return the first element of the linked list 
	 * 	containing the packed bins
	 */
	public static LinkedListElement<Bin> firstFit(Item[] items){
		//create the first bin and a marker for the last
		LinkedListElement<Bin> first = new LinkedListElement<Bin>();
		first.head = new Bin();
		LinkedListElement<Bin> last = first;
		
		//go through the items
		for (Item item : items){
			//go through the bins
			LinkedListElement<Bin> current = first;
			while(!current.head.pack(item)){
				current = current.tail;
				//check if we need to open a new bin
				if (current == null){
					current = new LinkedListElement<Bin>();
					current.head = new Bin();
					last.tail = current;
					last = current;
				}
			}
			
		}
		
		//all items are packed
		return first;
	}	
	
	/**
	 * selection sort for FFD
	 * @param items the items to be packed
	 * @return the item array sorted in descending order
	 * 	of weight
	 */
	private static Item[] sortDescending(Item[] items){
		
		//deep copy the array
		Item[] sorted = new Item[items.length];
		for(int i = 0; i < items.length; i++){
			sorted[i] = items[i];
		}
		
		//selection sort
		for(int i = 0; i < sorted.length; i++){
			//find the item with the highest weight in the remaining array 
			int highest = i;
			for (int j = i+1; j < sorted.length; j++){
				if (sorted[j].getWeight() > sorted[highest].getWeight()){
					highest = j;
				}
			}
			
			//swap with item at position i
			Item swap = sorted[highest];
			sorted[highest] = sorted[i];
			sorted[i] = swap;	
		}
		
		//array is sorted
		return sorted;
	}

	/**
	 * the first fit decreasing heuristic
	 * @param items the items to be packed
	 * @return the first element of the linked list 
	 * 	containing the packed bins
	 */
	public static LinkedListElement<Bin> firstFitDecreasing(
			Item[] items){
		
		return firstFit(sortDescending(items));
	}
}
