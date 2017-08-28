package Q11;

import Q11_2.Floats;

public class PackageAccess {
	
	public static void main(String[] args) {
		
		Floats f = new Floats(19, 42);
		
		System.out.println("x = " + f.getX() + ", y = " + f.getY());
	}
}
