/**
 * AsyncOrderedExececution.java
 * Programmer: Jake Botka
 * Dec 3, 2020
 *
 */
package main.org.botka.utility.api.conccurency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.eclipse.jdt.annotation.NonNull;

/**
 * @author Jake Botka
 *
 */
public class AsyncOrderedExececution {

	private BlockingQueue<Runnable> mBlockingQue;
	private ExecutorService mExecutors;
	
	public AsyncOrderedExececution() {
		this.mExecutors = Executors.newSingleThreadExecutor();
	}
	
	public boolean submit(@NonNull Runnable runnable) {
		return this.mBlockingQue.add(runnable);
	}
	
	
	
	
}
