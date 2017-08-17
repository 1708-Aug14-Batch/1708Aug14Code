package problem10;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem10Test {

	@Test
	public void test() {
		
		Problem10 lowest = new Problem10();
		
		int x = 5;
		int y = 10;
		
		int expected = 5;
		int actual = lowest.lowest(x, y);
		
		assertEquals(expected, actual);
		
	}

}
