/*
 * File name:  AsyncyOperations.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: Jun 15, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.conccurency;

/**
 * absttract Class for a async threaded operation meant to be extended by
 * implementing class
 *
 * @author Jake Botka
 *
 */
public abstract class AsyncyOperation<T1, T2, T3> extends Async<T1> {

	private T1[] mParams;

	public AsyncyOperation() {
		super(); // thread to be create in async

	}

	public abstract T3 executeInBackround(T1[] params);

	public abstract void onProgressUpdate(T2 progress);

	public abstract T3 onResult(T3 result);

	/**
	 * called before the thread is created and executed Ovveriden by ASYNC<T!>
	 */
	@Override
	public void onPreExecute() {
		super.onPreExecute();

	}

	/**
	 * executes the threaded operation by passing the parameterized data to the
	 * executeInBackround abstract method that will call its overridden
	 * implementation
	 * 
	 * @param inititalizing input data for the threaded operation
	 */
	public void execute(T1[] params) {
		super.execute(params);
		this.mParams = params;
		super.start();
		System.out.println("Thread started");
	}

	/**
	 * Called after execution
	 */
	@Override
	public void onPostExecute() {
		System.out.println("Operation finished");
		super.onPostExecute();
	}

	/**
	 * Ran inside thread
	 */
	public void run() {
		System.out.println("running");
		T3 res = this.executeInBackround(this.mParams);
		this.onResult(res);
		this.onPostExecute();
	}

}
