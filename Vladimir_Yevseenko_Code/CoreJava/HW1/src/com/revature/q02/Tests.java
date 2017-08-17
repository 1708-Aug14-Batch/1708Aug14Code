package com.revature.q02;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tests {

	@Test(expected = IllegalArgumentException.class)
	public void naiveFibTestEx() {
		Fibonacci.naiveFibonacci(-5);
	}

	@Test
	public void naiveFibTest() {
		assertEquals(0, Fibonacci.naiveFibonacci(0));
		assertEquals(1, Fibonacci.naiveFibonacci(1));
		assertEquals(6765, Fibonacci.naiveFibonacci(20));
	}
	
	
	
	@Test (expected = IllegalArgumentException.class)
	public void smartFibTestEx() {
		Fibonacci.smartFibonacci(-420);
	}
	
	@Test
	public void smartFibTest() {
		assertEquals(0, Fibonacci.smartFibonacci(0));
		assertEquals(1, Fibonacci.smartFibonacci(1));
		assertEquals(2584, Fibonacci.smartFibonacci(18));
	}
	
	@Test
	public void equalityTest() {
		assertEquals(Fibonacci.naiveFibonacci(25),
					Fibonacci.smartFibonacci(25));
	}

}
