package question15;

/*
 * Hard code two operands in a test class having a main method that
 * calls the implementing class.
 */

public class Driver {
	
	public static void main(String[] args) {
		
		// Create two numbers for calculations
		int a = 357;
		int b = 294;
		
		// Perform and print calculations
		Calculator calc = new Calculator();
		System.out.println("Addition: " + calc.addition(a, b));
		System.out.println("Subtraction: " + calc.subtraction(a, b));
		System.out.println("Multiplication: " + calc.multiplication(a, b));
		System.out.println("Division: " + calc.division(a, b));
		
	}

}
