package Q4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NfactorialTest {

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
		Nfactorial tester = new Nfactorial();
		
		int expected = 24;
		int actual = tester.computeFactorial2(4);
		
		assertEquals(expected, actual);  
		assertEquals(1, tester.computeFactorial2(1));

	}

}
