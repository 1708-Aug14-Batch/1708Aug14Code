package exceptionExample;

public class MyExc extends Exception{
	
	public String getMessage(){ // overriding getMessage
		return "custom exc";
	}

}
