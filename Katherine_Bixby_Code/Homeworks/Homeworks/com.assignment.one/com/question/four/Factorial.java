package com.question.four;

/**
 * Gets the factorial of a given number
 * @author Katie
 *
 */
public class Factorial {

	/**
	 * Calculating the factorial
	 * @param n
	 * 		Number to get factorial of
	 * @return
	 * 		The factorial
	 */
	public static int factorial(int n) {
		if (n==0) {
			return 1;
		}
		else {
			return n * factorial(n-1);
		}
	}
}
