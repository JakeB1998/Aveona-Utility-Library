package main.org.botka.utility.api.data;

import java.util.Arrays;

/**
 * 
 * Wrapper class that represents data in its most primitative state
 *
 * @author Jake Botka
 *
 */
public class SerializedData {
	private byte[] mData;

	/**
	 * Constructor
	 * @param data Byte array of the data
	 */
	public SerializedData(byte[] data) {
		this.mData = data;
	}

	

	

	/**
	 * Gets serialized data.
	 * @return Serialized data.
	 * 
	 */
	public byte[] getSerializedData() {
		return this.mData;
	}

	/**
	 * Sets serialized dta
	 * @param mData Byte array of data
	 */
	public void setSerializedData(byte[] mData) {
		this.mData = mData;
	}


	@Override
	public String toString() {
		return "Data [mData=" + Arrays.toString(mData) + ", getSerializedData()=" + Arrays.toString(getSerializedData())
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
