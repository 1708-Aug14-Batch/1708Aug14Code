package com.HW1.Q8;

import java.util.ArrayList;

public class PalList {

	public static void main(String[] args) {
		ArrayList<String> fullList = new ArrayList<String>();
		fullList.add("karan");
		fullList.add("madam");
		fullList.add("tom");
		fullList.add("civic");
		fullList.add("radar");
		fullList.add("sexes");
		fullList.add("jimmy");
		fullList.add("kayak");
		fullList.add("john");
		fullList.add("refer");
		fullList.add("billy");
		fullList.add("did");
		ArrayList<String> pal = SortList(fullList);
		for(String s : pal) {
			System.out.println(s);
		}
	}
	
	public static ArrayList<String> SortList(ArrayList<String> fullList) {
		ArrayList<String> pal = new ArrayList<String>();
		for(String s : fullList) {
			if(s.equals(new StringBuilder(s).reverse().toString())) {
				pal.add(s);
			}
		}
		return pal;
	}
	
}
