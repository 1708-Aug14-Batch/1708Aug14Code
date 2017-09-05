package com.hw.week01.q06;


public class EvenNumberChecker {
	
	public static boolean isEven(int number) {
		int half = number / 2;
		if (half * 2 == number) {
			return true;
		}
		return false;
	}

}
