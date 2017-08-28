package question6;

import java.util.Scanner;

/*
 * Q6. Write a program to determine if an integer is even without using the
 * modulus operator (%)
 */

public class EvenDeterminer {

	public static void main(String[] args) {
		System.out.println("Enter a number");

		Scanner scan = new Scanner(System.in);

		try {
			String numString = scan.next();

			int num = Integer.parseInt(numString);

			if (determineEvenValue(num))
				System.out.println("That number is even");
			else System.out.println("That number is odd");

		} 
		catch (NumberFormatException e) {
			System.out.println("That is not a number");
		}

		scan.close();

	}
	
	/* 
	 * This takes advantage of integer division
	 * An odd number will be divided by two and truncated
	 * before being multiplied again by two
	 */
	public static boolean determineEvenValue(int num) {
		
		int dividedNum = num / 2 * 2;
		
		if (dividedNum == num)
			return true;
		else return false;
	}
}