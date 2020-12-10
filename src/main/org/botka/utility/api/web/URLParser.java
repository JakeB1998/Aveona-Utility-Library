/**
 * URLParser.java
 * Programmer: Jake Botka
 * Oct 29, 2020
 *
 */
package main.org.botka.utility.api.web;

import org.eclipse.jdt.annotation.NonNull;

import main.org.botka.utility.api.exceptions.NotImplementedYetException;


/**
 * 
 * @author Jake Botka
 *
 */
public class URLParser {

	/**
	 * Parameters can not be null. If they are a null pointer exception will manually be thrown
	 * @return
	 *
	 */
	public static URLParameter parseParameters() {
		throw new NotImplementedYetException();
		
	}
	
	/**
	 * Parameters can not be null. If they are a null pointer exception will manually be thrown
	 * @return
	 *
	 */
	public static String[] parseParametersPrimitive() {
		throw new NotImplementedYetException();
		
	}
	
	/**
	 * Parameters can not be null. If they are a null pointer exception will manually be thrown
	 * @param url
	 * @param paramStrings
	 * @return
	 *
	 */
	public static String addParamaters(@NonNull String url, @NonNull String[] paramStrings) {
		throw new NotImplementedYetException();
		/*
		if (url == null || paramStrings == null) {
			throw new NullPointerException();
		}
		return null;
		*/
	}

}
