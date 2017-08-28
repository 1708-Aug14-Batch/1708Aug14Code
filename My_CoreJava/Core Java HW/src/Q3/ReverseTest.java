package Q3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReverseTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReverse() {
		
		assertEquals("", Reverse.reverse(""));
		assertEquals("1", Reverse.reverse("1"));
		assertEquals("Cat", Reverse.reverse("taC"));
		assertEquals("This is in reverse.", Reverse.reverse(".esrever ni si sihT"));

		
		assertEquals("", Reverse.reverse2(""));
		assertEquals("1", Reverse.reverse2("1"));
		assertEquals("Cat", Reverse.reverse2("taC"));
		assertEquals("This is in reverse.", Reverse.reverse2(".esrever ni si sihT"));
	}

}
