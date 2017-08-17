package Q6;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IsEvenTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEven() {

		assertEquals(true, IsEven.isEven(0));
		assertEquals(false, IsEven.isEven(1));
		assertEquals(true, IsEven.isEven(100));
		assertEquals(false, IsEven.isEven(255));
	}

}
