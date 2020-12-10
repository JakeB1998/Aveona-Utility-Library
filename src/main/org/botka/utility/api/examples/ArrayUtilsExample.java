/*
 * File name:  ArraysUtilsExample.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: Jul 13, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.examples;

import java.util.Arrays;

import main.org.botka.utility.api.util.ArrayUtil;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class ArrayUtilsExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] x = new int[5];
		int[] z = new int[9];
		Arrays.fill(x, 1);
		Arrays.fill(z, 2);
		int[] y = ArrayUtil.concat(x, z);
		ArrayUtil.print(y);

	}

}
