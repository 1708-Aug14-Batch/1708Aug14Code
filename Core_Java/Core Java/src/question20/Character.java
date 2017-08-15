package question20;

// This class represents a character
public class Character {
	
	private String firstName;
	private String lastName;
	private int age;
	private String residence;
	
	public Character(String firstName, String lastName, int age, String residence) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.residence = residence;
	}
	
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\n" +
				"Age: " + age +  "\n" +
				"State: " + residence + " State" + "\n";
	}

}
