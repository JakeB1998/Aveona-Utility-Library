/*
 * File name:  FileReader.java
 *
 * Programmer : Jake Botka
 *
 * Date: Jul 20, 2020
 *
 */
package main.org.botka.utility.api.io.readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class FileReader extends BaseReader {

	private File mFile;

	/**
	 * 
	 * @param the file to be scanned
	 * @throws FileNotFoundException
	 */
	public FileReader(File file) throws FileNotFoundException {
		super(new BufferedReader(new InputStreamReader(new FileInputStream(file))));
		mFile = file;
	}

	/**
	 * 
	 * @param path to file
	 * @throws FileNotFoundException
	 */
	public FileReader(String path) throws FileNotFoundException {
		this(new File(path));
	}

	/**
	 * @param inputStream
	 * @return
	 * 
	 */
	@Override
	public String quickRead(InputStream inputStream) {
		
		return null;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public String readEntire() {
		
		return null;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public String[] readAllLines() {
		
		return null;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public String readNext() {
		
		return null;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public String readLine() {
		
		return null;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public String readString() {
		
		return null;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public int readInt() {
		
		return 0;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public int[] readAllInts() {
		
		return null;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public double readDouble() {
		
		return 0;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public double[] readAllDoubles() {
		
		return null;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public long readLong() {
		
		return 0;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public long[] readAllLongs() {
		
		return null;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public byte readByte() {
		
		return 0;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public byte[] readAllBytes() {
		
		return null;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public boolean hasNext() {
		
		return false;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public boolean hasNextLine() {
		
		return false;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public boolean hasNextInt() {
		
		return false;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public boolean hasNextDouble() {
		
		return false;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public boolean hasNextString() {
		
		return false;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public boolean hasNextLong() {
		
		return false;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public boolean hasNextByte() {
		
		return false;
	}

	/**
	 * 
	 * 
	 */
	@Override
	public void resetReader() {
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public String toString() {
		return "FileReader [mFile=" + mFile + "]";
	}

	

}
