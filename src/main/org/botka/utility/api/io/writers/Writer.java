/**
 * Writer.java
 * Programmer: Jake Botka
 * Nov 14, 2020
 *
 */
package main.org.botka.utility.api.io.writers;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;

/**
 * Abstract class that represents all writers.
 * @author Jake Botka
 *
 */
public abstract class Writer {

	/**
	 * Default constructor.
	 */
	public Writer() {
		// TODO Auto-generated constructor stub
	}

	public abstract String getWrittingSource();
	public abstract boolean isAsync();
	public abstract boolean writeDouble(double item);
	public abstract boolean writeDoubles(@NonNull double[] items);
	public abstract boolean writeInt(int item);
	public abstract boolean writeInts(int[] items);
	public abstract boolean writeLong(long item);
	public abstract boolean writeLongs(@NonNull long[] items);
	public abstract boolean writeShort(short item);
	public abstract boolean writeShorts(@NonNull short[] items);
	public abstract boolean writeByte(byte item);
	public abstract boolean writeBytes(@NonNull byte[] items);
	public abstract boolean writeObject(@NonNull Object item);
	public abstract boolean writeObjects(@NonNull Object[] items);
	
	/**
	 * @return String representation of this object.
	 */
	public String toString() {
		return this.toString();
	}
	
}
