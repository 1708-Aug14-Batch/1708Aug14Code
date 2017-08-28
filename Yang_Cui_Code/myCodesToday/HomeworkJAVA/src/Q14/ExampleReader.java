package Q14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExampleReader {
	static String filename="Q14/student.txt";
	public static void main(String[] args){
		new ExampleReader();
	}
	
	public ExampleReader(){
		List<String> profile= new ArrayList<String>();
		profile.add("Mickey:Mouse:35:Arizona");
		profile.add("Hulk:Hogan:50:Virginia");
		profile.add("Roger:Rabbit:22:California");
		profile.add("Wonder:Woman:18:Montana");
		
		WrtieNote(profile);
		ArrayList<Student> students =ReadNote();
		for(int i=0; i<students.size(); i++){
			System.out.println("Name: "+students.get(i).getName());
			System.out.println("Age: "+students.get(i).getAge());
			System.out.println("State: "+students.get(i).getState());
		}
	}
	
	public void WrtieNote(List<String> strs){
		try(BufferedWriter bw= new BufferedWriter(new FileWriter(filename, true));){
			String text="";
			for(String info : strs)
				text.concat(info+"\n");
			
			bw.write(text);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<Student> ReadNote(){
		ArrayList<Student> list=new ArrayList<Student>();
		try(BufferedReader br= new BufferedReader(new FileReader(filename));){
			Student temp = new Student();
			String line = null;
			while((line=br.readLine())!=null){
				String[] states = line.split(":");
				temp.setName(states[0]);
				temp.setAge(states[1]);
				temp.setState(states[2]);
				list.add(temp);
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	return list;
	}
}
