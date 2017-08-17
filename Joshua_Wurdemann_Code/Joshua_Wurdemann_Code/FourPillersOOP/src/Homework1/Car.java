package Homework1;

public class Car extends Vechicle {
 private final String myName;
	public Car(final int theWheel, final int theDoor, final String theName) {
		super(theWheel, theDoor);
		myName = theName;
		
	}
	public String getMyName() {
		return myName;
	}
	@Override
	public String toString() {
		return "Car myName=" + myName;
	}
   
	@Override
	
	public int getDoor(){
		
		return super.getDoor();
	}
}