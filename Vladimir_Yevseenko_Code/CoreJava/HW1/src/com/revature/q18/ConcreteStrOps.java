package com.revature.q18;

public class ConcreteStrOps extends AbstractStrOps {

	@Override
	public boolean hasUpperCase(String s) {
		for (char c: s.toCharArray())
			if (Character.isUpperCase(c))
				return true;
		return false;
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