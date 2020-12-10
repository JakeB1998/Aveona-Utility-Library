/**
 * SynchronizedFileMap.java
 * Programmer: Jake Botka
 * Nov 19, 2020
 *
 */
package main.org.botka.utility.api.data.structures.maps;

import java.util.Hashtable;

/**
 * @author Jake Botka
 *
 */
public class SynchronizedFileMap<K> extends FileMap<K> {

	public SynchronizedFileMap() {
		super(new Hashtable<>());
	}
	
	@Override
	public boolean isSyncronized() {
		return true;
	}
}
