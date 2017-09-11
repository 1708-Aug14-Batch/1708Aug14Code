
public class StringBuilderBuffer {
int x = 0;
static int stat = 10;

	public static void main(String[] args) {
		String str = "hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("hello");
		
		System.out.println(str.equals(buff));
		System.out.println(str.equals(build));
		System.out.println(str.equals(buff.toString()));
		
		str.concat(" world");
		buff.append(" world");
		build.append(" world");
		
		System.out.println(str + " " + buff + " " + build);
		
	}

	static String doThings(String different) {
		return different;
	}

}
