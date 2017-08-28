package Q18;

public class ConcreteClass extends SuperClass {

	@Override
	public boolean hasUpperCase(String str) {
		for (char c : str.toCharArray()) {
			if ((int)c >= 65 && (int)c <= 90) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toUpperCase(String str) {
		return str.toUpperCase();
	}

	@Override
	public int toIntAddTen(String str) {
		return Integer.parseInt(str) + 10;
	}

	public static void main(String[] args) {
		ConcreteClass c = new ConcreteClass();
		
		System.out.println("banaNas has upper case? " + c.hasUpperCase("banaNas"));
		System.out.println("banaNas to upper case = " + c.toUpperCase("banaNas"));
		System.out.println("\"123\" + 10 = " + c.toIntAddTen("123"));
	}
}
