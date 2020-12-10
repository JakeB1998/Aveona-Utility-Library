/*
 * File name:  StringUtilsExample.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: Jun 13, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.examples;

import main.org.botka.utility.api.util.StringUtil;

/**
 * example class for StringUtils class
 *
 * @author Jake Botka
 *
 */
public class StringUtilExample {

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println(StringUtil.insert("Jake1998", "TheSnake", 4));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
