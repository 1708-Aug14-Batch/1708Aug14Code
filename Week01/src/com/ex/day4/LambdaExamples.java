package com.ex.day4;

public class LambdaExamples {
	
	public static void main(String[] args) {
		Calculable mod = (int a, int b) -> a % b;
		System.out.println(mod.calculate(10, 2));
	}
}

interface Calculable {
	double calculate(int a, int b);
}
