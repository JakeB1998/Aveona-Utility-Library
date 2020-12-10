/**
 * RandomGenerator.java
 * Programmer: Jake Botka
 * Nov 14, 2020
 *
 */
package main.org.botka.utility.api.base;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author Jake Botka
 *
 */
public class RandomGenerator {

	public static final Random RANDOM = new Random();
	public static final SecureRandom SECURE_RANDOM = new SecureRandom();
	
	/**
	 * Generates an unsecure String id.
	 * @param length Length of the id in characters.
	 * @return String id. if length is not larger than 0 then returns null;
	 *
	 */
	public static String generateID(int length) {
		if (length > 0) {
			String id = "";
			for (int i = 0; i < length; i++) {
				id += RANDOM.nextInt(10);
			}
			return id;
		}
		return null;
	}
	
	public static int generateRandomInt(int exclusiveBound) {
		return RANDOM.nextInt(exclusiveBound);
	}
	
	public static int generateRandomInt(int inclusiveBound, int exclusiveBound) {
		return RANDOM.ints(1, inclusiveBound, exclusiveBound).toArray()[0];
	}
}
