package diet.examples;

import com.quantego.clp.CLP;

import diet.Nutrient;
import diet.NutrientContent;
import diet.clp.DietProblemCLP;
import diet.clp.FoodCLP;

/**
 * Example of (Popp 2016), page 15
 * @author Andreas Popp
 */
public class DietProblemExample {

	/**
	 * Entry point method
	 * @param args (unused)
	 */
	public static void main(String[] args){
		
		DietProblemCLP p = buildExample();
		if (p.solve() == CLP.STATUS.OPTIMAL){
			System.out.println(p.solutionToString());
		}
	}
	
	/**
	 * Creates the objects associated with the date
	 * @return the newly created problem object
	 */
	public static DietProblemCLP buildExample(){
		//Food items
		FoodCLP[] foods = new FoodCLP[4];
		foods[0] = new FoodCLP("corn", 80);
		foods[1] = new FoodCLP("sauerkraut", 180);
		foods[2] = new FoodCLP("beans", 50);
		foods[3] = new FoodCLP("milk", 170);
		
		//Nutrition items
		Nutrient<FoodCLP>[] nutrients = new Nutrient[4];
		nutrients[0] = new Nutrient<FoodCLP>("water", 500);
		nutrients[1] = new Nutrient<FoodCLP>("calories", 1.4);
		nutrients[2] = new Nutrient<FoodCLP>("protein", 40);
		nutrients[3] = new Nutrient<FoodCLP>("vitamin C", 10);
		
		//Nutrition values. Creating a nutrition value will 
		//automatically link it to the food and nutrition objects.
		new NutrientContent<FoodCLP>(foods[0], nutrients[0], 130);
		new NutrientContent<FoodCLP>(foods[1], nutrients[0], 890);
		new NutrientContent<FoodCLP>(foods[2], nutrients[0], 773);
		new NutrientContent<FoodCLP>(foods[3], nutrients[0], 875);
		
		new NutrientContent<FoodCLP>(foods[0], nutrients[1], 3.3);
		new NutrientContent<FoodCLP>(foods[1], nutrients[1], .11);
		new NutrientContent<FoodCLP>(foods[2], nutrients[1], .63);
		new NutrientContent<FoodCLP>(foods[3], nutrients[1], .64);
		
		new NutrientContent<FoodCLP>(foods[0], nutrients[2], 85.4);
		new NutrientContent<FoodCLP>(foods[1], nutrients[2], 10.0);
		new NutrientContent<FoodCLP>(foods[2], nutrients[2], 55.0);
		new NutrientContent<FoodCLP>(foods[3], nutrients[2], 33.0);
		
		new NutrientContent<FoodCLP>(foods[1], nutrients[3], 0.20);
		new NutrientContent<FoodCLP>(foods[2], nutrients[3], 0.05);
		new NutrientContent<FoodCLP>(foods[3], nutrients[3], 0.17);
		
		//return the problem
		return new DietProblemCLP(foods, nutrients);
	}
}
