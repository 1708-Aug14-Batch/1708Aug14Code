package questionEight;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestionEight {
	public static boolean palandrome(String word) {
		//check will check if the word is a palandrome
		boolean check = false;
		//find the length of the word
		int length = word.length();
		int middle =0;
		if(length%2==0) {
			middle = length/2;
		}
		else {
			middle = (length+1)/2;
		}
		
		for(int i=0;i< middle;i++) {
			char[] palan = word.toCharArray();
			if(palan[i]==palan[length-i]) {
				check = true;
			}
			else {
				check = false;
				break;
			}
		}
		return check;
		
	}
	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<>();
		ArrayList<String> palandromes = new ArrayList<>();
		
		strings.addAll(Arrays.asList("karan","madam","tom","civic","radar","sexes","jimmy","kayak","refer","billy","did"));
		
	}

}
