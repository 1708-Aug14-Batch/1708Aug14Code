package com.hw.q10;

public class Q10 {

	public int calc_min(int num1, int num2) {
		int min_val = (num1 < num2) ? num1 : num2;
		return min_val;
	}
	
	public static void main(String[] args) {
		int num1 = 36;
		int num2 = 14;
		int min_val = (num1 < num2) ? num1 : num2;
		System.out.println(min_val);
	}

}
