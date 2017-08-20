package questionFive;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubstringTest {
	Substring tester;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tester = new Substring();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSubstring() {
		assertEquals("pla",tester.substring("play", 3));
		assertEquals("p",tester.substring("play", 1));
		assertEquals("play",tester.substring("play", 4));
	}

}
