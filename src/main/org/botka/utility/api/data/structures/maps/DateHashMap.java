/**
 * File Name: DateHashMap.java
 * Programmer: Jake Botka
 * Date Created: Dec 7, 2020
 *
 */
package main.org.botka.utility.api.data.structures.maps;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 * Key is LocalDate.java and value is List<Type param>.
 * @author Jake Botka
 *
 */
public class DateHashMap<T> extends HashMap<LocalDate, List<T>> implements MappedList {

	public DateHashMap() {
		super();
	}
	
	public DateHashMap(int initialSize) {
		super(initialSize);
	}
	
	public T addItemToMappedCollection(LocalDate date, T item) {
		return this.put(date, item);
	}
	
	/**
	 * Will put list into map if key does not exist inside the map.
	 * If the key does exist in the map it will not replace but CONCAT the list together.
	 * @param date
	 * @param dateContent
	 * @return
	 *
	 */
	public List<T> put(LocalDate date, List<T> dateContent){
		return null;
	}
	
	public T put(LocalDate date, T item) {
		return null;
	}
	public List<T> getByDate(LocalDate date){
		if (super.containsKey(date)) {
			return super.get(date);
		}
		return null;
	}
	public String toString() {
		return super.toString();
	}
}
