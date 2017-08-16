package problem3;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem3Test {

	@Test
	public void test() {
		
		Problem3 reverse = new Problem3();
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		String actual = reverse.reverse(alphabet);
		
		String expected = "zyxwvutsrqponmlkjihgfedcba";
		
		assertEquals(expected, actual);
	}

}
