package com.ex.homework1JavaOOP;

import java.util.ArrayList;

//ChineseRestaurant inherits from Restaurant

public class ChineseRestaurant extends Restaurant{

	@Override
	public void sellProducts() {
		// TODO Auto-generated method stub
		System.out.println("Sells Chinese Food");
	}

	//cooksFood is overridden
	@Override
	public void cooksFood() {
		// TODO Auto-generated method stub
		System.out.println("Cooks Chinese Food");
	}

	// Encapsulation, getter and setter
	
	private ArrayList<String> menu = new ArrayList<>();

	public ArrayList<String> getMenu() {
		return menu;
	}

	public void addToMenu(String food) {
		menu.add(food);
	}
	
}
