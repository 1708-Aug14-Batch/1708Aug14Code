package question10;

import java.util.Scanner;

/**
 * Find the minimum of two numbers using ternary operators.
 *
 * @author Josh Wurdemann
 * @version 8/19/2017
 */
public class TernaryOperators {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a number");
		int a = scan.nextInt();
		System.out.println("Enter a second number");
		int b = scan.nextInt();
		int minimum = (a < b) ? a : b;
		
		System.out.println(minimum);
		
		scan.close();
	}
}
