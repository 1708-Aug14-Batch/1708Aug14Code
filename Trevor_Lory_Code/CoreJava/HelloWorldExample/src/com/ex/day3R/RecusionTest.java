package com.ex.day3R;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * JUnit provides static methods in the org.junit.assert class to test for certain conditions
 */

public class RecusionTest {

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
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after method");
	}

	@Test
	public void factorialtest() {
		
		Recursion tester = new Recursion();
		
		int expected = 24;
		int actual = tester.factorial(4);
		
		assertEquals(expected, actual);
		assertEquals(1, tester.factorial(1));
		
	}
	
	@Test
	public void varArgsTest() {
		Recursion tester = new Recursion();
		assertEquals(10, tester.addArgs(1, 2, 7));
	}
	
	@Test
	public void rev() {
		Recursion tester = new Recursion();
		assertEquals("tac", tester.reverse("cat"));
	}

}
