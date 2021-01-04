/**
 * File Name: FloatMappable.java
 * Programmer: Jake Botka
 * Date Created: Jan 2, 2021
 *
 */
package main.org.botka.utility.api.base;

/**
 * Interface that maps implementing object instance to a float.
 * @author Jake Botka
 *
 */
public interface FloatMappable extends IntMappable, StringMappable {
	
	/**
	 * @return
	 */
	@Override
	default int mapToInt() {
		return (int) mapToFloat();
	}
	
	/**
	 * @return
	 */
	@Override
	default String mapToString() {
		return String.valueOf(mapToFloat());
	}
	
	float mapToFloat();

}
