package com.ex.InheritancePrinciple;

import com.ex.AbstractionPrinciple.Games;

public class Monopoly extends Games{
	
	public float total;
	
	public float price (float x, float y) {
		total = x * y;
		return total;
	}
	
	public void resources (String x, String y) {
		System.out.println("no resources");
	}
}
