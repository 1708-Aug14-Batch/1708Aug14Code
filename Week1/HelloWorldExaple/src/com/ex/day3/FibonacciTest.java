package com.ex.day3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FibonacciTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("before mathod");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after method");
	}

	@Test
	public void test() {
		Fibonacci tester = new Fibonacci();
		int expected = 1;
		int actual = tester.fibonacci(1);
		assertEquals(expected, actual);
		
	}

}
