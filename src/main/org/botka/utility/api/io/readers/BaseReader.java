/*
 * File name:  BaseReader.java
 *
 * Programmer : Jake Botka
 *
 * Date: Jul 20, 2020
 *
 */
package main.org.botka.utility.api.io.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Scanner;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public abstract class BaseReader extends AbstractReader {

	
	private Reader mReader;
	private InputStream mInputStream;
	private BufferedReader mBufferedReader;
	
	public BaseReader(java.io.Reader reader) {
		this(new BufferedReader(reader));
		mReader = reader;
	}
	
	public BaseReader(BufferedReader bufferedReader) {
		mBufferedReader = bufferedReader;
	}
	
	
	public abstract String quickRead(InputStream inputStream);

	public abstract String readEntire();

	public abstract String[] readAllLines();

	public abstract String readNext();

	public abstract String readLine();

	public abstract String readString();

	public abstract int readInt();

	public abstract int[] readAllInts();

	public abstract double readDouble();

	public abstract double[] readAllDoubles();

	public abstract long readLong();

	public abstract long[] readAllLongs();

	public abstract byte readByte();

	public abstract byte[] readAllBytes();

	public abstract boolean hasNext();

	public abstract boolean hasNextLine();

	public abstract boolean hasNextInt();

	public abstract boolean hasNextDouble();

	public abstract boolean hasNextString();

	public abstract boolean hasNextLong();

	public abstract boolean hasNextByte();

	public abstract void resetReader();
	
	public boolean isReadable() {
		return mReader != null;
	}

}
