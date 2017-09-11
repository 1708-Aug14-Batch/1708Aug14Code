package Q17;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Q3.ReverseString;

public class SimpleInterestTest {

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
		Calc tester = new Calc();
		
		double expected = 90000.0;
		double actual = tester.calcInterest(100000, 3, 30);
		
		assertEquals(expected, actual, 0.0);  
		assertEquals(90000.0, tester.calcInterest(100000, 3, 30), 0.0);
	}

}
