package daythree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SingletonImplementation {

	public static void main(String[] args) {
		
		List<String> arr1 = new ArrayList<>(Arrays.asList("tom", "tom", "tom", "joy","mary", "dan"));
		
		printMatches((ArrayList<String>) arr1, "tom");
		
	}
	
	static void printMatches(ArrayList<String> list, String target) {
		
		//uses a single instance of stream to filter the words in
		//the ArrayList list 
		List<String> matches = list.stream().filter(word -> word.equals(target)).collect(Collectors.toList());
		matches.forEach(System.out::println);
	}

}
