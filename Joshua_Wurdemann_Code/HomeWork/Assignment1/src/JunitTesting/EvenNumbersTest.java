package JunitTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import question12.EvenNumbers;

public class EvenNumbersTest {

	@Before
	public void setUp() throws Exception {
	System.out.println("setting up");
	}

	@Test
	public void testAddToList() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEven() {
		
		boolean actual = EvenNumbers.isEven(7);
		boolean expected = false;
		
		boolean actual1 = EvenNumbers.isEven(88);
		boolean expected1= true;
		
		assertEquals(expected, actual);
		assertEquals(expected1, actual1);
		
	}

}
