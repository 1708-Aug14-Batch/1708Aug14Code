package question5;
/**Write a substring method that accepts a string str and 
 * an integer idx and returns the substring contained between
 *  0 and idx-1 inclusive.  Do NOT use any of the existing substring
 * methods in the String, StringBuilder, or StringBuffer APIs.
 * 
 * @author JoshuaWurdemann
 *@version 8/15/2017
 */
public class SubStringMethod {
 public static void main(String [] args ){
	 String str = "Baseball";
	 int idx = 5 ;
	 
	
	 System.out.println(getSubString(str, idx));
 }
 /**
  *  Substring method that accepts a string and returns the substring.
  * @param s
  * @param imb
  * @return
  */
 public static String getSubString(String s, int imb){
	 char[] newString = s.toCharArray();
	String  result = "";
	 for(int i = 0; i < imb -1 ; i++){
		
		 result += newString[i];
	 }
	 return result ;
 }
}
