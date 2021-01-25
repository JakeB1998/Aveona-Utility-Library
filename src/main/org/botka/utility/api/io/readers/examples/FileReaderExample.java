/*
 * File name:  FileReaderExample.java
 *
 * Programmer : Jake Botka
 *
 * Date: Jul 21, 2020
 *
 */
package main.org.botka.utility.api.io.readers.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Vector;

import main.org.botka.utility.api.io.readers.BaseReader;
import main.org.botka.utility.api.io.readers.FileReader;

import main.org.botka.utility.api.util.ArrayUtil;

/**
 * Example of the FileReader class and its abilities
 *
 * @author Jake Botka
 *
 */
public class FileReaderExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		BaseReader reader = null;
		File file = null;
		file = new File("example.txt");
		try {
			reader = new FileReader(file);
			testOption1(reader);
			// or
			// reader = new FileReader(file); // reseting reader
			reader.resetReader();
			testOption2(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Option 1 of reading files using the abstract class: Reader
	 * 
	 * @param reader that will read file
	 */
	public static void testOption1(BaseReader reader) {
		System.out.println("\nOption 1:");
		if (reader != null) {

			int[] arr = null;
			Vector<Integer> ints = new Vector(0);
			Integer[] integerArr = null;
			integerArr = ArrayUtil.converToWrapperArray(reader.readAllInts());

			for (int i = 0; i < integerArr.length; i++) {
				ints.add(integerArr[i]);
			}

			System.out.println("\nNumber of integers in file: " + ints.size());
		}
	}

	/**
	 * Option 2 of reading files using the abstract class: Reader
	 * 
	 * @param Reader that will read file
	 */
	public static void testOption2(BaseReader reader) {
		System.out.println("\nOption 2:");
		if (reader != null) {
			int[] arr = null;
			Vector<Integer> ints = new Vector<Integer>(0);
			Vector<String> strings = new Vector<String>(0);
			while (reader.hasNext()) // reads until end of input
			{
				if (reader.hasNextInt()) {
					ints.add(new Integer(reader.readInt()));
				} else if (reader.hasNextString()) {
					strings.add(reader.readString());

				}
			}

			System.out.println("\nNumber of integers in file: " + ints.size());
			System.out.println("\nNumber of strings in file: " + strings.size());
		}
	}

}
