package com.question15;

public class MathT implements MathI{

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
