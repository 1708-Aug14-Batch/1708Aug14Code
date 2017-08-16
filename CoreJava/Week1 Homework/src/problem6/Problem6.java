package problem6;

import java.util.Scanner;

public class Problem6 {
	//Q6. Write a program to determine if 
	//an integer is even without using the modulus operator (%)

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// User input
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Number");
		
		int input = scan.nextInt();
		
		// Divides by 2 and multiples by 2, if they are equal then it is even
		// because the int has to be a integer so it will be rounded down automatically if odd.
		
		if((input / 2 * 2) == input) {
			System.out.println("Even");
		}
		else {
			System.out.println("Odd");
		}
	}

}
