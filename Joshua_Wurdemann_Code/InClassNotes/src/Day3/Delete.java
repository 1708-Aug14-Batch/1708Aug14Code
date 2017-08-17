package Day3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Delete {
ArrayList<String> list = new ArrayList<String>();
list.add("Hello");
list.add("Welcome to my java");



public static void writeToFile(ArrayList<String> list){
	try {
		BufferedWriter writer =  new BufferedWriter(new FileWriter(
			"student.txt"));
			for(String x: list){
				writer.write(x);
				writer.newLine();
			}
		} catch (IOException e){
			e.getStackTrace();
			
		
		}
	}


public static void deleteFromFile(ArrayList<String> list, String search) {
	System.out.println(list.toString());
	
	for(int i = 0; i <list.size(); i++){
		if(list.get(i).equals(search)){
		 list.remove(i);
		 writeToFile(list);
		}
	}
}
public static void UpdateToFile(ArrayList<String> list, String search, String update) {
	System.out.println(list.toString());
	
	for(int i = 0; i <list.size(); i++){
		if(list.get(i).equals(search)){
		 list.set(i, update);
		 writeToFile(list);
		}
	}
}

}