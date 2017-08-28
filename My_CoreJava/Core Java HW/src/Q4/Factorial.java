package Q4;

import java.math.BigInteger;

public class Factorial {
	
	/**
	 * Calculate n factorial
	 * @param n Must be non-negative
	 * @return n!
	 */
	public static BigInteger factorial(int n) throws IllegalArgumentException {
		// Argument must be positive and non-zero
		if (n < 0) throw new IllegalArgumentException("Argument must be non-negative.");
		// Base case
		if (n == 0) return BigInteger.ONE;
		// Recursively find factorial by multiplying
		return factorial(n-1).multiply(new BigInteger(Integer.toString(n)));
	}
	
	public static void main(String[] args) {
		
		System.out.println(factorial(1676));
	}

}
