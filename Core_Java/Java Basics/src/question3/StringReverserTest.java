package question3;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringReverserTest {

	@Test
	public void testBoundaryCases() {
		assertEquals(null, StringReverser.reverseString(null));
		assertEquals("", arrayToString(StringReverser.reverseString("")));
		assertEquals("a", arrayToString(StringReverser.reverseString("a")));
	}
	
	@Test
	public void testCases() {
		String str = "This is a somewhat long string to be reversed";
		StringBuilder sb = new StringBuilder(str);
		String reverseStr = sb.reverse().toString();
		
		assertEquals("Hello World!", arrayToString(StringReverser.reverseString("!dlroW olleH")));
		assertEquals("taco cat", arrayToString(StringReverser.reverseString("tac ocat")));
		assertEquals(reverseStr, arrayToString(StringReverser.reverseString(str)));
	}
	
	public String arrayToString(char[] characters) {
		String result = "";
		
		for (char cha : characters)
			result += cha;
		
		return result;
	}

}
