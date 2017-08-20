package question7;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;




/**
 * Sort two employees based on their name, department, and age using the
 * Comparator interface.
 * 
 * @author Joshua Wurdemann
 * @version 8/15/2017
 */
public class Employee implements Comparable<Employee> {

	private String myName;
	private String myDepartment;
	private int myAge;

	/**
	 * 
	 * @param theName
	 * @param theDeparment
	 * @param theAge
	 */
	public Employee(final String theName, final String theDeparment, final int theAge) {
		myName = theName;
		myDepartment = theDeparment;
		myAge = theAge;

	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public String getMyDepartment() {
		return myDepartment;
	}

	public void setMyDepartment(String myDepartment) {
		this.myDepartment = myDepartment;
	}

	public int getMyAge() {
		return myAge;
	}

	public void setMyAge(int myAge) {
		this.myAge = myAge;
	}

	/**
	 * Overrides instance variables to a string.
	 */

	@Override
	public String toString() {
		return "Employee [myName=" + myName + ", myDepartment=" + myDepartment + ", myAge=" + myAge + "]";
	}

	@Override
	public int compareTo(Employee arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

//	/**
//	 * Class is used for sorting Name in ascending order.
//	 */
//	/*class SortByName implements Comparator<Employee> {
//
//		@Override
//		public int compare(Employee a, Employee b) {
//			return a.myName.compareTo(b.myName);
//		}
//	}
//	class SortByDepartment implements Comparator<Employee> {
//
//		/** Sorts Employee by department name in ascending order. */
//		public int compare(Employee a, Employee b) {
//			return a.myDepartment.compareTo(b.myDepartment);
//		}
//	}
//	class SortByAge implements Comparator<Employee> {
//		/** Sorts Employee by department name in ascending order. */
//		public int compare(Employee a, Employee b) {
//			return a.myAge - b.myAge;
//		}
//
//	}
//     class main {
//		public main(String[] args) {
//			ArrayList<Employee> newEmployee = new ArrayList<>();
//			newEmployee.add(new Employee("John", "Finance", 59));
//			newEmployee.add(new Employee("Sally", "Administration", 22));
//
//			Collections.sort(newEmployee, ());
//			System.out.println("\nSorted by ");
//		
//		 for(int i = 0; i < newEmployee.size(); i++){
//			 System.out.println(newEmployee.get(i));
//			 
//		 }
//		
//		}
//}

	
}
