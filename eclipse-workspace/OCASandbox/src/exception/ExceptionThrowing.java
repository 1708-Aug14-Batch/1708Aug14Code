package exception;

public class ExceptionThrowing {
	
	public void throwThisException() throws Exception {
		
	}
	
	public void throwThisRunTimeException() throws RuntimeException {
		
	}
	
	public void catchThisException() {
		try {
			throw new Exception();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void catchThisRuntimeException() {
		try {
			throw new RuntimeException();
		} catch(RuntimeException re) {
			re.printStackTrace();
		}
	}

}
