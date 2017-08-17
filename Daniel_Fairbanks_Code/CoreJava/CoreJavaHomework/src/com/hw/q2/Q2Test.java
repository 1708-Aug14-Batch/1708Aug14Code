package com.hw.q2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hw.q1.Q1;

public class Q2Test {

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
	public void fibSequenceTest() {
		Q2 tester = new Q2();
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(0,1,1,3,6,12,24,48));
		int numElements = expected.size();
		ArrayList<Integer> actual = tester.fib(numElements);
		
		assertThat(actual, is(expected));
	}

}
