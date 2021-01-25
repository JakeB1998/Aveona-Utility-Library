/**
 * File Name: Incrementer.java
 * Programmer: Jake Botka
 * Date Created: Jan 25, 2021
 *
 */
package main.org.botka.utility.api.base;

/**
 * Incrementer that increments along a linked value of incrementable objects.
 * @author Jake Botka
 *
 */
public class Incrementer<T extends Incrementable<T>> {

	private Incrementable<T> mStartingIncrementable;
	/**
	 * 
	 */
	public Incrementer() {
		mStartingIncrementable = null;
	}
	
	public Incrementer(Incrementable<T> startingIncrementable) {
		this();
		mStartingIncrementable = startingIncrementable;
	}
	
	@SuppressWarnings("unchecked")
	public T increment() {
		return increment((T) mStartingIncrementable);
	}
	
	public T decrement() {
		return decrement((T) mStartingIncrementable);
	}
	
	@SuppressWarnings("unchecked")
	public T increment(T value) {
		return value != null && value.canIncrement() ? value.increment() : null;
	}
	
	public T decrement(T value) {
		return value != null && value.canDecrement() ? value.decrement() : null;
	}
	
	@SuppressWarnings("unchecked")
	public boolean canIncrement() {
		return canIncrement((T) mStartingIncrementable);
	}
	
	public boolean canIncrement(T value) {
		return value != null ? value.canIncrement() : false;
	}
	
	@SuppressWarnings("unchecked")
	public boolean canDecrement() {
		return canDecrement((T) mStartingIncrementable);
	}
	
	public boolean canDecrement(T value) {
		return value != null ? value.canDecrement() : false;
	}

}
