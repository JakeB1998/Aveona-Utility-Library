/**
 * KeyValuePair.java
 * Programmer: Jake Botka
 * Nov 17, 2020
 *
 */
package main.org.botka.utility.api.data;

/**
 * @author Jake Botka
 *
 */
public class KeyValuePair<K,V> {

	private K mKey;
	private V mValue;
	/**
	 *
	 */
	public KeyValuePair(K key, V value) {
		this.mKey = key;
		this.mValue = value;
	}
	/**
	 * @return the mKey
	 */
	public K getKey() {
		return mKey;
	}
	/**
	 * @param mKey the mKey to set
	 */
	public void setKey(K key) {
		this.mKey = key;
	}
	/**
	 * @return the mValue
	 */
	public V getmValue() {
		return mValue;
	}
	/**
	 * @param mValue the mValue to set
	 */
	public void setmValue(V value) {
		this.mValue = value;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mKey == null) ? 0 : mKey.hashCode());
		result = prime * result + ((mValue == null) ? 0 : mValue.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof KeyValuePair)) {
			return false;
		}
		KeyValuePair other = (KeyValuePair) obj;
		if (mKey == null) {
			if (other.mKey != null) {
				return false;
			}
		} else if (!mKey.equals(other.mKey)) {
			return false;
		}
		if (mValue == null) {
			if (other.mValue != null) {
				return false;
			}
		} else if (!mValue.equals(other.mValue)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "KeyValuePair [mKey=" + mKey + ", mValue=" + mValue + "]";
	}

	
}
