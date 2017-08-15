package question4;

import java.util.Scanner;

/*
 * Q4. Write a program to compute N factorial.
 */

public class ComputeFactorial {

	public static void main(String[] args) {
		
		// A scanner to scan the standard input
		Scanner scan = new Scanner(System.in);
		
		// Prompt the user for a number to be used to compute N factorial
		System.out.println("Enter a positive number to be factorialized: ");
		String str = scan.next();

		// Try to cast the input to an integer
		try {
			
			int N = Integer.parseInt(str);

			if (N >= 0)
				System.out.println(computeFactorial(N));
			else System.out.println("Negative numbers are invalid input");

		} catch (NumberFormatException e) {
			System.out.println("That is not a number");
		}

		// Close resources to free up memory
		scan.close();
		
	}

	// Return the factorial of int factorial
	private static int computeFactorial(int factorial) {
		
		// Default value is 1 since multiplication by 1 makes no change
		int runningTotal = 1;
		
		// Compute factorial with one multiplication at a  time
		while (factorial > 1) {
			runningTotal = runningTotal * factorial;
			
			factorial--;
		}
		
		return runningTotal;
	}
}
