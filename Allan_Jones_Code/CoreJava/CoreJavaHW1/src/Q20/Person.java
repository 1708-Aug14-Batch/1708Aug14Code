package Q20;

public class Person {
	private String firstName;
	private String lastName;
	private String age;
	private String state;
	
	public Person() {}
	
	public Person(String firstName, String lastName, String age, String state) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.state = state;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
