package Q15;

public class Calculator {
	// Write a program that defines an interface having the following methods: 
	// addition, subtraction, multiplication, and division. 
	// Create a class that implements this interface and provides appropriate functionality
	// to carry out the required operations. Hard code two operands in a test class having
	// a main method that calls the implementing class.
	
	public static void main(String[] args) {
		int x = 200;
		int y = 15;
		
		TestClass tc = new TestClass();
		System.out.println(tc.addition(x, y));
		System.out.println(tc.subtraction(x, y));
		System.out.println(tc.multiplication(x, y));
		System.out.println(tc.division(x, y));

	}

}
