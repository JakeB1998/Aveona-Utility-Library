/**
 * URLParameters.java
 * Programmer: Jake Botka
 * Nov 30, 2020
 *
 */
package main.org.botka.utility.api.web;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

import main.org.botka.utility.api.systems.autocomplete.MatchingResult.Builder;

/**
 * @author Jake Botka
 *
 */
public class URLParameters implements IParameterMap {

	private Map<URLParameterKey, URLParameterValue> mParamMap;

	public URLParameters() {
		this.mParamMap = new HashMap<>(0);
	}

	public URLParameters(Map<URLParameterKey, URLParameterValue> paramMap) {
		this.mParamMap = paramMap;
	}


	/**
	 * @return
	 */
	@Override
	public URLParameterKey[] getParamKeys() {
		if (this.mParamMap != null) {
			return this.mParamMap.keySet().toArray(new URLParameterKey[0]);
		}
		return null;
	}



	/**
	 * @return
	 */
	@Override
	public URLParameterValue[] getParameterValues() {
		if (this.mParamMap != null) {
			return this.mParamMap.values().toArray(new URLParameterValue[0]);
		}
		return null;
	}


	/**
	 * @return
	 */
	@Override
	public URLParameters getParameters() {
		return new URLParameters(this.mParamMap);
	}

	

	public Map<URLParameterKey, URLParameterValue> getParamMap() {
		return this.mParamMap;
	}

	/**
	 * This can be used to use different subclasses for the paramMAp such as hashmap
	 * or hashTable.
	 * 
	 * @param paramMap
	 */
	public void setParamMap(Map<URLParameterKey, URLParameterValue> paramMap) {
		this.mParamMap = paramMap;
	}

	public static class Builder {
		private URLParameters mObject;

		public Builder() {
			this.mObject = new URLParameters();
		}

		public URLParameters withHashMap() {
			return this.withHashMap(new HashMap<>(0));
		}

		public URLParameters withHashMap(HashMap<URLParameterKey, URLParameterValue> paramMap) {
			this.mObject.setParamMap(paramMap);
			return this.mObject;
		}

		public URLParameters withHashTable() {
			return this.withHashTable(new Hashtable<>(0));
		}

		public URLParameters withHashTable(Hashtable<URLParameterKey, URLParameterValue> paramMap) {
			this.mObject.setParamMap(paramMap);
			return this.mObject;
		}

		public URLParameters withLinkedHashMap() {
			return this.withLinkedHashMap(new Hashtable<URLParameterKey, URLParameterValue>(0));
		}

		public URLParameters withLinkedHashMap(Hashtable<URLParameterKey, URLParameterValue> paramMap) {
			this.mObject.setParamMap(paramMap);
			return this.mObject;
		}

	}


}
