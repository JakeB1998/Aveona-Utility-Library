/**
 * AsyncFileSaver.java
 * Programmer: Jake Botka
 * Nov 9, 2020
 *
 */
package main.org.botka.utility.api.data.save;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.jdt.annotation.NonNull;

import main.org.botka.utility.api.data.DataContainer;
import main.org.botka.utility.api.data.serialization.Serialization;
import main.org.botka.utility.api.util.ListUtil;
import main.org.botka.utility.api.util.Util;



/**
 * @author Jake Botka
 *
 */
public class AsyncFileSaver<T> {

	
	private File mFile;
	private AtomicBoolean mAutomaticSaving;
	private DataContainer<T> mContainer;
	private DataContainer<T> mSnapshotContainer;
	/**
	 *
	 */
	public AsyncFileSaver() {
		this.mFile = null;
		this.mContainer = null;
		this.mSnapshotContainer = null;
		this.mAutomaticSaving = new AtomicBoolean(false);
	}
	
	/**
	 *@param mFile
	 */
	public AsyncFileSaver(@NonNull File file) {
		this();
		Util.checkNullAndThrow(file);
		this.mFile = file;
	}
	
	/**
	 *@param mFile
	 */
	public AsyncFileSaver(@NonNull File file, boolean automaticSaving) {
		this(file);
		this.mAutomaticSaving.set(automaticSaving);
	}
	
	
	/**
	 *@param mFile
	 *@param mContainer
	 */
	public AsyncFileSaver(File file, DataContainer<T> container) {
		this(file);
		this.mContainer = container;
		this.mSnapshotContainer = this.mContainer;
	}
	
	/**
	 *@param mFile
	 *@param mContainer
	 */
	public AsyncFileSaver(File file, DataContainer<T> container, boolean automaticSaving) {
		this(file,container);
		this.mAutomaticSaving = new AtomicBoolean(automaticSaving);
	}
	
	/**
	 * Adds object to wrapper that wraps all objects that are present in the file. 
	 * It then saves to the file regardless if automatic saving is enabled.
	 * @param item
	 * @return
	 *
	 */
	public boolean addAndSave(T item) {
		if (this.mContainer != null) {
			this.mContainer.add(item);
		}
		
		if (save()) {
			this.mSnapshotContainer.add(item);
			return true;
		}
		return false;
	}
	
	/**
	 * Adds object to the data container that wraps all object in the file. 
	 * If automatic saving is enabled it will then save the objects to the file
	 * @param obj Object to add to file.
	 * @return True if ite was added
	 *
	 */
	public boolean add(T obj) {
		if (this.mContainer != null) {
			this.mContainer.add(obj);
			if (this.mAutomaticSaving.get()) {
				return this.save();
			}
			return true;
		}
		return false;
	}
	
	public boolean hasUnsavedObjects() {
		
		return ListUtil.containsSameElementsInOrder(this.mContainer, this.mSnapshotContainer);
	}
	public boolean save() {
		if (this.mFile != null && this.mSnapshotContainer != null) {
			Serialization.serializeToFIle(Serialization.serailizeObject(this.mSnapshotContainer), this.mFile);
		}
		return false;
	}
	@Override
	public String toString() {
		return "AsyncFileSaver [mFile=" + mFile + ", mContainer=" + mContainer + "]";
	}
	

}
