package com.HW1.Q1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitBubble {

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
		System.out.println("Before method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After method");
	}

	@Test
	public void test() {
		BubbleSort b = new BubbleSort();
		int[] expected = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		int[] actual = b.BubbleSortMethod();
		for(int i = 0; i < 10; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}

}
