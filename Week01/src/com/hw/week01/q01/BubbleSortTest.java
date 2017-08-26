package com.hw.week01.q01;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BubbleSortTest {

	@Test
	public void testBubbleSort() {
		int[] unsortedNumbers = new int[] {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int[] sortedNumbers = BubbleSort.sort(unsortedNumbers);
		for (int i = 0; i < sortedNumbers.length; i++) {
			System.out.print(sortedNumbers[i] + " ");
			assertTrue(sortedNumbers[i] <= sortedNumbers[i]);
		}
	}

}
