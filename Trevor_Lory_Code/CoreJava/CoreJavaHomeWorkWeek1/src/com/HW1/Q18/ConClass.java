package com.HW1.Q18;

public class ConClass extends SuperClass {

	@Override
	public boolean CheckUpper(String s) {
		char[] c = s.toCharArray();
		for(char ca : c) {
			if(ca >= 65 && ca <= 90) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String ToUpper(String s) {
		return s.toUpperCase();
	}

	@Override
	public String AddTen(String s) {
		int x = Integer.parseInt(s);
		return Integer.toString(x + 10);
	}
	
}
