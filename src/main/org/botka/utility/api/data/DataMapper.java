/*
 * File name:  DataMapper.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: Jun 20, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.data;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Provides a Datacontainer using a hashmap that can be used to be transported
 * between classes and/or Programs
 *
 * @author Jake Botka
 *
 */
public class DataMapper<K,V> {
	private HashMap<K,V> mHashMap;

	/**
	 * Overrides default constructor
	 */
	public DataMapper() {

	}

	/**
	 * constructor
	 * 
	 * @param size of container
	 */
	public DataMapper(int size) {
		this.mHashMap = new HashMap<>(0);
	}

	/**
	 * Creates a default instance of a data container
	 * 
	 * @return
	 */
	public static DataMapper CreateInstance() {
		return CreateInstance(0);
	}

	/**
	 * Creates a default instance of a data container
	 * 
	 * @return
	 */
	public static DataMapper CreateInstance(int size) {
		return new DataMapper();
	}

	/**
	 * 
	 * @param key
	 * @param Object
	 */
	public void addData(K key, V Object) {
		if (this.mHashMap == null) {
			this.mHashMap = new HashMap<>(0);
		}

		this.mHashMap.put(key, Object);
	}

	/**
	 * 
	 * @param ID
	 * @return
	 */
	public boolean hasData(String ID) {
		if (this.mHashMap != null) {
			return this.mHashMap.containsKey(ID);
		}

		return false;
	}

	public HashMap<K, V> getRawHashMap() {
		return this.mHashMap;

	}

	/**
	 * Overrides toString method
	 * 
	 * @return String
	 */
	public String toString() {
		if (this.mHashMap != null) {
			return this.mHashMap.toString();
		}

		return "\nHashmap is null";
	}

}
