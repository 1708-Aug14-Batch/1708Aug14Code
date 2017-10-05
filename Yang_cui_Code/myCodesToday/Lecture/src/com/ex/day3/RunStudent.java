package com.ex.day3;

import java.util.Scanner;

import com.ex.pojo.Student;

public class RunStudent {
	public static void main(String[] args){
		StudentIO io=new StudentIO();
		Scanner scan =new Scanner(System.in);
		System.out.println("please enter your first name:");
		String fn =scan.nextLine().trim();
		System.out.println("please enter your last name:");
		String ln =scan.nextLine().trim();
		System.out.println("please enter your email");
		String email =scan.nextLine().trim();
		
		Student student= new Student(fn,ln,email);
		
		io.writeStudent(student);
	}
}
