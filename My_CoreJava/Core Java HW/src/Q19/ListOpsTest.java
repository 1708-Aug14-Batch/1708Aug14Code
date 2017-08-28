package Q19;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListOpsTest {

	List<Integer> list;
	
	@Before
	public void setUp() throws Exception {
		list = new ArrayList<>();
		list.add(2);
		list.add(5);
		list.add(7);
		list.add(11);
		list.add(20);
		list.add(22);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddEvens() {
		
		assertEquals(44, ListOps.addEvens(list));
	}
		
	@Test
	public void testAddOdds() {
		
		assertEquals(23, ListOps.addOdds(list));
	}
	
	@Test
	public void testRemovePrimes() {
		
		List<Integer> noPrimes = new ArrayList<>();
		noPrimes.add(20);
		noPrimes.add(22);
		
		list = ListOps.removePrimes(list);
		
		assertEquals(list.size(), noPrimes.size());
		for (int i = 0; i < list.size(); i++) {
			assertEquals(list.get(i), noPrimes.get(i));
		}
	}

}
