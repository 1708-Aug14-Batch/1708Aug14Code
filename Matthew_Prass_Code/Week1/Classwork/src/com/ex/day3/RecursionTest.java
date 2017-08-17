package com.ex.day3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//provides static methods in the org.junit.assert class
//to test for certain conditions


public class RecursionTest {

	
	Recursion tester = new Recursion();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		System.out.println("after class");
	}

	@Before
	public void setUp() throws Exception {
		
		System.out.println("before method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after method");
	}

	@Test
	public void factorialTest() {
		
		
		int expected = 24;
		int actual = tester.factorial(4);
		
		assertEquals(expected,actual);
		assertEquals(1, tester.factorial(1));
		
	}
	@Test
	public void addTest()
	{
		assertEquals(5,tester.add(3,2));
	}

	@Test
	public void varArgsTest()
	{
		assertEquals(10,tester.addArgs(1,2,7));
		assertEquals(0,tester.addArgs());
		assertEquals(20,tester.addArgs(10,5,5));
	}
	
	@Test
	public void stringTest()
	{
		assertEquals("cat",tester.reverse("tac"));
		//does not work; not the same because of string
		//assertSame("cat",tester.reverse("tac"));
	}
}
