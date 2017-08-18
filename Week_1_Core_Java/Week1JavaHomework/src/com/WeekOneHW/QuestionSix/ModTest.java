package com.WeekOneHW.QuestionSix;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModTest {

	NoModulus tester;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tester = new NoModulus();
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
	}

	@Test
	public void test() {
		/*
		 * Running a boolean test for isEven from NoModulus, but this time checking for a false value instead of true.
		 */
		boolean expected = false;
		
		boolean actual = tester.isEven(11);
		
		assertEquals(expected,actual);
	}

}
