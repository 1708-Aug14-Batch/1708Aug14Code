package Q10;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinimumTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(1, Minimum.min(1, 10));
		assertEquals(1, Minimum.min(10, 1));
		assertEquals(1, Minimum.min(1, 1));
	}

}
