package com.ex.day3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ RecursionTest.class })
public class AllTests {

	// Add together two ints
	public int add(int a, int b) {
		return a + b;
	}

	// Add together many ints
	public int addArgs(int... nums) {

		int sum = 0;
		for (int i : nums)
			sum += i;

		return sum;
	}
	
	@Test
	public void varArgsTest() {
		assertEquals(10, addArgs(1, 2, 7));
		assertEquals(0, addArgs());
		assertNotEquals(10, addArgs(5, 5, 5, 5));
		assertTrue(addArgs(5, 5) == 10);
		assertFalse(addArgs(0) == 1);
	}

}
