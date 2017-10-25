package exception;

public class ExceptionMain {

	public static void main(String[] args) {
//		ExceptionThrowing ex = new ExceptionThrowing();
//		ex.catchThisException();
//		ex.catchThisRuntimeException();
//		try {
//			// If this is not surrounded by a try/catch, 
//			// the compiler will show a red underline.
//			ex.throwThisException();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		ex.throwThisRunTimeException();
		
//		System.out.println(IdentifyExceptions.k); // Both of these lines throw an ArithmeticException
//		IdentifyExceptions ie = new IdentifyExceptions();
		
		try {
			int x = 10 / 0;
		} finally { // FINALLY DOES NOT ALWAYS EXECUTE
			System.out.println("Finally");
		}
	}

}
