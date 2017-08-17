package Q20;

public class Person {
	private String firstname;
	private String lastname;
	private String state;
	private int age;
	
	public Person() {
		super();
	}
	public Person(String firstname, String lastname, int age, String state) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.state = state;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
