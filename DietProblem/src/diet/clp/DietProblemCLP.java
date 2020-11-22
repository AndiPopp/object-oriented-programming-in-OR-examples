package diet.clp;

import com.quantego.clp.CLP;
import com.quantego.clp.CLPExpression;

import diet.DietProblem;
import diet.Nutrient;
import diet.NutrientContent;

/**
 * This class extends DietProblem to add all the structure
 * necessary to solve the problem with CLP.
 * @author Andreas Popp
 */
public class DietProblemCLP extends DietProblem<FoodCLP> {

	/**
	 * The CLP instance to solve this problem
	 */
	final CLP clp;
	
	/**
	 * Full parameter constructor
	 * @param foods
	 * @param nutrients
	 */
	public DietProblemCLP(FoodCLP[] foods, 
			Nutrient<FoodCLP>[] nutrients) {
		
		super(foods, nutrients);
		
		//build CLP
		this.clp = new CLP();
		
		//add variables
		for(FoodCLP food : this.foods){
			food.setClpVariable(clp);
		}
		
		//add constraints
		for(Nutrient<FoodCLP> nutrient : nutrients){
			buildConstraint(nutrient);
		}
	}
	
	/**
	 * Builds a single nutrition constraint
	 * @param nutrient the nutrition
	 */
	private void buildConstraint(Nutrient<FoodCLP> nutrient) {
		//create a new expression
		CLPExpression expression = this.clp.createExpression();
		//add the variables and coefficients to the expression
		for (NutrientContent<FoodCLP> nutrientContent 
				: nutrient.nutrientContents){
			
			FoodCLP food = nutrientContent.food;
			expression.add(nutrientContent.value, food.getClpVariable());
		}
		//add the right-hand side to finish the constraint
		expression.geq(nutrient.need);
	}
	
	/**
	 * Solve the problem
	 * @return the status of the solution
	 */
	public CLP.STATUS solve(){
		return this.clp.minimize();
	}
	
	/**
	 * @return a string representation of the solution
	 */
	public String solutionToString(){
		String result = "Objetive function: " 
				+ this.clp.getObjectiveValue();
		
		for (FoodCLP food : this.foods){
			result += "\n" + food.name + ": " 
					+ food.getClpVariable().getSolution();
		}
		
		return result;
	}
}
