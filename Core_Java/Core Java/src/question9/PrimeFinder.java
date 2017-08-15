package question9;

import java.util.ArrayList;

/*
 * Q9. Create an ArrayList which stores numbers from 1 to 100 and prints
 * out all the prime numbers to the console
 */

public class PrimeFinder {
	
	public static void main(String[] args) {
		
		// List of numbers from 1 to 100 inclusive
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i <= 100; i++)
			numbers.add(i);
		
		// Prints out prime numbers
		for (int num : numbers)
			if (isPrime(num))
				System.out.println(num);
		
	}

	/*
	 * A prime number's only factors are itself and 1
	 * So this method skips those two values and looks for
	 * any remaining factors
	 */
	public static boolean isPrime(int num) {
		
		if (num <= 1)
			return false;
		
		for (int i = 2; i < num; i++)
			if (num % i == 0)
				return false;
		
		return true;
	}

}
