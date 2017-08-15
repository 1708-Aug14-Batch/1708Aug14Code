package com.hw.q15;

public class Q15 {

	public static void main(String[] args) {
		float val1 = 20.0f;
		float val2 = 5.0f;
		SimpleCalculator sc = new SimpleCalculator();
		System.out.println(val1+" + "+val2+" = "+sc.addition(val1, val2));
		System.out.println(val1+" - "+val2+" = "+sc.subtraction(val1, val2));
		System.out.println(val1+" * "+val2+" = "+sc.multiplication(val1, val2));
		System.out.println(val1+" / "+val2+" = "+sc.division(val1, val2));
	}

}
