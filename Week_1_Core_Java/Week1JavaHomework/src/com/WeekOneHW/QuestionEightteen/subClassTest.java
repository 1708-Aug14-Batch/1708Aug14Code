package com.WeekOneHW.QuestionEightteen;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class subClassTest {

	ConcreteSubClass test;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 test= new ConcreteSubClass();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void test() {
		//Another boolean test, this time with a string method
		boolean expected = true;
		boolean actual = test.upperCheck("this is a tesT");
		
		assertEquals(expected,actual);
	}

}
