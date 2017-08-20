package questionSixtn;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NumCharTest {
	
	NumChar tester;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tester = new NumChar();
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
	}

	@Test
	public void testCountChar() {
		assertEquals(7, NumChar.countChar("cat dog"));
		assertEquals(0, NumChar.countChar(""));
	}

}
