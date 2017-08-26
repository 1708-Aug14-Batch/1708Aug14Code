package com.hw.week01.q02;

import java.util.ArrayList;

public class Fibonacci {

	public static int[] sequence(int count) {
		int[] fibonacci = new int[count];
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		for (int i = 2; i < count; i++) {
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}
		return fibonacci;
	}
	
}
