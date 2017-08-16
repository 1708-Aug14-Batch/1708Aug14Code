package Recursion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RecursionTest {
	

	Recursion testRec = new Recursion();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
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
	public void factorialTest() {
		
		int expected = 24;
		
		int actual = testRec.factorial(4);
		
		assertEquals(expected, actual);
		assertEquals(1, testRec.factorial(1));
		
	}
	
	@Test
	public void addTest() {
		assertEquals(5, testRec.add(3,2));
	}

	@Test
	public void varArgsTest() {
		assertEquals(10, testRec.addArgs(1,2,7));
		assertEquals(0, testRec.addArgs());
		assertEquals(20, testRec.addArgs(5,5,5,5));
	}
	
	@Test
	public void stringTest() {
		assertEquals("cat",  testRec.reverse("tac"));
	}
	
}
