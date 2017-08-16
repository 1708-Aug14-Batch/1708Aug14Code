package com.quesetion.six;

public class EvenOrOdd {
	
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
