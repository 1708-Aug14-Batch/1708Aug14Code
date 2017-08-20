package JunitTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import question4.NFactorial;

public class NFactorialTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Setting up");
	}

	@Test
	public void testFactorial() {
		NFactorial test = new NFactorial();
		int expected = 24;
		int actual = test.factorial(4);
		
		assertEquals("Should be true",expected, actual);
		assertEquals(1, test.factorial(1));
	}

}
