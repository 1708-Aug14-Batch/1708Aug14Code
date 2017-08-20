package questionTen;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;

public class FindMinTest {
	FindMin tester;

	@Before
	public void setUp() throws Exception {
		tester = new FindMin();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindMin() {
		int expected = 3;
		int actual = tester.findMin(3, 5);
		assertEquals(expected, actual);
		assertEquals(2,tester.findMin(5,2));
		assertEquals(6,tester.findMin(6, 6));
	}

}
