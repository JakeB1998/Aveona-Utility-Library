/**
 * ClassUtil.java
 * Programmer: Jake Botka
 * Nov 23, 2020
 *
 */
package main.org.botka.utility.api.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;

import main.org.botka.utility.api.exceptions.IllegalNullArguementException;

/**
 * Utility class with static methods that relate to using the Class Object.
 * {@link Class.java}
 * @author Jake Botka
 *
 */
public final class ClassUtil {

	
	/**
	 *
	 */
	private ClassUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static Class<?> loadClassByName(@NonNull String className) throws ClassNotFoundException {
		return Class.forName(className);
	}

	public static Object invokeMethod(Object obj, @NonNull Method method, Object... args) {
		if (method == null) {
			throw new IllegalNullArguementException(IllegalNullArguementException.formatEceptionMessage("method")); 
		}
		try {
			return method.invoke(obj, args);
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Method findMethod(@NonNull Class<?> classObj, @NonNull String methodName) {
		return findMethod(classObj, methodName, new Class<?>[0]);
	}
	public static Method findMethod(@NonNull Class<?> classObj, @NonNull String methodName, @NonNull Class<?>... methodParamClasses ) {
		//null checks here
		try {
			return classObj.getMethod(methodName, methodParamClasses);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
