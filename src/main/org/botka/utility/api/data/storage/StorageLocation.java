/**
 * StorageLocation.java
 * Programmer: Jake Botka
 * Dec 2, 2020
 *
 */
package main.org.botka.utility.api.data.storage;

import java.io.File;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * @author Jake Botka
 *
 */
public class StorageLocation {

	private File mParentFile;
	
	/**
	 * 
	 */
	public StorageLocation() {
		this.mParentFile = null;
	}
	
	/**
	 * 
	 * @param parentFile
	 */
	public StorageLocation(@Nullable File parentFile) {
		this.mParentFile = this.isDirectory(parentFile) ? parentFile : null;
	}
	
	/**
	 * @param directoryPath
	 */
	public StorageLocation(@NonNull String directoryPath) {
		this(new File(directoryPath));
	}
	
	/**
	 * Checks if the storage location set is a directory.
	 * @return True if the recorded storage location is a directory. Otherwise false.
	 */
	public boolean isDirectory() {
		return this.isDirectory(this.mParentFile);
	}
	
	/**
	 * 
	 * @param parentFile Directory.
	 * @return True if the recorded storage location is a directory. Otherwise false.
	 */
	public boolean isDirectory(File parentFile) {
		return parentFile != null && parentFile.isDirectory();
	}
	
	/**
	 * 
	 * @return String path to storage location.
	 */
	public String getStorageLocationPath() {
		return this.mParentFile != null ? this.mParentFile.getPath() : null;
	}
	
	/**
	 * 
	 * @return Parent file.
	 */
	public File getStorageLocationFile() {
		return this.mParentFile;
	}
	/**
	 * 
	 * @param path Path of directory to storage
	 */
	public void setStorageLocation(String path) {
		
	}
	
	/**
	 * 
	 * @param directory Directory of storage.
	 */
	public void setStoraageLocation(File directory) {
		
	}
	
	
	
	
}
