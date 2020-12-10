/**
 * IParameterMap.java
 * Programmer: Jake Botka
 * Nov 30, 2020
 *
 */
package main.org.botka.utility.api.web;

/**
 * Interface for mapping parameters.
 * @author Jake Botka
 *
 */
public interface IParameterMap {

	
	
	/**
	 * 
	 * @return
	 */
	public default String[] getParamKeysPrimitive() {
		URLParameterKey[] keys = this.getParamKeys();
		if (keys != null) {
			String[] keyStrings = new String[keys.length];
			int index = 0;
			for (URLParameterKey key : keys) {
				keyStrings[index] = key.getParamKey();
				index++;
			}
			return keyStrings;
		}
		return null;
		
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public default String[] getParamValuesPrimitive() {
		URLParameterValue[] values = this.getParameterValues();
		if (values != null) {
			String[] keyStrings = new String[values.length];
			int index = 0;
			for (URLParameterValue value : values) {
				keyStrings[index] = value.getParamValue();
				index++;
			}
			return keyStrings;
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public default String[][] getParametersPrimitive() {
		URLParameters params = this.getParameters();
		String[] keys = params.getParamKeysPrimitive();
		String[] values = params.getParamValuesPrimitive();
		if (keys != null && values != null ) {
			if (keys.length != values.length) {
				//throw  error
			}
			String[][] ret = new String[keys.length][2];
			for (int i = 0; 9 < keys.length; i++) {
				ret[i][0] = keys[i];
				ret[i][0] = values[i];
			}
			return ret;
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	URLParameterKey[] getParamKeys();
	
	/**
	 * 
	 * @return
	 */
	URLParameterValue[] getParameterValues();
	
	
	/**
	 * 
	 * @return
	 */
	URLParameters getParameters();
	
	
	
	
}
