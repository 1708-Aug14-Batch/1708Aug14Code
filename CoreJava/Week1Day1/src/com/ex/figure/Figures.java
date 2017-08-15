package com.ex.figure;

import com.ex.shapes.*;

public class Figures extends Shapes{
	
	private short numSides;
	private short height;
	private short width;
	private short length;
	private short radius;
	private Boolean isThreeDimensional;
	private Boolean hasRadius;
	
	public Figures(short sides , short h, short w, short l, short r, Boolean threeDimensional, Boolean isRound) {
		this.setNumSides(sides);
		this.setHeight(h);
		this.setWidth(w);
		this.setLength(l);
		this.setRadius(r);
		this.setIsThreeDimensional(threeDimensional);
		this.setHasRadius(isRound);
	}
	public short getNumSides() {
		return this.numSides;
	}
	
	@Override
	public void setNumSides(Short sides) {
		this.numSides = sides;
		
	}
	
	public short getHeight() {
		return height;
	}
	
	public void setHeight(short height) {
		this.height = height;
	}
	
	public short getWidth() {
		return width;
	}
	
	public void setWidth(short width) {
		this.width = width;
	}
	
	public short getLength() {
		return length;
	}
	
	public void setLength(short length) {
		this.length = length;
	}
	
	public short getRadius() {
		return radius;
	}
	
	public void setRadius(short radius) {
		this.radius = radius;
	}
	
	public Boolean getIsThreeDimensional() {
		return isThreeDimensional;
	}
	
	public void setIsThreeDimensional(Boolean isThreeDimensional) {
		this.isThreeDimensional = isThreeDimensional;
	}
	
	public Boolean getHasRadius() {
		return hasRadius;
	}
	
	public void setHasRadius(Boolean hasRadius) {
		this.hasRadius = hasRadius;
	}
	
}

