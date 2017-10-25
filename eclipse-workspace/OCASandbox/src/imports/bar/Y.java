package imports.bar; // Package declaration must come before import statements.

import imports.foo.X;
import static imports.foo.X.LOGICID; // This imports only one static member of X.
//import static imports.foo.X.*; // This imports all static members of X.

public class Y {
	
	public static void main(String[] args) {
		X x = new X();
		x.apply(LOGICID);
	}

}
