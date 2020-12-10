/*
 * File name:  BufferArrayExample.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 19, 2020
 *
 */
package main.org.botka.utility.api.examples;

import main.org.botka.utility.api.data.structures.arrays.BufferArray;
import main.org.botka.utility.api.util.ArrayUtil;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class BufferArrayExample {

	/**
	 * Main
	 * @param args Command Line arguments
	 */
	public static void main(String[] args) {
		final BufferArray<Integer> buffer = new BufferArray(5,true);
		int[] stream = ArrayUtil.arrange(10); // files array with sequential list with range of param
		for (int i =0; i < stream.length; i++) {
			addToBuffer(buffer,stream[i]);
			if (i % 2 == 0) {
				// executes every two passes
				Integer value = (Integer)removeOldestFromBuffer(buffer);
				if (value != null)
					System.out.println("Removed from buffer: " + value.intValue() );
			}
		}

	}
	
	/**
	 * 
	 * @param buffer Buffer Array
	 * @param element Element to add
	 */
	public static void addToBuffer(final BufferArray buffer, Object element) {
		buffer.addToBuffer(element); // or buffer.push(stream[i]);
		buffer.printBuffer();
	}
	
	/**
	 * 
	 * @param buffer Buffer Array
	 * @return Element removed
	 */
	public static Object removeOldestFromBuffer(final BufferArray buffer) {
		return  buffer.popOldest();
	}

}
