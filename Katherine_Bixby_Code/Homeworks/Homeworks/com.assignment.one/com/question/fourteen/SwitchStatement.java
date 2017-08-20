package com.question.fourteen;

import java.util.Random;

/**
 * A program that demonstrates the switch case.
 * Implements the following functionalities in the cases:
 * 		Case 1: Find the square root of a number using the Math class method. 
 * 		Case 2: Display today’s date.
 * 		Case 3: Split the following string and store it in a sting array.
 * 			“I am learning Core Java”
 * @author Katie
 */

public class SwitchStatement {

	/**
	 * Running the switch statement
	 * @param theCase
	 * 		The int value indicating which case to run
	 */
	public void runSwitch(int theCase) {
		switch(theCase) {
			case 1: 
				Random rand = new Random();
				int randNum = rand.nextInt(500) + 1;	// I made it get the square root of random numbers for kicks
				double printThis = findSqrt(randNum);
				System.out.println("The Square Root of "+randNum+" is: "+printThis);
				break;
			case 2:
				System.out.println(java.time.LocalDateTime.now());
				break;
			case 3:
				String thisString = "I am learning Core Java";
				String[] splittyString = thisString.split(" ");
				System.out.println("Element 2 in the sentence "+thisString+" is: "+splittyString[2]);
				break;
		}
	}
	
	/**
	 * Finding the square root of a double
	 * Separated to different method to keep things tidy
	 * @param num
	 * 		Number to get square root value of
	 * @return
	 * 		The square root
	 */
	private double findSqrt(double num) {
		double root = Math.sqrt(num);
		return root;
	}
	
}
