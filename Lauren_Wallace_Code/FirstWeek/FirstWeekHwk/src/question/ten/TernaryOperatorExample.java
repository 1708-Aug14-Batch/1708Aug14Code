package question.ten;

public class TernaryOperatorExample {

	private static int min;

	public static void main(String[] args) {
		
		int value1 = 10;
		int value2 = 5;
		
		/*
		 * ternary operators take in three arguments:
		 * - a conditional statement 
		 * - a value to return if true
		 * - a value to return if false
		 * 
		 * A ternary operator is denoted with a ? followed by : to separate the return values
		 * They can be used to replace if statements
		 */
		min = (value1 < value2) ? value1 : value2;
		System.out.println("The minimum value of " + value1 + " & " + value2 + " is " + min);
		
		printTernaryResult(3, 14);
	}
	
	
	static void printTernaryResult(int v1, int v2) {
		min = (v1 < v2) ? v1 : v2;
		System.out.println("The minimum value of " + v1 + " & " + v2 + " is " + min);
		
	}

}
