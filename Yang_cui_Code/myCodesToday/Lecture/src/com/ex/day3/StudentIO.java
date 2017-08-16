package com.ex.day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.ex.pojo.Student;

public class StudentIO {
	static String filename="src/com/ex/files/student.txt";
	
	public void writeStudent(Student s){
		try(BufferedWriter bw= new BufferedWriter(new FileWriter(filename, true));){
				String text="";
				text.concat(s.getFirstname()+":");
				text.concat(s.getLasttname()+":");
				text.concat(s.getEmail()+"\n");
				
				bw.write(text);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void writeStudent(ArrayList<Student> list){
		
		try(BufferedWriter bw= new BufferedWriter(new FileWriter(filename, false));){
			String text="";
			bw.write(text);
		}catch (IOException e){
			e.printStackTrace();
		}
		for(Student s : list)
			writeStudent(s);
	}
	
	public ArrayList<Student> readStudent(){
		ArrayList<Student> list=new ArrayList<Student>();
		try(BufferedReader br= new BufferedReader(new FileReader(filename));){
			Student temp = new Student();
			String line = null;
			while((line=br.readLine())!=null){
				String[] states = line.split(":");
				temp.setFirstname(states[0]);
				temp.setLastname(states[1]);
				temp.setEmail(states[2]);
				list.add(temp);
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	return list;
	}
	
	/*public ArrayList<Student> upDateStudent(String firstname, String lastname, String email){
		ArrayList<Student> list=new ArrayList<Student>();
		list=readStudent();
		Student temp = new Student(firstname,lastname,email);
		list.add(temp);
		return list;
	}*/
	
	public Student findStudent(ArrayList<Student> list, String firstname, String lastname, String email){
		for(int i=0; i<list.size(); i++)
			if(list.get(i).getFirstname().equals(firstname) && list.get(i).getLasttname().equals(lastname) && list.get(i).getEmail().equals(email))
				return list.get(i);
		return null;
	}
	
	public void upDateStudnet(String firstname, String lastname, String email){
		ArrayList<Student> list=new ArrayList<Student>();
		list=readStudent();
		Student s=findStudent(list,firstname,lastname,email);
		s.setFirstname(firstname);
		s.setLastname(lastname);
		s.setEmail(email);
		writeStudent(list);
	}
	
	public void deleteSutdent(String firstname, String lastname, String email){
		ArrayList<Student> list=new ArrayList<Student>();
		list=readStudent();
		Student s=findStudent(list,firstname,lastname,email);
		list.remove(s);
		writeStudent(list);
	}
}
