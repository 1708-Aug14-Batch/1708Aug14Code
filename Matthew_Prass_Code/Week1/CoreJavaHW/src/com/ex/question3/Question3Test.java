package com.ex.question3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Question3Test {
	
	ReverseString r = new ReverseString();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before main");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After main");
	}

	@Test
	public void test() {
		
		String test = "erutaveR";
		String actual = r.reverseString("Revature");
		
		assertEquals(test,actual);
		
	}

}
