package com.ex.day4;

import com.ex.vehicles.*;

public class VehicleFactory {
	public Vehicle getVehicle(String s){
		if(s.equalsIgnoreCase("Car")){
			return new Cars();
		}
		else if(s.equalsIgnoreCase("Truck")){
			return new Trucks();
		}
		return null;
		
		
	}

}
