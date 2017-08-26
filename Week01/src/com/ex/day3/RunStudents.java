package com.ex.day3;

import java.util.ArrayList;
import java.util.Scanner;

import com.ex.pojos.Student;

public class RunStudents {
	
	static StudentIO io;
	static Scanner scanner;

	public static void main(String[] args) {
		updateStudent();
	}

	private static void addStudent() {
		io = new StudentIO();
		scanner = new Scanner(System.in);
		System.out.println("Enter your first name >");
		String firstName = scanner.nextLine().trim();
		System.out.println("Enter your last name >");
		String lastName = scanner.nextLine().trim();
		System.out.println("Enter your email >");
		String email = scanner.nextLine().trim();
		Student student = new Student(firstName, lastName, email);
		io.writeStudent(student);
		scanner.close();
	}
	
	static void getStudents() {
		io = new StudentIO();
		ArrayList<Student> students = io.readStudents();
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}
	
	static void updateStudent() {
		io = new StudentIO();
		scanner = new Scanner(System.in);
		boolean studentFound = false;
		Student student;
		do {
			System.out.print("Which student do you want to update? >");
			String searchCriterion = scanner.nextLine();
			student = io.findStudent(searchCriterion);
			if (student != null) {
				studentFound = true;
			}
		} while (!studentFound);
		System.out.print("Do you want to change first name, last name, or email? >");
		String response = scanner.nextLine();
		switch (response.toLowerCase()) {
		case "first name":
			System.out.print("Enter new first name >");
			student.setFirstName(scanner.nextLine());
			break;
		case "last name":
			System.out.print("Enter new last name >");
			student.setLastName(scanner.nextLine());
			break;
		case "email":
			System.out.print("Enter new email >");
			student.setEmail(scanner.nextLine());
			break;
		}
		io.updateStudent(student);
		System.out.println("Student updated");
	}
	
	static void destroyStudent() {
		io = new StudentIO();
		Student student;
		boolean studentFound = false;
		do {
			System.out.print("Which student do you want to delete? >");
			String searchCriterion = scanner.nextLine();
			student = io.findStudent(searchCriterion);
			if (student != null) {
				studentFound = true;
			}
		} while (!studentFound);
		io.destroyStudent(student);
		System.out.println("Student deleted");
	}

}
