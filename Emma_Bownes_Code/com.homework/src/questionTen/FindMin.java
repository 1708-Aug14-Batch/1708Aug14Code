package questionTen;

public class FindMin {
//find the minimum of two numbers using ternary operators
	public int findMin(int n, int m) {
		int min = n >m ?  m: n;
		//creates ternary operator with the case that n>m
		//if this is true, min = m,
		//if this is false, min =n
		//this means that if m =n, min = n
		return min;
		//returns the result
	}

}
