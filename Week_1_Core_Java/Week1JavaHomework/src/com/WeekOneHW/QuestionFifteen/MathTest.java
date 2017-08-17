package com.WeekOneHW.QuestionFifteen;

public class MathTest implements MathInterface{ //The MathTest class that implements the MathInterface interface

	/*
	 * Brought in the unimplemented functions and added the proper outcome to each return statement.
	 */
	@Override
	public int addNum(int a, int b) {
		
		return a+b;
	}

	@Override
	public int subNum(int a, int b) {
		
		return a - b;
	}

	@Override
	public int multiNum(int a, int b) {
		
		return a * b;
	}

	@Override
	public double divNum(double a, double b) {
		
		return a / b;
	}

}
