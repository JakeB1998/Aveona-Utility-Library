/**
 * URLParameter.java
 * Programmer: Jake Botka
 * Nov 30, 2020
 *
 */
package main.org.botka.utility.api.web;

import org.eclipse.jdt.annotation.Nullable;

import main.org.botka.utility.api.data.KeyValuePair;

/**
 * @author Jake Botka
 *
 */
public class URLParameter extends Parameter {

	private KeyValuePair<String, String> mkeyValuePair;
	
	/**
	 * Constructor. 
	 */
	public URLParameter() {
		super();
		this.mkeyValuePair = null;
	}
	
	/**
	 * Constructor.
	 * @param param
	 */
	public URLParameter(KeyValuePair<String, String> param) {
		this();
		this.mkeyValuePair = param;
	}
	
	/**
	 * 
	 * @param paramKey
	 * @param paramValue
	 */
	public URLParameter(String paramKey, String paramValue) {
		this(new KeyValuePair<>(paramKey, paramValue));
	}

	public KeyValuePair<String, String> getParam(){
		return this.mkeyValuePair;
	}
	
	public void setParam(String paramKey, String paramValue) {
		this.setParam(new KeyValuePair(paramKey, paramValue));
	}
	
	public void setParam(@Nullable KeyValuePair<String, String> param) {
		this.mkeyValuePair = param;
	}
}
