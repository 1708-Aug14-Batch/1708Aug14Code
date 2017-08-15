package question10;

import java.util.Scanner;

/*
 * Q10. Find the minimum of two numbers using ternary operators.
 */

public class FindMin {

	public static void main(String[] args) {

		try {
			Scanner scan = new Scanner(System.in);

			System.out.println("Enter a number: ");
			String strA = scan.next();
			int numA = Integer.parseInt(strA);
			
			System.out.println("Enter a number with a different value: ");
			String strB = scan.next();
			int numB = Integer.parseInt(strB);

			if (numA == numB) {
				System.out.println("Invalid input: The two numbers are the same");
				return;
			}

			int result = (numA < numB)? -1 : 1;

			if (result == -1)
				System.out.println(numA + " is smaller");
			else System.out.println(numB + " is smaller");

			scan.close();
		} catch (NumberFormatException e) {
			System.out.println("Invalid input: That isn't a number");
		}

	}

}
