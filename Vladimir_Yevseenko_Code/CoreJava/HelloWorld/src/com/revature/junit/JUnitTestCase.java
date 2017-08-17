package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitTestCase {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Set up before tests.");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Tear down after tests.");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Set up before test.");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Tear down after test.");
	}

	@Test
	public void minTest() {
		assertEquals(0, JUnitBasics.min(new int[]{5, 4, 3, 4, 3, 2, 0, 1, 2, 56 }));
	}
	
	@Test
	public void maxTest() {
		assertEquals(56, JUnitBasics.max(new int[]{5, 4, 3, 4, 3, 2, 0, 1, 2, 56 }));
	}
}
