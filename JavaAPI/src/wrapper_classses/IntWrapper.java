package wrapper_classses;

/**
 * This package is a simple self coded example
 * of a wrapper class for an int value.
 * @author Andreas Popp
 */
public class IntWrapper {

	/**
	 * The wrapped int value
	 */
	public int value;
	
	/**
	 * A constructor setting the int value
	 * @param value the value to be set
	 */
	public IntWrapper(int value) {
		this.value = value;
	}

	/**
	 * Application example
	 * @param args command line parameters (unused)
	 */
	public static void main(String[] args) {
		IntWrapper a = new IntWrapper(5);
		int b = a.value + 2;
		System.out.println(b);
	}
}
