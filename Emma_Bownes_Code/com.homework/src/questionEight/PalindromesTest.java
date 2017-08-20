package questionEight;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PalindromesTest {
	Palindromes tester;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tester = new Palindromes();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPalandrome() {
		assertTrue(Palindromes.palandrome("yaaay"));
		assertTrue(Palindromes.palandrome("yaay"));
		assertFalse(Palindromes.palandrome("boy"));
	}

}
