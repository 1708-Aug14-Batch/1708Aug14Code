package com.day3;


import java.util.ArrayList;
import java.util.Scanner;

import com.ex.pojos.Student;

public class RunStudent {

	static StudentIO s = new StudentIO();
	private static Scanner scan;

	public static void main(String[] args) {
	}
	
	static void addStudent() {
		StudentIO s = new StudentIO();

		scan = new Scanner(System.in);

		System.out.println("Eneter first name: ");
		String fn = scan.nextLine().trim();

		System.out.println("Enter your last name: ");
		String ln = scan.nextLine().trim();

		System.out.println("Enter your email: ");
		String em = scan.nextLine().trim();

		Student student = new Student(fn, ln, em);

		s.writeStudents(student);
	}
	
	static void getStudent() {
		s = new StudentIO();
		ArrayList<Student> list = s.readStudents();
		for(Student s:list) {
			System.out.println(s.toString());
		}
	}
	
	static void updateStudent(ArrayList<Student> studs) {
		s = new StudentIO();
		s.updateStudents(studs);	
	}
	
	static void deleteStudent(Student student) {
		s = new StudentIO();
		ArrayList<Student> list;
		list = s.deleteStudent(student);
		s.updateStudents(list);
	}
	

}
