package com.question.six;

/**
 * Determines whether a given number is even or odd without using %
 * @author Katie
 *
 */
public class EvenOrOdd {
	
	/**
	 * I just used some floats to check if dividing them by 2 created a decimal that wasn't 0.
	 * @param num
	 * 		The number to check
	 * @return
	 * 		Whether it is even
	 */
	public static boolean isItEven(int num) {
		int theNumDiv = num/2;
		float thatIntDiv = (float)theNumDiv;
		float thatNum = (float)num;
		float thatDiv = thatNum/2;
		if(thatIntDiv==thatDiv) {
			return true;
		}
		else {
			return false;
		}

	}
	
}
