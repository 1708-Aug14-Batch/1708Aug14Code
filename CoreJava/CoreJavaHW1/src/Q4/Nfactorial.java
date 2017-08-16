package Q4;

import java.util.Scanner;

public class Nfactorial {

	public static void main(String[] args) {
	// Factorial of n is the product of all positive descending integers
		int input;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Enter a number below 20");
			input = scan.nextInt();
		} while(input >= 20);
		computeFactorial(input);
	} 
	
	public static void computeFactorial(int num) {
		int fact = 1;  
		for(int i = 1; i <= num; i++) {    
			fact *= i;    
		}    
		System.out.println("Factorial of " + num + " is: " + fact);    
	}

	// for purposes of JUnit test
	public int computeFactorial2(int num) {
		int fact = 1;  
		for(int i = 1; i <= num; i++) {    
			fact *= i;    
		}
		return fact;
		//System.out.println("Factorial of " + num + " is: " + fact);    
	}
}
