package question1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class BubbleTest {

	@Test
	public void testBoundaryCases() {
		int[] empty = {};
		int[] array1 = {5};
		int[] array2 = {5, 4};
		
		int[] expected2 = {4, 5};
		
		// Buttble sort with a null array
		assertEquals(null, BubbleSorter.bubbleSort(null));

		// Buttble sort with an empty array
		assertTrue(areArraysEqual(empty, BubbleSorter.bubbleSort(empty)));

		// Buttble sort with a single-item array
		assertTrue(areArraysEqual(array1, BubbleSorter.bubbleSort(array1)));

		// Buttble sort with a two-item array
		assertTrue(areArraysEqual(expected2, BubbleSorter.bubbleSort(array2)));

	}

	@Test
	public void testCases() {
		int size4 = 100;
		
		int[] array1 = {1, 1, 1, 1, 1, 1};
		int[] array2 = {0, 1, 0, 0, 0, 0, 0, 0, 0, 1};
		int[] array3 = {5, 2, -8, 3, 9, 1, -4, 6, -10, 7};
		int[] array4 = new int[size4];
		
		int[] expected1 = {1, 1, 1, 1, 1, 1};
		int[] expected2 = {0, 0, 0, 0, 0 ,0, 0, 0, 1, 1};
		int[] expected3 = {-10, -8, -4, 1, 2, 3, 5, 6, 7, 9};
		ArrayList<Integer> expected4 = new ArrayList<Integer>();
		for (int i = 0; i < size4; i++) {
			int rand = (int) (Math.random()*100);
			expected4.add(rand);
			array4[i] = rand;
		}
		Collections.sort(expected4);
		
		assertTrue(areArraysEqual(expected1, BubbleSorter.bubbleSort(array1)));
		assertTrue(areArraysEqual(expected2, BubbleSorter.bubbleSort(array2)));
		assertTrue(areArraysEqual(expected3, BubbleSorter.bubbleSort(array3)));
		assertTrue(areArraysEqual(expected4, BubbleSorter.bubbleSort(array4)));
	}

	private boolean areArraysEqual(int[] expected, int[] actual) {

		if (actual.length != expected.length)
			return false;
		for (int i = 0; i < expected.length; i++)
			if (expected[i] != actual[i])
				return false;

		return true;
	}
	
	private boolean areArraysEqual(ArrayList<Integer> expected, int[] actual) {

		int[] newExpected = new int[expected.size()];
		
		for (int i = 0; i < newExpected.length; i++)
			newExpected[i] = expected.get(i);
		
		return areArraysEqual(newExpected, actual);
	}

}
