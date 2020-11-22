package binpacking;

/**
 * This class represents an item in a bin packing problem
 * @author Andreas Popp
 */
public class Item {

	/**
	 * The minimal weight of an item accepted
	 * by the constructor
	 */
	private static double minWeight = 0.0;
	
	/**
	 * The item's name
	 */
	private String name;
	
	/**
	*the item's weight
	*/
	private double weight;
	
	/**
	 * A constructor which sets both fields. It also enforces
	 * the minimum weight parameter.
	 * @param name the name of the new item
	 * @param weight the weight of the new item
	 */
	public Item(String name, double weight) {
		this.name = name;
		if (weight < minWeight){
			this.weight = minWeight;
		}else{
			this.weight = weight;
		}
	}

	/**
	 * Getter for the field {@link #name}
	 * @return the value of the field {@link #name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for the field {@link #weight}
	 * @return the value of the field {@link #weight}
	 */
	public double getWeight() {
		return weight;
	}
}
