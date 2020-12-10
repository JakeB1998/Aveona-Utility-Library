/*
 * File name:  EmptyBufferException.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 19, 2020
 *
 */
package main.org.botka.utility.api.exceptions;

/**
 * Throwable exception for class: BufferArray.
 * This represents when a buffer is empty
 *
 * @author Jake Botka
 *
 */
public class EmptyBufferException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6754847437451532776L;
	private final static String DEFAULT_ERROR_MESSAGE = "Buffer is Empty";

	/**
	 * 
	 */
	public EmptyBufferException() {
		super(DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * @param arg0
	 */
	public EmptyBufferException(String arg0) {
		super(arg0);
		
	}

	/**
	 * @param arg0
	 */
	public EmptyBufferException(Throwable arg0) {
		super(arg0);
		
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public EmptyBufferException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public EmptyBufferException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
