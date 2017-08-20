package questionEighttn;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UseCasesTest {
	UseCases tester;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tester = new UseCases();
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
	}

	@Test
	public void testUppercaseTrue() {
		assertTrue(tester.uppercase("Pain"));
		assertTrue(tester.uppercase("pAin"));
		assertTrue(tester.uppercase("PaIn"));
		assertTrue(tester.uppercase("paiN"));
	}
	
	@Test
	public void testUppercaseFalse() {
		assertFalse(tester.uppercase("pain"));
	}

	@Test
	public void testChangeCase() {
		String expected = "NOT";
		String actual = tester.changeCase("not");
		assertEquals(expected, actual);
		assertEquals("NOT", tester.changeCase("nOT"));
	}

	@Test
	public void testStringToInt() {
		tester.stringToInt("10");
	}


}
