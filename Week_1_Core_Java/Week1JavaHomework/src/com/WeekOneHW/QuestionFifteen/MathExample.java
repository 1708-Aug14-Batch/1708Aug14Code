package com.WeekOneHW.QuestionFifteen;

public class MathExample extends MathTest { //MathExample class that extends MathTest

	public static void main(String[] args) {
		
		MathTest test = new MathTest(); //Creating the MathTest object to run its functions
		
		/*
		 * Printing out each function and feeding the functions values for output.
		 */
		System.out.println(test.addNum(5, 5));
		System.out.println(test.subNum(10, 5));
		System.out.println(test.multiNum(10, 5));
		System.out.println(test.divNum(20, 10));

	}

}
