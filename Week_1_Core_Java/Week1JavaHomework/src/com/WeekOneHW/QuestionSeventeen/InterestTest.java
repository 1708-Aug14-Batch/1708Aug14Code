package com.WeekOneHW.QuestionSeventeen;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InterestTest {

	
	InterestCalculator test;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		test = new InterestCalculator();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void test() {
		//Running a test to see if a calculation with 2 different data types will give me a successful run.
		double expected = 10000;
		double actual = test.calcInterest(20000, 10, 5);
		
	}

}
