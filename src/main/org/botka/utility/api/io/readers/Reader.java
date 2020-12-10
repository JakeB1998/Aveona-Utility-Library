/**
 * Reader.java
 * Programmer: Jake Botka
 * Nov 15, 2020
 *
 */
package main.org.botka.utility.api.io.readers;

/**
 * @author Jake Botka
 *
 */
public abstract class Reader {

	private int mID;
	public Reader() {
		
	}
	
	public Reader(int id) {
		this();
		this.mID = id;
	}
}
