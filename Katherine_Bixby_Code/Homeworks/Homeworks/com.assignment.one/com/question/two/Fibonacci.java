package com.question.two;

/**
 * This is my answer to the problem of figuring out the nth fibonacci value, or the numFib'th fibonacci value.
 * This method allows you to input any number for the fib values.
 * The first 2 entries will be kept as 1 and 1, regardless of size you're after.
 * The following ones are all calculated by adding the two preceding values together.
 * @author Katie
 *
 */

public class Fibonacci {

	/**
	 * Call-able method for calculating and printing the fibonacci values
	 * @param numFib
	 * 		The number of fibonacci values you want to calculate.
	 */
	public static void printFibbonacci(int numFib) {
		if(numFib==0||numFib<0) {	// if they gave you an integer you can't calculate the fibonacci value of...
			System.out.println("You didn't exactly give me a positive integer...");
		}
		else if (numFib>0) {	// if they gave you a positive integer
			int[] intArr = new int[numFib];	// create a new arrray of the legth of the values they want to calculate
			intArr[0]=1; // the first one is always one
			if(numFib>1) {
				intArr[1]=1; // the second one is also always one - if they try to check the indexes before you'll have errors
				if(numFib>2) {	// so now we can actually index the 2 spots before the one being checked
					for(int i=2;i<numFib-1;i++) {	// for all those indexes
						intArr[i] = intArr[i-2]+intArr[i-1];	// add the values of the two spots before this one together and
						// store it in that value i
					}
				}
			}
			/*
			 * This is just printing out the array, with commas after each value except the last one (for readability)
			 */
			for (int i=0;i<intArr.length-1;i++) {
				if(i==intArr.length-2) {
					System.out.print(intArr[i]);
				}
				else {
					System.out.print(intArr[i]+", ");
				}
			}
		}
		
	}
	
}
