package problem18;

public class AbstractImplementation extends AbstractClassProblem18 {


	@Override
	public boolean containUppercase(String string) {
		// TODO Auto-generated method stub
		
		if(string.equals(string.toLowerCase())) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String converUppercase(String string) {
		// TODO Auto-generated method stub
	
		return string.toUpperCase();
	}
	
	@Override
	public int stringToIntPlus10(String string) {
		// TODO Auto-generated method stub
		System.out.println(Integer.parseInt(string)+10);
		return Integer.parseInt(string)+10;
	}
}
