package Q3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Q4.Nfactorial;

public class ReverseStringTest {

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
	public void test() {
		ReverseString tester = new ReverseString();
		
		String expected = "dlroW olleH";
		String actual = tester.reverseStr("Hello World");
		
		assertEquals(expected, actual);  
		assertEquals("dlroW olleH", tester.reverseStr("Hello World"));
	}

}
