package user_input;

import javax.swing.JOptionPane;

/**
 * This class has a main method, which simply
 * echoes a user input.
 * @author Andreas Popp
 */
public class EchoExample {

	public static void main(String[] args) {
		String userInput = JOptionPane.showInputDialog(
				"Please enter a String");
		System.out.println(userInput);
	}

}
