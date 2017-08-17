/**
 * 
 */
package Day3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/** Junit provides static methods  in 
 * org.junit.assert class to test for certain conditions.
 * @author Joshua Wurdemann
 *
 */
public class RecursionTest {

	// TODO Auto-generated method stub


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 System.out.println("Before Method");
	}
       
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("After Method");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("After Method");
	}

	@Test
	public void factorialTest() {
		Recursion tester = new Recursion();
		int expected = 24;
		int actual = tester.factorial(4);
		
		assertEquals("Should be true",expected, actual);
		assertEquals(1, tester.factorial(1));
	}

}
