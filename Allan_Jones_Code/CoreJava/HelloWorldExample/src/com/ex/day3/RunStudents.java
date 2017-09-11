package com.ex.day3;

import java.util.ArrayList;
import java.util.Scanner;

import com.ex.pojos.Student;

public class RunStudents {

	static StudentIO io;

	public static void main(String[] args) {
		
		getStudents();

	}

	static void addStudent(){
		io = new StudentIO();
		Scanner scan = new Scanner(System.in);

		System.out.println("enter your first name");
		String fn = scan.nextLine().trim();

		System.out.println("enter your last name");
		String ln = scan.nextLine().trim();

		System.out.println("email");
		String email = scan.nextLine().trim();

		Student student = new Student(fn, ln, email);

		io.writeStudent(student);
	}
	
	static void getStudents(){
		
		io = new StudentIO();
		ArrayList<Student> students = io.readStudents();
		for(Student s: students){
			System.out.println(s.toString());
		}
	}

}
