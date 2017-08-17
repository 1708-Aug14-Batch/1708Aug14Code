package com.day3;

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
		System.out.println("After class");
	}

	@Before
	public void setUp() throws Exception {
		tester = new Recursion();
		System.out.println("Before method");
	}

	@After
	public void tearDown() throws Exception {
		tester =null;
		System.out.println("After method");
	}

	@Test
	public void factorialTest() {
		int expected = 24;
		
		int actual = tester.factorial(4);
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorialTestOne() {
		assertEquals(1,tester.factorial(1));
	}
	
//	@Test
//	public void fibTest() {
//		int expected = 2;
//		int actual = tester.fibonacci(3);
//		assertEquals(expected, actual);
//	}
	
	@Test
	public void reverseTest() {
		String expected = "tac";
		String actual = tester.reverse("cat");
		assertEquals(expected, actual);
	}
	}


