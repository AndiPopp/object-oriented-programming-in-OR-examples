package diet;

/**
 * This class represents the value of a specific nutrition item in 
 * a specific food item. It can be parameterized to understand the
 * sub type of Food used in the solution approach.
 * @author Andreas Popp
 */
public class NutrientContent<F extends Food> {

	/**
	 * The food item, which contains the nutrient
	 */
	public final F food;
	
	/**
	 * The nutrient contained in the food
	 */
	public final Nutrient<F> nutrient;
	
	/**
	 * The amount of nutrient per quantity of food
	 */
	public final double value;

	/**
	 * Full parameter constructor. Fills the fields according to the
	 * arguments and add the created object to the nutrition values 
	 * list in the nutrient objects.
	 * @param food
	 * @param nutrient
	 * @param value
	 */
	public NutrientContent(F food, Nutrient<F> nutrient, 
			double value) {
		this.food = food;
		this.nutrient = nutrient;
		this.value = value;
		this.nutrient.nutrientContents.add(this);
	}
}
