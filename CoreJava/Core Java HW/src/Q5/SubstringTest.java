package Q5;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SubstringTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String s = "1234567890";
		
		assertEquals("", Substring.substring(s, 0));
		assertEquals("1", Substring.substring(s, 1));
		assertEquals("123", Substring.substring(s, 3));
		assertEquals("1234567890", Substring.substring(s, 10));
	}

}
