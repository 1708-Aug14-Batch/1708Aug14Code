package com.hw.week01.q12;

public class EvenNumbers {
	
	public static void printEvenNumbers(int[] numbers) {
		for(int currentNumber : numbers) {
			if (currentNumber % 2 == 0) {
				System.out.print(currentNumber + " ");
			}
		}
	}

}
