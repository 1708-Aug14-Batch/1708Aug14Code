package question18;
/**
 * Write a program having a concrete subclass that inherits three abstract methods from a superclass. 
 *  Provide the following three implementations
 *  in the subclass corresponding to the abstract methods in the superclass: 
 *  1.	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
2.	Convert all of the lower case characters to uppercase in the input string, and return the result. 
3.	Convert the input string to integer and add 10, output the result to the console.

 * @author josh wurdemann
 *@version 8/20/2017
 */
public abstract class Animal {

	private int myNumberOfLegs;
	private String myHairColor;
	private String myName;
	private String myLocation;
	private int    myNumberOfDogs;
	private int    myPopulation;
	



public Animal(int theNumberOfLegs, String theHairColor, String theName, 
		String theLocation, int theNumberOfDogs, int thePopulation){
	
	myNumberOfLegs = theNumberOfLegs;
	myHairColor = theHairColor;
	myName = theName;
	setMyLocation(theLocation);
	myNumberOfDogs = theNumberOfDogs;
	myPopulation = thePopulation;
	
}

public String getMyName() {
		return myName;
	}


	public void setMyName(String myName) {
		this.myName = myName;
	}

public int getMyNumberOfLegs() {
	return myNumberOfLegs;
}


public void setMyNumberOfLegs(int myNumberOfLegs) {
	this.myNumberOfLegs = myNumberOfLegs;
}


public String getMyHairColor() {
	return myHairColor;
}


public void setMyHairColor(String myHairColor) {
	this.myHairColor = myHairColor;
}
public abstract String getMyLocation();

public int getMyNumberOfDogs() {
	return myNumberOfDogs;
}

public void setMyNumberOfDogs(int myNumberOfDogs) {
	this.myNumberOfDogs = myNumberOfDogs;
}

public int getMyPopulation() {
	return myPopulation;
}

public void setMyPopulation(int myPopulation) {
	this.myPopulation = myPopulation;
}

public void setMyLocation(String myLocation) {
	this.myLocation = myLocation;
}

@Override
public String toString() {
	return "Animal [myNumberOfLegs=" + myNumberOfLegs + ", myHairColor=" + myHairColor + ", myName=" + myName
			+ ", myLocation=" + myLocation + "]";
}

/** determines if in fact an animal.*/
public abstract boolean isAnimal(int s);
 /**Calculates the number of a given animal in certain location.*/
public abstract void calculateNumberAnimals(int animal, int population);

public abstract boolean isUpper(String s);

public abstract String convertToLowerCase(String s);

public abstract int convertStringtoInt(String s);


}