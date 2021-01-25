/**
 * File Name: Range.java
 * Programmer: Jake Botka
 * Date Created: Jan 3, 2021
 *
 */
package main.org.botka.utility.api.base;

/**
 * Class that represents a range.
 * @author Jake Botka
 *
 */
public class Range<T extends Comparable<T>> {
	private T mLow;
	private T mHigh;
	
	/**
	 * 
	 */
	private Range() {
		mLow = null;
		mHigh = null;
	}
	
	/**
	 * 
	 * @param low
	 * @param high
	 */
	public Range(T low, T high) {
		this();
		mLow = low;
		mHigh = high;
	}
	
	/**
	 * 
	 * @return
	 */
	public T getLowBound() {
		return mLow;
	}
	
	/**
	 * 
	 * @return
	 */
	public T getHighBound() {
		return mHigh;
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public boolean isBetween(T value) {
		if (value != null && mLow != null && mHigh != null) {
			return value.compareTo(mLow) >= 0 && value.compareTo(mHigh) <= 0;
		}
		return false;
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "Range [mLow=" + mLow + ", mHigh=" + mHigh + "]";
	}
}
