package com.ex.day3;

import java.util.ArrayList;
import java.util.Scanner;

public class RunStudents {
	
	static StudentIO io = new StudentIO();

	public static void main(String[] args) {
		//addStudent();
		//getStudents();
		//deleteStudent();
		updateStudent();
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
		io.deleteFile();
		for(Student s: students) {
			if(!(fn.equals(s.getFirstName()) && ln.equals(s.getLastName()))) {
				io.writeStudent(s);
			}
		}
	}
	
	public static void updateStudent() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter current first name");
		String fn1 = scan.nextLine().trim();
		System.out.println("Please enter new first name");
		String fn2 = scan.nextLine().trim();
		
		System.out.println("Please enter current last name");
		String ln1 = scan.nextLine().trim();
		System.out.println("Please enter new last name");
		String ln2 = scan.nextLine().trim();
		
		System.out.println("Please enter new email");
		String email = scan.nextLine().trim();
		
		io = new StudentIO();
		ArrayList<Student> students = io.readStudents();
		io.deleteFile();
		for(Student s: students) {
			if(fn1.equals(s.getFirstName()) && ln1.equals(s.getLastName())) {
				s.setFirstName(fn2);
				s.setLastName(ln2);
				s.setEmail(email);
			}
		}
		for(Student s: students) {
			io.writeStudent(s);
		}
	}
}
