/**
 * ErrorHandler.java
 * Programmer: Jake Botka
 * Dec 2, 2020
 *
 */
package main.org.botka.utility.api.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that store thrown error so that they can be throwned at a later time.
 * @author Jake Botka
 *
 */
public class ErrorHandler<T> {

	private ArrayList<T> mErors;
	
	/**
	 * 
	 */
	public ErrorHandler() {
		this.mErors = new ArrayList<>();
	}
	
	/**
	 * 
	 * @param exception
	 * @return
	 */
	public boolean storeError(T error) {
		return this.mErors.add(error);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<T> dumpErrors(){
		List<T> arr = new ArrayList<T>(this.mErors);
		this.mErors.clear();
		return arr;
	}
}
