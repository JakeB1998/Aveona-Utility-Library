/**
 * File Name: Filter.java
 * Programmer: Jake Botka
 * Date Created: Feb 2, 2021
 *
 */
package main.org.botka.utility.api.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter interface to apply filter functions/
 * @author Jake Botka
 *
 */
public interface  Filter<E> {

	
	public E filter(E filterable);
	public List<E> filterAll(List<E> filterables);
	public E[] filterAll(E[] filterables);
	
	
	
}
