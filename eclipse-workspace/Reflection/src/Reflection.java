import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

	public static void main(String[] args) {
		Hidden myHidden = new Hidden();
		Class myClass = myHidden.getClass();
		Method myMethod = null;
		try {
			myMethod = myClass.getDeclaredMethod("printI", null);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		myMethod.setAccessible(true);
		try {
			myMethod.invoke(myHidden, null);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
