package question5;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubstringBuilderTest {

	@Test
	public void testBoundaryCases() {
		assertEquals(null, SubstringBuilder.subStringer(null, 0));
		assertEquals(null, SubstringBuilder.subStringer(null, 7));
		assertEquals("", SubstringBuilder.subStringer("", 0));
		assertEquals("", SubstringBuilder.subStringer("", 77));
		assertEquals("", SubstringBuilder.subStringer("", -77));
	}
	
	@Test
	public void testCases() {
		assertEquals("Hello World!", SubstringBuilder.subStringer("Hello World!", 77));
		assertEquals("", SubstringBuilder.subStringer("Hello World!", 0));
		assertEquals("H", SubstringBuilder.subStringer("Hello World!", 1));
		assertEquals("He", SubstringBuilder.subStringer("Hello World!", 2));
		assertEquals("Hel", SubstringBuilder.subStringer("Hello World!", 3));
		assertEquals("Hello World!", SubstringBuilder.subStringer("Hello World!", 12));
	}
	
}
