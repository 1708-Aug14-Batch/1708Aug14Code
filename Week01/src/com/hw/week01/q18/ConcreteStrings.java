package com.hw.week01.q18;

public class ConcreteStrings extends AbstractStrings {

	@Override
	public boolean containsUpperCaseLetters(String string) {
		for(char character : string.toCharArray()) {
			if (Character.isUpperCase(character)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toUpperCase(String string) {
		return string.toUpperCase();		
	}

	@Override
	public int addTen(String numberString) {
		return 10 + Integer.parseInt(numberString);
	}

}
