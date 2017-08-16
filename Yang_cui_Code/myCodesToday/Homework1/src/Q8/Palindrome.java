package Q8;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
	public static void main(String[] args){
		new Palindrome();
	}
	
	public Palindrome(){
		String[] someWords = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"};
		List<String> wordList = new ArrayList<String>();
		List<String> palindrome=new ArrayList<String>();
		
		for(int i=0; i<someWords.length; i++)
			wordList.add(someWords[i]);
		
		for(int i=0; i<wordList.size(); i++)
			if(isPalindrome(wordList.get(i)))
				palindrome.add(wordList.get(i));
		
		for(int i=0; i<palindrome.size(); i++)
			System.out.println(palindrome.get(i));
	}
	
	public boolean isPalindrome(String word){
		char[] charArray = word.toCharArray();
		for(int i=0; i<=charArray.length/2; i++)
			if(charArray.length>=i)
				if(charArray[i]==charArray[charArray.length-1-i]);
				else
					return false;
			else break;
		return true;
	}
}
