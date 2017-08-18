package question.eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PrintPalindromesUsingAL {

	public static void main(String[] args) {
	
		List<String> normal = new ArrayList<>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"));
		
		palidrome((ArrayList<String>) normal);

	}
	
	static void palidrome(ArrayList<String> list) {
		
		List<String> palindromes = list.stream().filter(word ->
		{
			for(int i = 0; i < word.length(); i++) {
				if (word.charAt(i) != word.charAt(word.length() - (i+1))) {
					return false;
				}
			}
			return true;
		}
				).collect(Collectors.toList());
		System.out.println(palindromes);
	}
	

}
