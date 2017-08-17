package question.seven;

public class SortWithComparingInterface {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee("James Paul", "Computer Science", 20);
		Employee emp2 = new Employee("James Homes", "Mathematics", 25);
		
		Employee emp3 = new Employee("Abby Gales", "Music", 30);
		Employee emp4 = new Employee("Rowan Thomas", "Mathematics", 26);
		
		sortByNameLeastToGreat(emp1, emp2);
		emp1.compareToAge(emp2);
		emp1.compareToDept(emp2);
		
		//String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

	}
	
	static void sortByNameLeastToGreat(Employee emp1, Employee emp2) {
		int result = emp1.compareToName(emp2);
		switch(result) {
		case -1: System.out.println(emp1.getName());
				 System.out.println(emp2.getName());
				 break;
		case 0: System.out.println(emp1.getName() + " " + emp2.getName());
				break;
		case 1: System.out.println(emp2.getName());
		}
	}

}
