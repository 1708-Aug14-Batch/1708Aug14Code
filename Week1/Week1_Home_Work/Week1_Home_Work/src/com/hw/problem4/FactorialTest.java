package com.hw.problem4;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactorialTest {
	Factorial tester;

	@Test
	public void test() {
		int expected = 1;
		int actual = tester.factorial(1);
		
		assertEquals(expected, actual);

	}

}
