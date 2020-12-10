/*
 * File name:  IDGenerator.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: Jun 21, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.security;

import java.util.Random;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class IDGenerator {

	public static long generateID(int seed, long length) {
		Random ran = new Random(seed);
		String idS = "";

		for (int i = 0; i < length; i++) {
			idS += Integer.toString(ran.nextInt(9));
		}
		return Long.parseLong(idS);
	}

	/**
	 * Generates a secure ID.
	 * 
	 * @return
	 */
	public static String generateSecureID() {
		Random ran = new Random();
		return Long.toString(generateID(ran.nextInt(1000000),10));
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static float asFloat(long id) {
		return (float) id;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static double asDouble(long id) {
		return (double) id;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static String asString(long id) {
		return Long.toString(id);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static String asHexString(long id) {
		return Long.toHexString(id);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static String asOctalString(long id) {
		return Long.toOctalString(id);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static String asBinaryString(long id) {
		return Long.toBinaryString(id);
	}

}
