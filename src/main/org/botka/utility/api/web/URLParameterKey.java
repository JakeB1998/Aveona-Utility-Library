/**
 * URLParameterKey.java
 * Programmer: Jake Botka
 * Nov 30, 2020
 *
 */
package main.org.botka.utility.api.web;

/**
 * Class represents the key for a URL parameter.
 * @author Jake Botka
 *
 */
public class URLParameterKey {

private String mValue;
	
	private URLParameterKey() {
		this.mValue = null;
	}
	
	public URLParameterKey(String paramKey) {
		this();
		this.mValue = paramKey;
	}
	
	public String getParamKey() {
		return this.mValue;
	}
}
