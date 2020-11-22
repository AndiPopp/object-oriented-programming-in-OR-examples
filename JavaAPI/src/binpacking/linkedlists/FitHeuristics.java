package binpacking.linkedlists;

import binpacking.Item;

public class FitHeuristics {

	//solving the example problem
	public static void main(String[] args) {
		//let the use input the bin capacity
		//check that the largest item fits
		while (Bin.capacity < 9.3){
			Bin.capacity = -1;
			Bin.readCapacity();
		}	
		
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
		nextFit(items).print();
		System.out.println(); //print empty line
		
		//first fit heuristic
		System.out.println("Result of First-fit:");
		System.out.println("--------------------");
		firstFit(items).print();
		System.out.println();  //print empty line
		
		//first fit heuristic
		System.out.println("Result of First-fit-decreasing:");
		System.out.println("-------------------------------");
		firstFitDecreasing(items).print();;
		System.out.println();  //print empty line
	}
	
	//The next fit heuristic
	public static BinElement nextFit(Item[] items){
		//create the first bin and a marker for the last
		BinElement first = new BinElement();
		BinElement last = first;
		
		//go through the items
		for (Item item : items){
			if (!last.head.pack(item)){
				last.tail = new BinElement();
				last = last.tail;
				last.head.pack(item);
			}
		}
		
		//all items are packed
		return first;
	}
	
	//the first fit heuristic
	public static BinElement firstFit(Item[] items){
		//create the first bin and a marker for the last
		BinElement first = new BinElement();
		BinElement last = first;
		
		//go through the items
		for (Item item : items){
			//go through the bins
			BinElement current = first;
			while(!current.head.pack(item)){
				current = current.tail;
				//check if we need to open a new bin
				if (current == null){
					current = new BinElement();
					last.tail = current;
					last = current;
				}
			}
			
		}
		
		//all items are packed
		return first;
	}	
	
	//selection sort for FFD
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

	//the first fit decreasing heuristic
	public static BinElement firstFitDecreasing(Item[] items){
		return firstFit(sortDescending(items));
	}
}
