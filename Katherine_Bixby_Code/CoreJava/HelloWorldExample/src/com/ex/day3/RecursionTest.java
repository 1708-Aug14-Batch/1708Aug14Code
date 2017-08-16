package com.ex.day3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RecursionTest {
	
	public static Recursion tester = new Recursion();

	
	@BeforeClass
	public static void setupBeforeClass() throws Exception{
		System.out.println("Before class");
	}
	@AfterClass
	public static void setupAfterClass() throws Exception{
		System.out.println("After class");
	}
	
	@Before
	public void setUp() throws Exception{
		System.out.println("Set up");
	}
	
	@After
	public void tearDown() throws Exception{
		System.out.println("After method");
	}
	
	@Test
	public void factorialTest() {
		
		int expected = 24;
		int actual = tester.factorial(4);
		assertEquals(expected,actual);
		assertEquals(1,tester.factorial(1));
	}
	@Test
	public void fibonacciTest() {
		int actual = tester.fibonacci(24);
		int expected = 46368;
		assertEquals(expected,actual);
	}
	
	@Test
	public void varArgsTest() {
		assertEquals(10,tester.addArgs(1,2,7));
		assertEquals(0,tester.addArgs());
	}
	
	@Test
	public void stringTest() {
		assertEquals("cat", Recursion.reverse("tac"));
		//assertSame("cat",tester.reverse("tac")); // This one will fail! Different indexes
	}
}
