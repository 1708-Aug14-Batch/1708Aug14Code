package question10;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindMinTest {

	// findMin returns -1 if the first parameter is smaller
	// findMin returns +1 if the second parameter is smaller
	// findMin return 0 if the parameters are equal
	
	@Test
	public void testBoundaryCases() {
		assertEquals(0, FindMin.findMin(0, 0));
		assertEquals(0, FindMin.findMin(7, 7));
		assertEquals(0, FindMin.findMin(-5, -5));
	}
	
	@Test
	public void test() {
		assertEquals(-1, FindMin.findMin(2, 3));
		assertEquals(-1, FindMin.findMin(0, 1));
		assertEquals(-1, FindMin.findMin(55, 1230));
		assertEquals(1, FindMin.findMin(100, -8));
		assertEquals(1, FindMin.findMin(5467, 2));
		assertEquals(1, FindMin.findMin(0, -5));
	}

}
