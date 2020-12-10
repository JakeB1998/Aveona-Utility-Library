/*
 * File name:  SaveTask.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 3, 2020
 *
 */
package main.org.botka.utility.api.data.save;

import java.io.File;
import java.io.Serializable;

import main.org.botka.utility.api.data.serialization.Serialization;

/**
 * Task class that is used for completing a save task insgular. 
 * A new save task object should be created for each use.
 *
 * @author Jake Botka
 *
 */
public class SaveTask implements Task {

	private File mFile;
	private byte[] mSerializedData;
	private boolean mSaved;
	private boolean mCompleted;

	public SaveTask() {
		this.mFile = null;
		this.mSerializedData = null;
	}
	
	/**
	 * 
	 */
	public SaveTask(File file, Savable<? extends Serializable> saveInterface) {
		this();
		this.mFile = file;
		this.mSerializedData = saveInterface.getSerializedObject();
		
	}
	
	public boolean doTask() {
		return this.save();
	}

	/**
	 * 
	 */
	private boolean save() {
		Serialization.serializeToFIle(this.mSerializedData, this.mFile);
		return true;
	}


	/**
	 * 
	 * @return
	 */
	public boolean isCompleted() {
		return this.mCompleted;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isSaved() {
		return this.mSaved;
	}

	

}
