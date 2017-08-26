package com.hw.week01.q04;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactorialTest {

	@Test
	public void testZeroFactorial() {
		assertEquals(1, Factorial.factorial(0));
	}
	
	@Test
	public void testOneFactorial() {
		assertEquals(1, Factorial.factorial(1));
	}
	
	@Test
	public void testFiveFactorial() {
		assertEquals(120, Factorial.factorial(5));
	}
	
	@Test
	public void testTenFactorial() {
		assertEquals(3628800, Factorial.factorial(10));
	}

}
