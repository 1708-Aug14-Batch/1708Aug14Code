package com.WeekOneHW.QuestionTen;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TenJUnit {

	TernaryTest test;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		test = new TernaryTest();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void ternary() {
		//This test is using an expected lower value to check if the actual values(low number, high number) fed is accurate.
		int expected = 10;
		int actual = test.minValue(10, 20);
		
		assertEquals(expected, actual);
		
	}
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

}
