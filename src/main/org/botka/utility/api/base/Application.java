/**
 * Application.java
 * Programmer: Jake Botka
 * Nov 16, 2020
 *
 */
package main.org.botka.utility.api.base;

/**
 * @author Jake Botka
 *
 */
public class Application {

	private static final long MAX_MEMORY = Runtime.getRuntime().maxMemory();
	/**
	 *
	 */
	public Application() {
		// TODO Auto-generated constructor stub
	}

	public static long getMaxMemoryAllowed() {
		return MAX_MEMORY;
	}
}
