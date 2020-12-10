package main.org.botka.utility.api.time;

/**
 * Duration Timer formated in HH/MM/SS
 *
 * @author Jake Botka
 *
 */
public class DurationTimer {
	private volatile Duration mCurrentDuration; // Duration object volatile for instant updates to
												// the main thread from a background thread ran by
												// AsyncTimer
	private AsyncTimer mTimer; // AsyncTimer class multithreaded to avoid thread interruption in the
								// main thread
	private ITimeListener mTimeUpdateListener; // update interface callback

	/**
	 * Overrides the default constructor Creates a default Duration object since one
	 * is not provided for the class by the programmer/User.
	 */
	public DurationTimer() {
		this.mCurrentDuration = new Duration();
	}

	/**
	 * Constructor
	 * 
	 * @param duration Object. Assigns duration to variable to be layer used by the
	 *                 inner private class AsyncTimer
	 */
	public DurationTimer(Duration duration) {
		this.mCurrentDuration = duration;
	}

	/**
	 * Starts async timer
	 */
	public void startTimer() {
		if (this.mTimer != null) {
			if (this.mTimer.isStopped()) {
				this.mTimer = new AsyncTimer();
				this.mTimer.start();
			} else {
				this.mTimer.restart();
			}
		} else {
			this.mTimer = new AsyncTimer();
			this.mTimer.start();
		}
	}

	/**
	 * Stops async timer
	 */
	public void stopTimer() {
		this.mTimer.halt();
	}

	/**
	 * Registers listener for time update callbacks
	 * 
	 * @param listener
	 */
	public void registerListener(ITimeListener listener) {
		this.mTimeUpdateListener = listener;
	}

	/**
	 * Returns a duration wrapper object
	 * 
	 * @return Duration
	 */
	public Duration getDuration() {
		return this.mCurrentDuration;
	}

	/**
	 * 
	 * @param duration
	 */
	public void setDuration(Duration duration) {
		this.mCurrentDuration = duration;
	}

	/**
	 * Determines if the timer is currently active
	 * 
	 * @return true if active, false otherwise
	 */
	public boolean isActive() {
		if (this.mTimer != null) {

			if (!(this.mTimer.isStopped()) && !(this.mTimer.isHalted())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 
	 */
	public String toString() {
		return "\nActive : " + this.isActive() + "\nDuration: " + this.mCurrentDuration.toString();
	}

	private class AsyncTimer extends Thread {
		private boolean halt;
		private boolean stop;

		public void run() {

			long millisecond = System.currentTimeMillis();
			int check = 0;
			while (stop == false) {
				while (halt == false) {

					check = (int) (System.currentTimeMillis() - millisecond);
					if (check >= 1000) {

						mCurrentDuration.updateDuration((int) check / 1000);
						millisecond = System.currentTimeMillis();

						if (mTimeUpdateListener != null) {
							mTimeUpdateListener.onTimeUpdated(mCurrentDuration);
						}
					}
				}
			}
		}

		public void halt() {
			halt = true;
		}

		public void restart() {
			halt = false;
		}

		public void destroyThread() {
			stop = true;
		}

		public boolean isStopped() {
			return this.stop;
		}

		public boolean isHalted() {
			return this.halt;
		}
	}

}
