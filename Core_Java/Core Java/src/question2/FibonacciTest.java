package question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void testBoundaryCases() {
		int[] expected1 = {0};
		int[] expected2 = {0, 1};

		// Fibonacci sequence with 0 numbers
		assertEquals(null, FibonacciNumbers.Fibonacci(0));

		// Fibonacci sequence with 1 number
		assertTrue(areArraysEqual(expected1, FibonacciNumbers.Fibonacci(1)));

		// Fibonacci sequence with 2 numbers
		assertTrue(areArraysEqual(expected2, FibonacciNumbers.Fibonacci(2)));

		// Fibonacci sequence with fewer than 0 numbers
		assertEquals(null, FibonacciNumbers.Fibonacci(-5));

	}

	@Test
	public void testCases() {
		int size1 = 3, size2 = 6, size3 = 13;
		int[] expected1 = {0, 1, 1};
		int[] expected2 = {0, 1, 1, 2, 3, 5};
		int[] expected3 = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
		
		assertTrue(areArraysEqual(expected1, FibonacciNumbers.Fibonacci(size1)));
		assertTrue(areArraysEqual(expected2, FibonacciNumbers.Fibonacci(size2)));
		assertTrue(areArraysEqual(expected3, FibonacciNumbers.Fibonacci(size3)));
	}

	private boolean areArraysEqual(int[] expected, int[] actual) {

		if (actual.length != expected.length)
			return false;
		for (int i = 0; i < expected.length; i++)
			if (expected[i] != actual[i])
				return false;

		return true;
	}

}
