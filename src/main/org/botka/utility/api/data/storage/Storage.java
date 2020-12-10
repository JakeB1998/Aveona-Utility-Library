/**
 * Storage.java
 * Programmer: Jake Botka
 * Nov 19, 2020
 *
 */
package main.org.botka.utility.api.data.storage;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import main.org.botka.utility.api.base.ErrorHandler;

/**
 * Abstract class to represent storage.
 * @author Jake Botka
 *
 */
public abstract class Storage {

	private final ErrorHandler ERROR_HANDLER = new ErrorHandler();
			
	private StorageLocation mStorageLocation;
	
	/**
	 *
	 */
	public Storage() {
		this.mStorageLocation = null;
	}
	
	public Storage(StorageLocation storageLocation) {
		
		this.mStorageLocation = storageLocation;
	}
	
	public Storage(File directory) {
		this(new StorageLocation(directory));
	}
	
	public boolean commitErorr(Exception exception) {
		return ERROR_HANDLER.storeError(exception);
	}

	
	public StorageLocation getStorageLocation() {
		return this.mStorageLocation;
	}
}
