package exceptions;

/**
 * This class has a simple example method throwing an exception.
 * @author Andreas Popp
 */
public class ThrowExample {

	/**
	 * This method throws an exception for negative values
	 * @param a the value to be checked
	 * @throws ValueIsNegativeException if a is negative
	 */
	public static void onylAcceptPositive(int a) 
			throws ValueIsNegativeException{
		
		if (a < 0) throw new ValueIsNegativeException(a);
	}
}
