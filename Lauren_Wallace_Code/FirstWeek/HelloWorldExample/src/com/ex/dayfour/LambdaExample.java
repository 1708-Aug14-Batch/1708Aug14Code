package com.ex.dayfour;

public class LambdaExample {

	Calculable mod = (int a, int b) -> {
		return a % b;
	};
	
	
	
	System.out.println(mod.calculate(10,2));
	
}

interface Calculable {
	
	double calculate(int a, int b);
	
}
