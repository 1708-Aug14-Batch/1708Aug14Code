package problem4;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem4Test {

	@Test
	public void test() {
		Problem4 factorial = new Problem4();
		
		int expected = 24;
		
		int actual = factorial.factorialRec(4);
		
		assertEquals(expected, actual);
	}

}
