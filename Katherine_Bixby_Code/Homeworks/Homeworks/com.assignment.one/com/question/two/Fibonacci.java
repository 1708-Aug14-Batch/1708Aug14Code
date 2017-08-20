package com.question.two;

/**
 * Gets you the fibonacci value of the number you input
 * Uses recursion to get you there.
 * 
 * @author Katie
 *
 */

public class Fibonacci {

	public static int printFibonacci(int num) {
		if(num==0) {
			return 0;
		}
		else if(num==1) {
			return 1;
		}
		else {
			return printFibonacci(num-1)+printFibonacci(num-2);
		}
	}
	
}
