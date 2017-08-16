package com.ex.day3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FiboTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Fibo f = new Fibo();
		assertEquals(0, f.fib(1));
		assertEquals(1, f.fib(2));
		assertEquals(144, f.fib(13));
		assertEquals(34, f.fib(10));
	}

}
