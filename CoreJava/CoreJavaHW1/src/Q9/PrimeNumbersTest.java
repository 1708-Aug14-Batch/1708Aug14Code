package Q9;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Q3.ReverseString;

public class PrimeNumbersTest {

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
		PrimeNumbers tester = new PrimeNumbers();
		
		boolean expected = true;
		boolean actual = tester.isPrime(5);
		
		assertEquals(expected, actual);  
		assertEquals(true, tester.isPrime(5));

	}

}
