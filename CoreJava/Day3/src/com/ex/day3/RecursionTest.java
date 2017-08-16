package com.ex.day3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RecursionTest {

/*
 * JUnit provides static methods in the org.junit.assert
 * to test for certain conditions.
 */
	Recursion tester;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("before method");
		tester = new Recursion();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after method");
	}

	@Test
	public void test() {
		
		int expected = 24;
		int actual = tester.factorial(4);
		
		assertEquals(expected, actual);  
		assertEquals(1, tester.factorial(1));
	}

}






