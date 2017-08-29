package question10;

import java.util.Scanner;

/*
 * Q10. Find the minimum of two numbers using ternary operators.
 */

public class FindMin {

	// NOTE: These two variables are not used in FindMin.java
	// Rather they  are used in package question11 which has to access
	// two float variables found in another package
	public static float float1, float2;
	
	public static void main(String[] args) {

		try {
			// Take in two numbers from user input
			Scanner scan = new Scanner(System.in);

			System.out.println("Enter a number: ");
			String strA = scan.next();
			int numA = Integer.parseInt(strA);
			
			System.out.println("Enter another number: ");
			String strB = scan.next();
			int numB = Integer.parseInt(strB);

			// Ternary operators
			int result = findMin(numA, numB);

			if (result == -1)
				System.out.println(numA + " is smaller");
			else if (result == 1)
				System.out.println(numB + " is smaller");
			else System.out.println("The two numbers are the same");

			scan.close();
		} catch (NumberFormatException e) {
			System.out.println("Invalid input: That isn't a number");
		}

	}
	
	public static int findMin(int numA, int numB) {
		return (numA - numB) >= 0 ?
				(numA - numB) == 0 ?
						0 : 1 : -1;
	}

}
