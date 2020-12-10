/*
 * File name:  TimedSave.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 3, 2020
 *
 */
package main.org.botka.utility.api.data.save;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Time interval Saving of classes that implement the interface: Savable
 *
 * @author Jake Botka
 *
 */
public class TimedSave {

	private SaveTask mSaveTask;

	/**
	 * Constructor
	 */
	public TimedSave(File file, Savable<? extends Serializable> savableInterface) {
		this.mSaveTask = new SaveTask(file,savableInterface);
	}

	/**
	 * Constructor
	 */
	public TimedSave(SaveTask saveTask) {
		if (saveTask != null) {
			this.mSaveTask = saveTask;
		}
	}

	

	/**
	 * @return String representation of this object
	 */
	public String toString() {
		return super.toString();
	}

}
