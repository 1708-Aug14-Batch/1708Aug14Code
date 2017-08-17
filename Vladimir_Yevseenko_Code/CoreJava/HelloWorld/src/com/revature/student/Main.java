package com.revature.student;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	private static final String path = "src/com/revature/student/students.txt";
	private static Scanner scanner = new Scanner(System.in);
	private static StudentIO studentIO = new StudentIO();
	
	public static void main(String[] args) {
		boolean running = true;
		while(running) {
			System.out.println("add - add a student, rm - remove a student, replace - replace a student, display - display students, q - quit");
			System.out.print("Enter a choice: ");
			switch(scanner.nextLine()) {
				case "q": running = false; break;
				case "add": addStudent(); break;
				case "rm": removeStudent(); break;
				case "replace": replaceStudent(); break;
				case "display": displayStudents(); break;
			}
		}
		System.out.println("Goodbye!");
		scanner.close();
	}
	
	public static void addStudent() {
		System.out.print("First: ");
		String first = scanner.nextLine().trim();
		System.out.print("Last: ");
		String last = scanner.nextLine().trim();
		System.out.print("Email: ");
		String email = scanner.nextLine().trim();
		studentIO.writeStudent(path, new Student(first, last, email));
		System.out.println("Student successfully added\n");
	}
	
	public static void removeStudent() {
		System.out.print("First: ");
		String first = scanner.nextLine().trim();
		System.out.print("Last: ");
		String last = scanner.nextLine().trim();
		System.out.print("Email: ");
		String email = scanner.nextLine().trim();
		try {
			studentIO.removeStudent(path, new Student(first, last, email));
		} catch (NoSuchElementException ex) {
			System.out.println("No such student found.\n");
		}
		System.out.println("Student successfully replaced\n");
	}
	
	public static void replaceStudent() {
		System.out.print("To replace first: ");
		String first1 = scanner.nextLine().trim();
		System.out.print("To replace last: ");
		String last1 = scanner.nextLine().trim();
		System.out.print("To replace email: ");
		String email1 = scanner.nextLine().trim();
		
		System.out.print("Replacement first: ");
		String first2 = scanner.nextLine().trim();
		System.out.print("Replacement last: ");
		String last2 = scanner.nextLine().trim();
		System.out.print("Replacement email: ");
		String email2 = scanner.nextLine().trim();
		try{
			studentIO.replaceStudent(path, new Student(first1, last1, email1), new Student(first2, last2, email2));
		} catch (NoSuchElementException ex) {
			System.out.println("No such student found.\n");
		}
		System.out.println("Student successfully replaced\n");
	}
	
	public static void displayStudents() {
		ArrayList<Student> students = studentIO.readStudents(path);
		for (Student s: students)
			System.out.println(s);
		System.out.println();
	}
}