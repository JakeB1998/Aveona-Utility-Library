/**
 * File Name: IntCursor.java
 * Programmer: Jake Botka
 * Date Created: Jan 25, 2021
 *
 */
package main.org.botka.utility.api.base;

/**
 * @author Jake Botka
 *
 */
public class IntCursor extends Cursor<IncrementableInt> {

	/**
	 * Default constuctor.
	 * Loads min and max range values with {@code Integer.MIN_VALUE} and {@code INTEGER.MAX}.
	 */
	public IntCursor() {
		this(new IncrementableInt(Integer.MIN_VALUE), new IncrementableInt(Integer.MAX_VALUE));
	}

	/**
	 * @param low Low bound
	 * @param high High bound
	 */
	public IntCursor(Integer low, Integer high) {
		super(new IncrementableInt(low), new IncrementableInt(high));
	}
	/**
	 * @param low Low bound
	 * @param high High bound
	 */
	public IntCursor(IncrementableInt low, IncrementableInt high) {
		super(low, high);
	}
	
	/**
	 * Loads min and max range values with zero and {@code size - 1}.
	 * @param size Max size
	 */
	public IntCursor(int size) {
		this(new IncrementableInt(0), new IncrementableInt(size));
	}
	
	/**
	 * 
	 * @return
	 */
	public String toString() {
		return super.toString();
	}

}
