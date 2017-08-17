package problem4;

import java.util.Scanner;

public class Problem4 {
	//Q4. Write a program to compute N factorial.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// User input
//		
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("Enter Number");
//		
//		int input = scan.nextInt();
//		
//		System.out.println(factorialRec(input));
		
	}
	
	//function for factorial

	public int factorialRec(int n) {
		if(n == 1) return 1;
		
		return n * factorialRec(n-1);
	}

}
