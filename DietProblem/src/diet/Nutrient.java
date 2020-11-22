package diet;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a nutrition item in the diet problem
 * @author Andreas Popp
 */
public class Nutrient<F extends Food> {

	/**
	 * The nutrition item's name
	 */
	public final String name;
	
	/**
	 * The amount needed of this nutrition item
	 */
	public final double need;
	
	/**
	 * A list of all nutrition values for this nutrition item
	 */
	public final List<NutrientContent<F>> nutrientContents;
	
	/**
	 * This constructor sets the name and need values as given and 
	 * creates an empty array list for food items.
	 * @param name
	 * @param need
	 */
	public Nutrient(String name, double need) {
		this.name = name;
		this.need = need;
		this.nutrientContents = new ArrayList<NutrientContent<F>>();
	}
}
