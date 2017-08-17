package com.ex.pojos;

import java.util.ArrayList;
import java.util.Scanner;

public class RunStudents {
	
	static StudentIO io;
	
	public static void main(String[] args) {
		
		//addStudent();
		getStudents();
		
		//adds two new students
		addStudent("Dude","Surfer", "surf4lifeman@gmail.com");
		addStudent("Lilly","Gales", "gwind@gmail.com");
		//getStudents();
		
		//deletes or replaces the specified student email line with " "
		io.deleteStudentEmail("src/com/ex/files/oneStudentEmailDeleted.txt", "gwind@gmail.com");
		
		//updates the specified email with the new email in a new file for comparison
		io.updateStudentEmail("src/com/ex/files/oneStudentEmailUpdated.txt", "surf4lifeman@gmail.com", "dude4surf@gmail.com");
		//getStudents();
		
	}
	
	static void addStudent() {
		io = new StudentIO();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your first name");
		String fn = scan.nextLine().trim();
		
		System.out.println("Enter your last name");
		String ln = scan.nextLine().trim();
		
		System.out.println("email");
		String email = scan.nextLine().trim();
		
		Student student = new Student(fn, ln, email);
		
		//writes to the file containing students
		io.writeStudent(student);
		scan.close();
	}
	
	//overloads the addStudent method with new method signature & implementation
	static void addStudent(String fname, String lname, String email) {
		Student nStudent = new Student(fname,lname,email);
		io.writeStudent(nStudent);
	}
	
	//prints the students placed into an ArrayList students in String form
	static void getStudents() {
		io = new StudentIO();
		ArrayList<Student> students = io.readStudents();
		for(Student s: students) {
			System.out.println(s.toString());
		}
	}

}
