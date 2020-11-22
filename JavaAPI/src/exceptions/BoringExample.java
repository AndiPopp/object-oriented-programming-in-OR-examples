package exceptions;

/**
 * This class is only a boring example to illustrate
 * the method stack. Because it is so boring, it has
 * no further documentation.
 * @author Andreas Popp
 */
public class BoringExample {

	public static void main(String[] args) {
		System.out.println("Method main start");
		myMethodA();
		myMethodB();
		System.out.println("Method main end");
	}
	
	private static void myMethodA(){
		System.out.println("Method A");
	}
	
	private static void myMethodB(){
		System.out.println("Method B start");
		myMethodC();
		System.out.println("Method B end");
	}
	
	private static void myMethodC(){
		System.out.println("Method C");
	}
}
