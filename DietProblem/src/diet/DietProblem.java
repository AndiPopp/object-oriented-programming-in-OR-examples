package diet;

/**
 * This class represents a complete diet problem
 * @author Andreas Popp
 */
public class DietProblem<F extends Food> {
	
	/**
	 * The set of food items
	 */
	public final F[] foods;
	
	/**
	 * The set of nutrition items
	 */
	final Nutrient<F>[] nutritions;
	
	/**
	 * Full parameter constructor. 
	 * @param foods
	 * @param nutritions
	 */
	public DietProblem(F[] foods, Nutrient<F>[] nutritions) {
		//fill fields
		this.foods = foods;
		this.nutritions = nutritions;
	}
}
