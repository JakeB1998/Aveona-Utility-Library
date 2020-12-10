/**
 * PersistentStorage.java
 * Programmer: Jake Botka
 * Nov 19, 2020
 *
 */
package main.org.botka.utility.api.data.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.jdt.annotation.NonNull;

import main.org.botka.utility.api.exceptions.IllegalNullArguementException;
import main.org.botka.utility.api.util.FileUtil;
import main.org.botka.utility.api.util.Util;

/**
 * Class for storaging data into a persistent storage. 
 * This means the data will be saved even if the computer loses power via files.
 * @author Jake Botka
 *
 */
public class PersistentStorage extends DataStorage {

	/**
	 *
	 */
	public PersistentStorage() {
		
	}
	
	/**
	 * 
	 * @param directoryFile
	 */
	public PersistentStorage(File directoryFile) {
		super(directoryFile);
	}
	
	/**
	 * @param storageLocation
	 */
	public PersistentStorage(StorageLocation storageLocation) {
		super(storageLocation);
		
	}

	/**
	 * Stores data into storage.
	 * @param data
	 * @param file File to store data in.
	 * @return New File for data in persistent sotorage.
	 */
	public File storeData(byte[] data, @NonNull File file) {
		Util.checkNullArgumentAndThrow(file, IllegalNullArguementException.formatEceptionMessage("file"));
		File parent = null;
		if (super.getStorageLocation() != null) {
			parent = super.getStorageLocation().getStorageLocationFile();
			File fullFile = parent != null ? new File(parent,file.getPath()) : null;
			System.out.println(fullFile.getAbsolutePath());
			if (fullFile != null) {
				if (!fullFile.exists()) {
					try {
						if (fullFile.createNewFile()) {
							
						}
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
				try {
					if (FileUtil.writeDataToFile(data, fullFile)) {
						return fullFile;
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
