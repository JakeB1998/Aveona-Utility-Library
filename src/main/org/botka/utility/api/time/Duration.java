package main.org.botka.utility.api.time;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class Duration {
	private long mTotalMilliseconds;
	private int mMilliseconds;
	private int mSec, mMin, mHour;
	private int mDay;

	/**
	 * 
	 */
	public Duration() {
		this.mSec = 0;
		this.mMin = 0;
		this.mHour = 0;
		this.mDay = 0;

	}

	/**
	 * 
	 * @param sec
	 * @param min
	 * @param hour
	 * @param day
	 */
	public Duration(int sec, int min, int hour, int day) {
		this.mSec = sec;
		this.mMin = min;
		this.mHour = hour;
		this.mDay = day;
	}

	/**
	 * Updates duration by adding a number of seconds to the current duration
	 * 
	 * @param second
	 */
	public void updateDuration(int second) {

		int seconds = 0;
		seconds = second + this.mSec;
		seconds += this.mMin * 60;
		seconds += this.mHour * 60 * 60;
		seconds += this.mDay * 24 * 60 * 60;

		this.mTotalMilliseconds = seconds * 1000;

		this.mHour = (int) seconds / 3600;
		int remainder = (int) seconds - this.mHour * 3600;
		this.mMin = remainder / 60;
		remainder = remainder - this.mMin * 60;
		this.mSec = remainder;

	}

	/**
	 * 
	 * @param milliseconds
	 */
	public void updateDuration(long milliseconds) {

	}

	/**
	 * 
	 * @param second
	 * @param minute
	 * @param hour
	 * @param day
	 */
	public void updateDuration(int second, int minute, int hour, int day) {

	}

	/**
	 * @return the mSec
	 */
	public long getSec() {
		return mSec;
	}

	/**
	 * @param mSec the mSec to set
	 */
	public void setSec(int mSec) {
		this.mSec = mSec;
	}

	/**
	 * @return the mMin
	 */
	public long getMinute() {
		return mMin;
	}

	/**
	 * @param mMin the mMin to set
	 */
	public void setMinute(int mMin) {
		this.mMin = mMin;
	}

	/**
	 * @return the mHour
	 */
	public long getHour() {
		return mHour;
	}

	/**
	 * @param mHour the mHour to set
	 */
	public void setHour(int mHour) {
		this.mHour = mHour;
	}

	/**
	 * @return the mDay
	 */
	public int getmDay() {
		return mDay;
	}

	/**
	 * @param mDay the mDay to set
	 */
	public void setmDay(int mDay) {
		this.mDay = mDay;
	}

	/**
	 * 
	 */
	public String toString() {
		return "\nDay(s): " + this.mDay + "\nHour(s): " + this.mHour + "\nMinute(s): " + this.mMin
				+ "\nSecond(s): " + this.mSec;

	}

}
