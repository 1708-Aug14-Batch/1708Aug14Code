package com.ex.Polymorphism;

public class SettlersOfCatan{
	
	public float total;
	String z;
	
	public float price (float base, float tax) {
		total = base * tax;
		System.out.println("Here is the grand total");
		return total;
	}
	
	public void resources (String x, String y, String z) {
		System.out.println(x + " " + y + " " + z);
	}
	
}
