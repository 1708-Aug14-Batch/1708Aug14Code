package questionEight;

import java.util.ArrayList;
import java.util.Arrays;

public class Palindromes {
	public static boolean palandrome(String word) {
		//check will check if the word is a palindrome
		boolean check = false;
		//find the length of the word
		int length = word.length();
		int middle =0;
		//create midde variable, this will be used to find the index of
		//the middle of the word (this is a letter for words with odd lengths
		//and between letters for words with even lengths)
		if(length%2==0) {
			middle = length/2;
			//if the word's length is even, l/2 returns an int
		}
		else {
			middle = (length+1)/2;
			//if the word's length is odd, length+1 / 2 returns an int
		}
		
		for(int i=0;i< middle;i++) {
			//loops through the first half of the word, it is not necessary
			//to go through the entire word
			char[] palan = word.toCharArray();
			//creates a character array for the word
			if(palan[i]== palan[length-1-i]) {
				//This compares the current letter and the letter the same distance from the other end
				//if this is true, then the word could be a palindrome
				//however, it is required to check through the rest of the word
				check = true;
			}
			else {
				//If the letter does not pass the test,
				//the word is definitely not a palindrome,
				//so we need not loop through the rest of the letters
				check = false;
				break;
				//break out of the for loop
			}
		}
		return check;
		//this returns the result of palindrome testing
		
	}
	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<>();
		//creates an arrayList to hold all the words
		ArrayList<String> palandromes = new ArrayList<>();
		//creates an arrayList to hold just palindromes
		strings.addAll(Arrays.asList("karan","madam","tom","civic","radar","sexes","jimmy","kayak","refer","billy","did"));
		//adds all the strings to the strings ArrayList
		for(String index:strings) {
			//puts each string through palindrome testing
			if(palandrome(index)) {
				//if it is a palindorme, palandrom(index) returns true
				palandromes.add(index);
				//this element is added to the palindromes ArrayList
			}
		}
		for(String i: strings) {
			//this simply prints out each element of Strings to test that they are
			//all successfully added
			System.out.print(i+" ");
		}
		System.out.println(" ");
		for(String i: palandromes) {
			//this prints out every element of palindormes to ensure they are all correct
			System.out.print(i+" ");
		}
	}

}
