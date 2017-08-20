package JunitTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import question9.PrimeNumbers;

public class PrimeNumbersTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsPrime() {
		boolean actual = PrimeNumbers.isPrime(5);
		boolean expected = true;
		
		boolean actual1 = PrimeNumbers.isPrime(8);
		boolean expected1 = false;
		
		assertEquals(expected, actual);
		assertEquals(expected1, actual1);
	}

}
