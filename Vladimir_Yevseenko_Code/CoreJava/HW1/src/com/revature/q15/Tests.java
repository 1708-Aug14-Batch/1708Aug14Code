package com.revature.q15;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tests {
	
	@Test
	public void numberContainerTest() {
		NumberContainer nc1 = new NumberContainer((short) 5, 12, 15, 80.5f, 35.4);
		NumberContainer nc2 = new NumberContainer((short) 4, 10, 13, 20.5f, 30.6);
		
		assertEquals(new NumberContainer((short) (5+4), 12+10, 15+13, 80.5f+20.5f, 35.4+30.6), nc1.add(nc2));
		assertEquals(new NumberContainer((short) (5-4), 12-10, 15-13, 80.5f-20.5f, 35.4-30.6), nc1.subtract(nc2));
		assertEquals(new NumberContainer((short) (5*4), 12*10, 15*13, 80.5f*20.5f, 35.4*30.6), nc1.multiply(nc2));
		assertEquals(new NumberContainer((short) (5/4), 12/10, 15/13, 80.5f/20.5f, 35.4/30.6), nc1.divide(nc2));
	}

}