/**
 * File Name: Incrementable.java
 * Programmer: Jake Botka
 * Date Created: Jan 25, 2021
 *
 */
package main.org.botka.utility.api.base;

/**
 * @author Jake Botka
 *
 */
public interface Incrementable<T>{
	
	public T increment();
	public T decrement();
	public boolean canIncrement();
	public boolean canDecrement();
	
	
}
