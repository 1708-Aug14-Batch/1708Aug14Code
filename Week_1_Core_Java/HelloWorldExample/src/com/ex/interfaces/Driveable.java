package com.ex.interfaces;

public interface Driveable {
	//interfaces have implied keywords. You can take away abstract from the steer method and it knows its abstract because its an interface
	public void steer();
	
	public double stop(double mph);
	
	public void start();
	
}
