package Q4;

import java.math.BigInteger;

public class Factorial {
	
	private static BigInteger doFactorial(BigInteger fac, int n) {
		// Base case
		if (n == 0) return fac;
		// Recursively find factorial by multiplying
		return doFactorial(fac.multiply(BigInteger.valueOf(n)), n-1);
	}
	
	/**
	 * Calculate n factorial
	 * @param n 
	 * @return n!
	 */
	public static BigInteger factorial(int n) {
		return doFactorial(BigInteger.ONE, n);
	}
	
	public static void main(String[] args) {
		
		System.out.println(factorial(50));
	}

}