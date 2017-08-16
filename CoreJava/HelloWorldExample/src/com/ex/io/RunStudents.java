package com.ex.io;

import java.util.ArrayList;
import java.util.Scanner;

import com.ex.pojos.Student;

public class RunStudents {


	static StudentIO sio = new StudentIO();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//writeStudents();
		//deleteStudent();
		updateStudent();
		getStudents();
	}
	
	static void updateStudent() {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Account First Name to update");
		
		String fn = scan.nextLine().trim();
		
		System.out.println("Enter Account Last Name to update");
		
		String ln = scan.nextLine().trim();
		
		System.out.println("Enter New Email");
		
		String em = scan.nextLine().trim();
		
		sio.updateStudent(fn, ln, em);
	}
	
	static void deleteStudent() {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter First Name to Delete");
		
		String fn = scan.nextLine().trim();
		
		System.out.println("Enter Last Name to Delete");
		
		String ln = scan.nextLine().trim();
		
		sio.deleteStudent(fn, ln);
	}
	
	static void getStudents() {
		//sio = new StudentIO();
		ArrayList<Student> students = sio.readStudents();
		for(Student s:students) {
			System.out.println(s);
		}
	}
	
	static void writeStudents() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter First Name");
		
		String fn = scan.nextLine().trim();
		
		System.out.println("Enter Last Name");
		
		String ln = scan.nextLine().trim();
		
		System.out.println("Enter Email");
		
		String em = scan.nextLine().trim();

		Student student = new Student(fn, ln, em);
		
		sio.writeStudent(student);
	}

}
