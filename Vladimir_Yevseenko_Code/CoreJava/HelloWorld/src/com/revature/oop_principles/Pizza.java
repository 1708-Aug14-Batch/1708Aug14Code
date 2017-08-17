package com.revature.oop_principles;

public class Pizza extends Food {
	private int diameter;
	private String[] toppings;

	public Pizza(int diameter, String[] toppings) {
		this.diameter = diameter;
		this.toppings = new String[toppings.length];
		for (int i=0; i<toppings.length; i++)
			this.toppings[i] = toppings[i];
		
		/*
		 * all pizza is a 6 in my book
		 */
		setTastiness(6);
	}
	
	public void eat() {
		System.out.print("Managed to eat all 12 slices "
				+ "of this " + getSize() + " pizza with ");
		for (int i=0; i<toppings.length; i++) {
			System.out.print(toppings[i] +
					(i == toppings.length - 1 ? "" : ", "));
		}
		System.out.println(" on it");
	}
	
	public String getSize() {
		if (diameter > 10)
			return "large";
		else if (diameter > 6)
			return "medium";
		else
			return "small";
	}
}