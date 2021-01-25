/**
 * AbstractReader.java
 * Programmer: Jake Botka
 * Nov 15, 2020
 *
 */
package main.org.botka.utility.api.io.readers;

/**
 * @author Jake Botka
 *
 */
public abstract class AbstractReader {

	private int mID;
	public AbstractReader() {
		mID = -1;
	}
	
	public AbstractReader(int id) {
		this();
		this.mID = id;
	}

	public int getID() {
		return mID;
	}
	
	public void setID(int id) {
		mID = id;
	}
	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "AbstractReader [mID=" + mID + "]";
	}
}
