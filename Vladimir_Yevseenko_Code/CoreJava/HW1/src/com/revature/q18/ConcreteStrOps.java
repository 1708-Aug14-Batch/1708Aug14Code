package com.revature.q18;

import java.util.Arrays;
import java.util.stream.Stream;

public class ConcreteStrOps extends AbstractStrOps {

	@Override
	public boolean hasUpperCase(String s) {
		/*
		 * Nice stream solution
		 */
		return s.chars().anyMatch(c -> Character.isUpperCase(c));
	}

	@Override
	public String toUpperCase(String s) {
		return s.toUpperCase();
	}

	@Override
	public int toIntPlusTen(String s) throws NumberFormatException {
		return Integer.parseInt(s) + 10;
	}
	
}
