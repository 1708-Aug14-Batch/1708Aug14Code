package com.hw.week01.q01;

import java.util.ArrayList;

public class BubbleSort {
	
	public static int[] sort(int[] numbers) {
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 1; j < numbers.length; j++) {
				if (numbers[j - 1] > numbers[j]) {
					int temp = numbers[j - 1];
					numbers[j - 1] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		return numbers;
	}
}
