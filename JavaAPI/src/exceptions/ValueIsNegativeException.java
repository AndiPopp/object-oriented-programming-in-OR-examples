package exceptions;

/**
 * This exception states that a numerical value is negative
 * @author Andreas Popp
 */
public class ValueIsNegativeException extends Exception {

	/**
	 * The value that is "exceptionally" negative
	 */
	Number value;

	/**
	 * Construct a new object with the given value
	 * @param value the "exceptionally" negative value
	 */
	public ValueIsNegativeException(Number value) {
		this.value = value;
	}
}
