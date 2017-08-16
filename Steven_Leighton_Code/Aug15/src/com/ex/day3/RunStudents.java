package com.ex.day3;

import java.util.ArrayList;
import java.util.Scanner;

public class RunStudents {

	static StudentIO io;

	public static void main(String[] args) {

		getStudents();
		removeStudent();
	}

	static void addStudent(){
		io = new StudentIO();

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter first name: ");
		String fn = scan.nextLine().trim();
		System.out.println("Enter last name: ");
		String ln = scan.nextLine().trim();
		System.out.println("Enter email: ");
		String em = scan.nextLine().trim();

		Student student = new Student(fn,ln,em);

		io.writeStudents(student);
	}

	static void getStudents(){
		io = new StudentIO();
		ArrayList<Student> students = io.getStudents();
		for(Student s : students){
			System.out.println(s.toString());
		}
	}
	
	static void updateStudent(){
		io = new StudentIO();
		ArrayList<Student> students = io.getStudents();
		for(Student s : students){
			System.out.println(s.toString());
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter first name of person you want to update: ");
		String fn = scan.nextLine().trim();
		System.out.println("Choose what to update 'firstname', 'lastname' or 'email'");
		String option = scan.nextLine().trim();
		System.out.println("Enter new entry for " + option + ": ");
		String change = scan.nextLine().trim();
		
		switch(option){
		case "firstname": 
				for (Student student : students) {
					if(student.getFirstname().equalsIgnoreCase(fn)){
						student.setFirstname(change);
						break;
					}
				}
				break;
		case "lastname": 
			for (Student student : students) {
				if(student.getFirstname().equalsIgnoreCase(fn)){
					student.setLastname(change);
					break;
				}
			}
			break;
		case "email":
			for (Student student : students) {
				if(student.getFirstname().equalsIgnoreCase(fn)){
					student.setEmail(change);
					break;
				}
			}
			break;
		}
		
		io.addAllStudents(students);
	}
	
	static void removeStudent(){
		io = new StudentIO();
		ArrayList<Student> students = io.getStudents();
		for(Student s : students){
			System.out.println(s.toString());
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter first name of person you want to remove: ");
		String fn = scan.nextLine().trim();
		System.out.println("Enter last name of person you want to remove: ");
		String ln = scan.nextLine().trim();
		
		for (Student student : students) {
			if(student.getFirstname().equals(fn) && student.getLastname().equals(ln)){
				students.remove(students.indexOf(student));
				io.addAllStudents(students);
				break;
			}
		}
	}
}
