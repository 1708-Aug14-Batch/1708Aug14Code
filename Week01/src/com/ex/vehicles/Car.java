/**
 * 
 */
package com.ex.vehicles;

import com.ex.interfaces.Driveable;
import static java.lang.Math.*;

/**
 * @author will
 *
 */
public abstract class Car implements Driveable {
// abstraction
	
	public Car() {
		System.out.println("In car constructor");
	}

	public double stop(double mph) {
		double seconds = sqrt(mph);
		return seconds / 2;
	}

}
