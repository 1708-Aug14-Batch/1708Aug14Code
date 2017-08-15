package question19;

import java.util.ArrayList;
import question9.*;

/*
 * Q19. Create an ArrayList and insert integers 1 through 10. Display
 * the ArrayList. Add all the even numbers up and display the result.
 * Add all the odd numbers up and display the result. Remove the prime
 * numbers from the ArrayList and print out the remaining ArrayList.
 */

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		// Create and display the list
		for (int i = 0; i <= 10; i++)
			numbers.add(i);
		System.out.println("List of numbers: " + numbers);

		// Add the even numbers and display result
		int result = 0;
		for (int num : numbers)
			if (num % 2 == 0)
				result += num;
		System.out.println("Total of even numbers: " + result);

		// Add the odd numbers and display result
		result = 0;
		for (int num : numbers)
			if (num % 2 == 1)
				result += num;
		System.out.println("Total of even numbers: " + result);
		
		// Remove prime numbers and display result
		ArrayList<Integer> numsToRemove = new ArrayList<Integer>();
		for (int num : numbers)
			if (PrimeFinder.isPrime(num))
				numsToRemove.add(num);
		numbers.removeAll(numsToRemove);
		System.out.println("List of non-prime numbers: " + numbers);
	}
	
	

}
