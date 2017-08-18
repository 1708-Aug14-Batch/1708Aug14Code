package com.WeekOneHW.QuestionEight;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PalinTest {

	Palindrome tester;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tester = new Palindrome();
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
	}
	
	@Test
	public void test() {
		//Doing a boolean test to see if the fed value is a palindrome.
		boolean expected = true;
		
		boolean actual = tester.isPalin("mom");
		
		assertEquals(expected,actual);
		
	}



//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

}
