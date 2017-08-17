package com.hw.q1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hw.q4.Q4;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
public class Q1Test {

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
	public void bubbleSortTest() {
		Q1 tester = new Q1();
		int[] expected = {0,1,2,3,3,4,5,6,7,8,9};
		int[] numbers = new int[] {1,0,5,6,3,2,3,7,9,8,4};
		int[] actual = tester.bubbleSort(numbers);
		
		assertThat(actual, is(expected));
	}

}
