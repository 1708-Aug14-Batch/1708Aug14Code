/**
 * 
 */
package question2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 * @author joshw
 *
 */
public class FibonacciNumbersTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	FibonacciNumbers tester = new FibonacciNumbers();
		int expected = 10 ;
		int actual = tester.fibonacci(4);
		
		assertEquals(expected, actual);
		assertEquals(1, tester.fibonacci(1));
	}

}
