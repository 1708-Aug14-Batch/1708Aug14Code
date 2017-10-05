package com.ex.vechiles;

//import com.ex.interfaces.Driveable;
import static java.lang.Math.sqrt;

public abstract class Car implements com.ex.interfaces.Driveable{
	
	//abstraction and inheritance
	public int h=101;
	public Car(){
		System.out.println("at");
	}
	
	public double stop(double mph){
		double time=sqrt(mph);
		return time/2;
	}
}
