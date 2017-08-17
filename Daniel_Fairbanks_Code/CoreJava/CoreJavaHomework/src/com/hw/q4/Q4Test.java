package com.hw.q4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * JUnit provides static methods in the org.assert. class to test for certain conditions.
 */
public class Q4Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class.");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class.");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before method.");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After method.");
	}

	@Test
	public void factorialTest() {
		Q4 tester = new Q4();
		int expected = 24;
		int actual = tester.compute_factorial(4);
		
		assertEquals(expected, actual);
	}

}
