package question.twenty;

public class Person {
	
	String fname = "";
	String lname = "";
	int age = 0;
	String area = "";
	
	Person() {
		this.fname = "";
		this.lname = "";
		this.age = 0;
		this.area = "";
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
