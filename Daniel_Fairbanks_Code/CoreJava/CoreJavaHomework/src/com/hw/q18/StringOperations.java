package com.hw.q18;

public class StringOperations extends AbstractStringOp{

	public boolean containsUppercase(String str) {
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) >= 65 && str.charAt(i) <= 90)
				return true;
		}
		return false;
	}

	public String convertToUppercase(String str) {
		return str.toUpperCase();
	}

	public int stringToInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return -1;
		}
	}
}
