/**
 * File Name: IntMappable.java
 * Programmer: Jake Botka
 * Date Created: Jan 2, 2021
 *
 */
package main.org.botka.utility.api.base;

/**
 * Interface that maps implementing object instance to a primmitive integer.
 * @author Jake Botka
 *
 */
public interface IntMappable extends StringMappable {
	
	 /**
	 * @return 
	 */
	@Override
	default String mapToString() {
		return String.valueOf(mapToInt());
	}
	int mapToInt();
}
