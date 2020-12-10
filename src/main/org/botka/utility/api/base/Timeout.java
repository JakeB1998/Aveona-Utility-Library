/**
 * Timeout.java
 * Programmer: Jake Botka
 * Nov 26, 2020
 *
 */
package main.org.botka.utility.api.base;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Async class that allows a timeout callback that callbacks when the duration of the provided length of time is reached.
 * @author Jake Botka
 *
 */
public class Timeout {

	private final long AMOUNT;
	private final TimeUnit TIMEUNIT;
	private final TimeoutListener TIME_OUT_LISTENER;
	private volatile boolean mStarted;
	private volatile boolean mFinished;
	
	/**
	 * 
	 */
	public Timeout(final long amount, final TimeUnit timeUnit, final TimeoutListener listener) {
		AMOUNT = amount;
		TIMEUNIT = timeUnit;
		TIME_OUT_LISTENER = listener;
	}
	
	/**
	 * 
	 */
	public Timeout(final long amount, final TimeUnit timeUnit, final TimeoutListener listener, boolean startNow) {
		this(amount,timeUnit,listener);
		if (startNow) {
			this.start();
		}
	}
	
	/**
	 * 
	 * @return Trrue if started, otherwise false.
	 *
	 */
	public boolean start() {
		if (!this.mStarted && this.mFinished == false) {
			ExecutorService executorService = Executors.newSingleThreadExecutor();
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					mStarted = true;
					CountDownLatch latch = new CountDownLatch(1);
					try {
						latch.await(AMOUNT, TIMEUNIT);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						mFinished = true;
						if (TIME_OUT_LISTENER != null) {
							TIME_OUT_LISTENER.onTimeout(AMOUNT, TIMEUNIT);
						}
					}
				}
			});
		}
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isStarted() {
		return this.mStarted;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isFinished() {
		return this.mFinished;
	}

	/**
	 * @return
	 * 
	 */
	@Override
	public String toString() {
		return "Timeout [AMOUNT=" + AMOUNT + ", TIMEUNIT=" + TIMEUNIT + ", TIME_OUT_LISTENER=" + TIME_OUT_LISTENER
				+ ", mStarted=" + mStarted + ", mFinished=" + mFinished + "]";
	}
	
	
	

	
}
