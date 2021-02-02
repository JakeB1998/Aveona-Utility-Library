/*
 * File name:  DynamicArray.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 17, 2020
 *
 */
package main.org.botka.utility.api.data.structures.arrays;

import java.io.Serializable;
import java.util.Vector;

import main.org.botka.utility.api.util.ArrayUtil;

/**
 * Dynamic array with additional methods added on
 *
 * @author Jake Botka
 *
 */
public class DynamicArray<E> extends Vector<E> implements Serializable, Printable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8129977359938489251L;

	/**
	 * Default Constructor
	 */
	public DynamicArray() {
		super();
	}

	/**
	 * Constructor
	 * @param size Size of array
	 */
	public DynamicArray(int size) {
		super(size);
	}
	
	@Override
	public void print() {
		Object[] arr = super.toArray();
		String log = ArrayUtil.toString(arr);
		
	}
	
	/**
	 * 
	 * @return String representation of object
	 */
	public String toString() {
		return super.toString();
	}

	
}
