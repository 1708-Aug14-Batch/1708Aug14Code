package com.question17;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InterestTest {

	;
	
	double princ = 1000;
	double rate = 10;
	int year = 1;
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

	//@SuppressWarnings("deprecation")
	@Test
	public void test() {
		InterestPayment test = new InterestPayment();
		double expected = 100;
		double actual = test.Payment(1000, 10, 1);
		assertSame(expected,actual);
	}

}
