package com.ex.day3;

import java.util.ArrayList;

public class Generics {

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList things = new ArrayList();
		things.add(1);
		things.add("hello");
		things.add(new Object());
	}

}
