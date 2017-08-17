package Q15;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMath {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Math math = new Math();
		int x = 5, y = 9;
		assertEquals(x+y, math.addition(x, y));
		assertEquals(x-y, math.subtraction(x, y));
		assertEquals(x*y, math.multiplication(x, y));
		assertEquals(x/(float)y, math.division(x, y), 0.0);
	}

}
