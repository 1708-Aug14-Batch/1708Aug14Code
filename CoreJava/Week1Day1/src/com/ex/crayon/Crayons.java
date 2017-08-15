package com.ex.crayon;

import com.ex.figure.*;

public class Crayons extends Figures {

	private String colour;

	// Constructor takes attributes from the extended class and adds another
	// attribute called colour
	public Crayons(short sides, short h, short w, short l, short r, Boolean threeDimensional, Boolean isRound,
			String colour) {
		super(sides, h, w, l, r, threeDimensional, isRound);
		this.setColour(colour);
	}

	// getters and setters below
	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	// main method to test and initialize the application
	public static void main(String[] args) {
		short sides = 3;
		short height = 4;
		short width = 0;
		short length = 0;
		short radius = 1;
		Boolean threeDimensional = true;
		Boolean hasRadius = true;
		String colour = "red";

		Crayons redCrayon = new Crayons(sides, height, width, length, radius, threeDimensional, hasRadius, colour);

		System.out.println("Height of the crayon - " + redCrayon.getHeight());
		System.out.println("Colour of the crayon - " + redCrayon.getColour());
	}

}
