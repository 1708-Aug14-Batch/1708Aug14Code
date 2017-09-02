package question12;

/*
 * Q12. Write a program to store numbers from 1 to 100 in an array.
 * Print out all the even numbers from the array. Use the enhanced
 * FOR loop for printing out the numbers.
 */

public class EvenPrinter {
	
	public static void main(String[] args) {
		
		// Create a list of numbers 1 to 100 inclusive
		int[] numbers = new int[101];
		for (int i = 0; i <=100; i++)
			numbers[i] = i;
		
		// Print out even numbers
		for (int num : numbers)
			if (num % 2 == 0)
				System.out.print(num + ", ");
		System.out.println();
	}

}