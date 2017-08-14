package com.ex.homework1JavaOOP;

import java.util.ArrayList;

public class ChineseRestaurant extends Restaurant{

	@Override
	public void sellProducts() {
		// TODO Auto-generated method stub
		super.sellProducts();
	}

	@Override
	public void cooksFood() {
		// TODO Auto-generated method stub
		System.out.println("Cooks Chinese Food");
	}

	private ArrayList<String> menu = new ArrayList<>();

	public ArrayList<String> getMenu() {
		return menu;
	}

	public void addToMenu(String food) {
		menu.add(food);
	}
	
}
