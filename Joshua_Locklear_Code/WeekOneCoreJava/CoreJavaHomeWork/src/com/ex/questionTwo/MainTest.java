package com.ex.questionTwo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ex.Day3.Recursion;

public class MainTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before Method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After Method");
	}

	@Test
	public void test() {
		Main tester = new Main();
		assertEquals(1, tester.fibonacci(1));
		
	}

}
