/*
 * File name:  DurationTimerExample.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: Jun 15, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.examples;

import main.org.botka.utility.api.time.Duration;
import main.org.botka.utility.api.time.DurationTimer;
import main.org.botka.utility.api.time.ITimeListener;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class DurationTimerExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Duration dur = new Duration();
		DurationTimer timer = new DurationTimer(dur);
		timer.registerListener(new Listener());
		timer.startTimer();

		System.out.println(timer);
		timer.stopTimer();
		System.out.println(timer);

	}

	/**
	 * 
	 * Implements interface listener
	 *
	 * @author Jake Botka
	 *
	 */
	private static class Listener implements ITimeListener {
		@Override
		public void onTimeUpdated(Duration duration) {
			System.out.println(duration);

		}
	}

}
