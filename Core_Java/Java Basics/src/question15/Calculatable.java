package question15;

/*
 * Write a program that defines an interface having the following methods:
 * 		addition, subtraction, multiplication, and division.  
 */

// This uses the Jave generic so that classes implementing this interface
// can use a variaety of types
public interface Calculatable<C> {
	
	C addition(C a, C b);
	C subtraction(C a, C b);
	C multiplication(C a, C b);
	C division(C a, C b);

}
