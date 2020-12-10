/**
 * DataStorage.java
 * Programmer: Jake Botka
 * Nov 19, 2020
 *
 */
package main.org.botka.utility.api.data.storage;

import java.io.File;

/**
 * Abstract class that represents storage of data
 * @author Jake Botka
 *
 */
public abstract class DataStorage extends Storage {

	/**
	 *
	 */
	public DataStorage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param directory
	 */
	public DataStorage(File directory) {
		super(directory);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param storageLocation
	 */
	public DataStorage(StorageLocation storageLocation) {
		super(storageLocation);
		
	}

}
