package diet.clp;

import com.quantego.clp.CLP;
import com.quantego.clp.CLPVariable;

import diet.Food;

/**
 * This class adds CLP structure to the class Food
 * @author Andreas Popp
 */
public class FoodCLP extends Food {

	/**
	 * Full parameter constructor
	 * @param name
	 * @param cost
	 */
	public FoodCLP(String name, double cost) {
		super(name, cost);
	}
	
	/**
	 * The CLP variable associated with this object
	 */
	private CLPVariable clpVariable;

	/**
	 * Setter for the CLP variable, adds a new variable to
	 * the given CLP object.
	 * @param clp
	 */
	public void setClpVariable(CLP clp) {
		this.clpVariable = clp.addVariable();
		this.clpVariable.name(this.name);
		this.clpVariable.obj(this.cost);
	}

	/**
	 * Getter for the CLP variable
	 * @return the CLP variable
	 */
	public CLPVariable getClpVariable() {
		return clpVariable;
	}
}
