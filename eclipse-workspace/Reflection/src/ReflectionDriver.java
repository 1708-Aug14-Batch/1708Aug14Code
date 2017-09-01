import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDriver {

	public static void main(String[] args) {
		System.out.println();
		MySpecialClass mySpecialObject = new MySpecialClass();
		Class myClass = mySpecialObject.getClass();
		System.out.println("Class name: " + myClass.getSimpleName());
		Method myMethod = null;
		try {
			myMethod = myClass.getDeclaredMethod("sayHello", null);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		myMethod.setAccessible(true);
		try {
			System.out.println();
			System.out.print("Call a private method: ");
			myMethod.invoke(mySpecialObject, null);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println();
		Field field = null;
		try {
			field = myClass.getField("hello");
			System.out.println("Get field's fully qualified name: " + field);
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		System.out.println();
		try {
			System.out.println("Constructor name: " + myClass.getConstructor(null).getName());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

}
