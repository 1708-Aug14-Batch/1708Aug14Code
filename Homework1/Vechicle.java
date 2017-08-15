package Homework1;
/** defines the general features of types of Vehicles.
 * 
 * @author joshwurdemann
 *@version 8/15/2017
 */
public class Vechicle implements Vehicle{
	private int   myWheel;
	private int myDoor;
	private int startPoint;
/** 
 * 
 * @param theWheel
 * @param theDoor
 */

	public Vechicle(final int theWheel, final int theDoor){
		
	this.myWheel = theWheel;
	this.myDoor = theDoor;
				
	}
	

/**
 * Prints out the starting point
 */
	@Override
	public void startPoint() {
	
		System.out.print("Start");

	}
	public int getStartPoint(){
		
		return startPoint;
	}

@Override
	public String toString() {
		return "Vechicle [myWheel=" + myWheel + ", myDoor=" + myDoor + ", startPoint=" + startPoint + "]";
	}
public int getMyWheel() {
	return myWheel;
}
public void setWheel(final int theWheel){
	this.myWheel = theWheel;
}
public int getDoor() {
	return myDoor;
}
public void setDoor(final int theDoor){
	this.myDoor = theDoor;
}
}