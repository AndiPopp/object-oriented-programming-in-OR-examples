package binpacking;

import sorting.Sortable;

public class Item implements Sortable {

	//the minimum weight
	private static double minWeight = 0.0;
	
	//the item's name
	private String name;
	
	//the item's weight
	private double weight;
	
	//constructor
	public Item(String name, double weight) {
		this.name = name;
		if (weight < minWeight){
			this.weight = minWeight;
		}else{
			this.weight = weight;
		}
	}

	//getters for private fields
	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public double sortValue() {
		return weight;
	}
}
