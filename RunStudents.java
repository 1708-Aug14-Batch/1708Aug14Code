package Day3;

import java.util.ArrayList;
import java.util.Scanner;

public class RunStudents {
	static StudentIO io;
public static void main(String[] args) {
	StudentIO io = new StudentIO();
	Scanner scan = new Scanner(System.in);
	
	
	//System.out.println("Enter (1) Create (2) Update (3) Delete (0) Quit Programm");
	//int choice = scan.nextInt();

	System.out.println("enter your first name");
	String fn = scan.nextLine().trim();
	
	System.out.println("enter your Last name");
	String ln = scan.nextLine().trim();
	
	System.out.println("enter your email");
	String email = scan.nextLine().trim();
	
	
 ArrayList<Student> studentList = io.readStudents();
 System.out.println(studentList.size());
 
	Student student = new Student(fn, ln, email);
	
	studentList.add(student);
	io.writeStudent(studentList);
			
	} 
////	if(choice == 2){
//		System.out.println("What would you like to Update");
//		String update = scan.nextLine().trim();
//		// update file with user input
//		UpdateToFile(getStudents(students, se
//	}
//	while(choice != 0){
//}
	static void getStudents(){
		io = new StudentIO();
		ArrayList<Student> students = io.readStudents();
		for(Student s: students){
			System.out.println(s.toString());
		}
	}
}
