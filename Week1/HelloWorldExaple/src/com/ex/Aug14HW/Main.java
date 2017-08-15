package com.ex.Aug14HW;

public class Main {

	public static void main(String[] args) {
		Alcoholic beer = new Alcoholic();
		Beverage rum = new Alcoholic("750ml", 40.0);		
		Purchasable water = new Beverage();
		beer.purchase();
		rum.purchase();
		water.purchase();
		
		

	}

	
}
