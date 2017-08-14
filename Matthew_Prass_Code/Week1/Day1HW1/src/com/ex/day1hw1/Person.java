package com.ex.day1hw1;

//Abstraction and inheritance 
public abstract class Person implements Moveable
{
	int step;
	
	//Abstraction
	public abstract void doAThing();
	
	
	//Inheritance
	public void move(int speed)
	{
		step+=speed;
	}
	
	public void stop()
	{
		step = 0;
	}
}
