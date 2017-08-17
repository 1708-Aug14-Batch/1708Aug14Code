package com.bank.pojos;

public enum Field {
	FIRST, LAST, EMAIL, PASSWORD;
	
	public static Field parseField(String s) {
		switch (s.toLowerCase()) {
			case "f": return FIRST;
			case "l": return LAST;
			case "e": return EMAIL;
			case "p": return PASSWORD;
		}
		return null;
	}
	
	@Override
	public String toString() {
		switch (this) {
			case FIRST: return "first name";
			case LAST: return "last name";
			case EMAIL: return "email";
			case PASSWORD: return "password";
		}
		return null;
	}
}
