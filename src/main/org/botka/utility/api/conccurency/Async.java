/*
 * File name:  Async.java
 *
 * Programmer : Jake Botka
 *
 * Date: Jul 20, 2020
 *
 */
package main.org.botka.utility.api.conccurency;

/**
 * Async abstract base class fo all async operation that require threading
 *
 * @author Jake Botka
 *
 */
public abstract class Async<T1> extends Thread {

	public Async() {
		super();
	}

	/**
	 * 
	 */
	public Async(Runnable runnable) {
		super(runnable);
	}

	public void execute(T1[] params) {
		this.onPreExecute();
		// execute
		this.onPostExecute();
	}

	public void onPreExecute() {

	}

	public void onPostExecute() {

	}

	@Override
	public void run() {

	}

}
