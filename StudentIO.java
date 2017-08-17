package Day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentIO {
	static String filename =  "student.txt";
	public void writeStudent(ArrayList<Student> studentList){

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){

			for(Student student : studentList) {
				String text = "";
				text = text.concat(student.getFirstname() + ":");
				text = text.concat(student.getLastname() + ":");
				text = text.concat(student.getEmail());

				bw.write(text);
				bw.newLine();
				bw.flush();
			}
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	public ArrayList<Student> readStudents(){
		ArrayList<Student> list = new ArrayList<Student>();

		try(BufferedReader br = new BufferedReader(new FileReader(filename));){

			String line = null;

			while ((line = br.readLine()) != null){
				if(line.equals("")) {
					continue;
				}
				Student temp = new Student();
				String[] states = line.split(":");
				temp.setFirstname(states[0]);
				temp.setLastname(states[1]);
				temp.setEmail(states[2]);
				list.add(temp);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}

		return list;
	}
	/**
	 *  Update file by search specific index and if the location is found then replace the string with user input.
	 * @param list
	 * @param search
	 * @param update
	 */
	public  void UpdateToFile(ArrayList<Student> studentList, int index , Student updateStudent) {
		System.out.println(updateStudent.toString());

		studentList.remove(index);
		studentList.add(index, updateStudent);

		writeStudent(studentList);
	}
	public  void DeleteFromFile(ArrayList<Student> studentList, int index , Student deleteStudent) {
		System.out.println(deleteStudent.toString());

		studentList.remove(index);
		
		writeStudent(studentList);
	}
}


