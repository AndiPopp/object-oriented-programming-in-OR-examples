package exceptions;

/**
 * This class only contains a main method to call
 * ThrowExample.
 * @author Andreas Popp
 */
public class ThrowExampleCall {

	public static void main(String[] args) 
			throws ValueIsNegativeException {
		
		ThrowExample.onylAcceptPositive(-1);
	}
}
