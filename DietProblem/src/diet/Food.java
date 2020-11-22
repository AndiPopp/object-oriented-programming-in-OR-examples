package diet;

/**
 * This class represents a type of food in the diet problem
 * @author Andreas Popp
 */
public class Food {

	/**
	 * The food's name
	 */
	public final String name;
	
	/**
	 * The food's cost
	 */
	public final double cost;

	/**
	 * Full parameter constructor
	 * @param name
	 * @param cost
	 */
	public Food(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}
}
