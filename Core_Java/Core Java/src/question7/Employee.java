package question7;

public class Employee implements Comparable {
	
	private String name;
	private Department department;
	private int age;
	
	public Employee(String name, Department department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

	@Override
	public int compareTo(Object arg0) {
		
		// Make certain the object is an employee
		if (arg0.getClass() != Employee.class)
			return 0;
		
		Employee emp = (Employee) arg0;
		
		if (name.equals(emp.getName())) {
			if (age == emp.getAge()) {
				if (department == emp.getDepartment())
					return 0;
			} else if (age < emp.getAge())
				return -1;
			else return 1;
		} else return lesserAge(name, emp.getName());
		
		return 0;
	}
	
	// Return -1 for an earlier alphabetical name, 1 for a later alphabetical name
	private int lesserAge(String name1, String name2) {
		for (int i = 0; i < Math.min(name1.length(), name2.length()); i++) {
			if (name1.charAt(i) < name2.charAt(i))
				return -1;
			else if (name1.charAt(i) > name2.charAt(i))
				return 1;
		}
		
		return 0;
	}

	public String getName() {
		return name;
	}

	public Department getDepartment() {
		return department;
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return "Employee: " + name + ", age: " + age +
				". Works in department: " + department;
	}
}
