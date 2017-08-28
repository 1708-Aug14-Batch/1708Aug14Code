package Q4;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RecursionTest {
	
	@Before
	public void setUp() throws Exception {

	}
	
	@After
	public void tearDown() throws Exception {

	}
	
	@Test
	public void factorialTest() {
		assertEquals(new BigInteger("1"),  Factorial.factorial(0));
		assertEquals(new BigInteger("1"),  Factorial.factorial(1));
		assertEquals(new BigInteger("24"), Factorial.factorial(4));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void exceptionTest() {
		Factorial.factorial(-1);		
	}

}
