/**
 * File Name: Cursor.java
 * Programmer: Jake Botka
 * Date Created: Jan 25, 2021
 *
 */
package main.org.botka.utility.api.base;

/**
 * @author Jake Botka
 *
 */
public class Cursor<T extends Incrementable<T> & Comparable<T>> {

	private Incrementer<T> mIncrementer;
	private Range<T> mRange;
	

	/**
	 * 
	 */
	public Cursor() {
		mRange = null;
		mIncrementer = null;
	}
	
	public Cursor(T low, T high) {
		this(low,high, low);
		
	}
	
	public Cursor(T low, T high, T startingPoint) {
		this();
		mRange = new Range(low, high);
		mIncrementer = new Incrementer<>(startingPoint);
	}
	
	public T nextPosition() {
		return mIncrementer != null ? mIncrementer.increment() : null;
	}
	/**
	 * 
	 * @return
	 */
	public T getLow() {
		return mRange != null ? mRange.getLowBound() : null;
	}
	
	/**
	 * 
	 * @return Highest value in cursor.
	 */
	public T getHigh() {
		 return mRange != null ? mRange.getHighBound(): null;
	}
	
	/**
	 * Delegate method to Range.class.
	 * @param value
	 * @return
	 * @see Range
	 */
	public boolean isBetween(T value) {
		return mRange != null ? mRange.isBetween(value) : false;
	}
	
	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "Cursor [mRange=" + mRange + "]";
	}

}
