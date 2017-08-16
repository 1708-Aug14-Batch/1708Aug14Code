package com.ex.day3;

import java.util.ArrayList;
import java.util.Scanner;

public class RunStudents {
	
	static StudentIO io = new StudentIO();

	public static void main(String[] args) {
//		addStudent();
//		getStudents();
		deleteStudent();
	}
	
	public static void addStudent() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("please enter your first name");
		String fn = scan.nextLine().trim();
		
		System.out.println("please enter your last name");
		String ln = scan.nextLine().trim();
		
		System.out.println("please enter your email");
		String email = scan.nextLine().trim();
		
		Student student = new Student(fn, ln, email);
		
		io.writeStudent(student);
	}
	
	public static void getStudents() {
		io = new StudentIO();
		ArrayList<Student> students = io.readStudents();
		for(Student s: students) {
			System.out.println(s.toString());
		}
	}
	
	public static void deleteStudent() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("please enter first name to delete");
		String fn = scan.nextLine().trim();

		System.out.println("please enter last name to delete");
		String ln = scan.nextLine().trim();

		io = new StudentIO();
		ArrayList<Student> students = io.readStudents();
		for(Student s: students) {
			System.out.println("check for student to delete");
		}
	}
}
