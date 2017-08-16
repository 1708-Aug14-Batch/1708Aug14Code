package problem2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Problem2Test {

//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}

	@Test
	public void test() {
		
		Problem2 fib = new Problem2();
		
		String expected = "0,1,1,2,3,5,8,";
		
		String actual = fib.fibonacci(7);
		
		assertEquals(expected, actual);
		
	}

}
