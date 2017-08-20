package question16;
/**
 * Write a program to display the number of characters for a string input. 
 * The string should be entered as a command line argument using 
 * (String [ ] args).
 * @author josh wurdemann
 * @version
 */
public class CommandLine {

	public static void main(String[] args) {
		 for (String s: args) {
	            
			 System.out.println(s.length());
	        }
//
//		 int firstArg;
//		 if (args.length > 0) {
//		     try {
//		         firstArg = Integer.parseInt(args[0]);
//		     } catch (NumberFormatException e) {
//		         System.err.println("Argument" + args[0] + " must be an integer.");
//		         System.exit(1);
//		     }
//		 }
	}

}
