/**
 * URLParametersPrimitive.java
 * Programmer: Jake Botka
 * Nov 30, 2020
 *
 */
package main.org.botka.utility.api.web;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jake Botka
 *
 */
public class URLParametersPrimitive {

	private Map<String, String> mParamMap;
	/**
	 * 
	 */
	public URLParametersPrimitive() {
		this.mParamMap = new HashMap<>();
	}
	
	public Map<String, String> getParamMap(){
		return this.mParamMap;
	}
	
	public boolean hasParameter(String paramKey) {
		if (this.mParamMap != null) {
			return this.mParamMap.containsKey(paramKey);
		}
		return false;
	}
	
	public String[] getParamKeys() {
		return null;
	}
	
	public String[] getParamValues() {
		return null;
	}

}
