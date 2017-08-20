package question20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**Create a notepad file called Data.txt and enter the following: 
Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana

Write a program that would read from the file and print it out to the screen in the following format:

Name: Mickey Mouse
Age: 35 years
State: Arizona State
*/

public class Person {
	private String myFirstName;
	private String myLastName;
	private String myAge;
	private String  myState;
	
	public Person(){};
	
	public Person(String myFirstName, String myLastName, String myAge, String myState) {
		//super();
		this.myFirstName = myFirstName;
		this.myFirstName = myLastName;
		this.myAge = myAge;
		this.myState = myState;
	}

	public String getMyFirstName() {
		return myFirstName;
	}

	public void setMyFirstName(String myFirstName) {
		this.myFirstName = myFirstName;
	}

	public String getMyLastName() {
		return myLastName;
	}

	public void setMyLastName(String myLastName) {
		this.myLastName = myLastName;
	}

		public String getMyAge() {
		return myAge;
	}
	public void setMyAge(String myAge) {
		this.myAge = myAge;
	}
	public String getMyState() {
		return myState;
	}
	public void setMyState(String myState) {
		this.myState = myState;
	}

	@Override
	public String toString() {
		return "Person [myFirstName=" + myFirstName + ", myLastName=" + myLastName + ", myAge=" + myAge + ", myState="
				+ myState + "]";
	}

	
}
