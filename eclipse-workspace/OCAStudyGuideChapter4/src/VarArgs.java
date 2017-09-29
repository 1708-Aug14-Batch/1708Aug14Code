
public class VarArgs {
	
	public void moreA(int... nums) {}
	
	public void moreB(String values, int... nums) {}
	
//	public void moreC(int... nums, String values) {} // Var args must be the last parameter
	
//	public void moreD(String... values, int... nums) {}
	
//	public void moreE(String[] values, ...int nums) {} // Ellipsis in wrong position
	
//	public void moreF(String... values, int[] nums) {}
	
	public void moreG(String[] values, int[] nums) {}
	
	public static int howMany(boolean b, boolean... b2) {
		return b2.length;
	}
	
	public static void main(String[] args) {
		System.out.println("howMany(true)" + howMany(true)); // 0
		System.out.println("howMany(true, true)" + howMany(true, true)); // 1
		System.out.println("howMany(true, true, true)" + howMany(true, true, true)); // 2
		System.out.println("howMany(true, new boolean[2])" + howMany(true, new boolean[2])); // 2
	}

}
