package com.hw.week01.q13;

public class Pyramid {
	
	public static void printPyramid() {
		int[] numbers = new int[] {0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
		for(int i = 0; i < numbers.length; i++) {
			if (i == 0 || i == 2 || i == 5) {
				System.out.print(numbers[i] + "\n\n");
			} else {
				System.out.print(numbers[i]);
			}
		}
	}

}
