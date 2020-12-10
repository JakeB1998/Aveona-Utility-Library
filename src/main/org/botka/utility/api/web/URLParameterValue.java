/**
 * URLParameterValue.java
 * Programmer: Jake Botka
 * Nov 30, 2020
 *
 */
package main.org.botka.utility.api.web;

/**
 * Class represents the value for a URL parameter.
 * @author Jake Botka
 *
 */
public class URLParameterValue {

	private String mValue;
	
	private URLParameterValue() {
		this.mValue = null;
	}
	
	public URLParameterValue(String paramValue) {
		this();
		this.mValue = paramValue;
	}
	
	public String getParamValue() {
		return this.mValue;
	}
}
