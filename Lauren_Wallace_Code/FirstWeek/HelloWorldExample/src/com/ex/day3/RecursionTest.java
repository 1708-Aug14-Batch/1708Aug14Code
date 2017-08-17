package com.ex.day3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RecursionTest {
	
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
		tester = new Recursion();
		System.out.println("before method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after method");
		tester = null;
	}

	@Test
	public void factorialTest() {
		
		int expected = 24;
		int actual = tester.factorial(4);
		
		assertEquals(expected, actual);
		assertEquals(1, tester.factorial(1));
	}
	
	@Test
	public void addTest() {
		assertEquals(5, tester.add(2,3));
	}
	
	@Test
	public void varArgsTest() {
		assertEquals(10, tester.addArgs(1,2,7));
		assertEquals(0, tester.addArgs());
		assertEquals(20, tester.addArgs(5,5,5,5));
		assertTrue(tester.addArgs(5,5) == 10);
		
	}
	
	@Test
	public void StringTest() {
		assertEquals("cat", tester.reverse("tac"));
		//assertSame("cat", tester.reverse("tac"));
	}

}
