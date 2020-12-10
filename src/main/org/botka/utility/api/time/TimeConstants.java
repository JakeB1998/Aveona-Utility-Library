/*
 * File name:  TimeConstants.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: May 28, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.time;

import java.time.Month;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class TimeConstants {
	public static final int YEARS_IN_CENTURY = 100;

	public static final int DECADES_IN_CENTURY = 10;

	//Days
	//Do days in each month
	public static final int DAYS_IN_YEAR = 365;
	public static final int DAYS_IN_YEAR_LEAP = 366;
	public static final int DAYS_IN_DECADE = -1;
	public static final int DAYS_IN_CENTURY = DAYS_IN_DECADE * DECADES_IN_CENTURY;

	//Hours
	public static final int HOURS_IN_DAY = 24;

	//Minutes
	public static final int MINUTES_IN_HOUR = 60;
	public static final int MINUTES_IN_DAY = MINUTES_IN_HOUR * HOURS_IN_DAY;

	//Seconds
	public static final int SECONDS_IN_MINUTE = 60;
	public static final int SECONDS_IN_HOUR = SECONDS_IN_MINUTE * 60;
	public static final int SECONDS_IN_DAY = SECONDS_IN_HOUR * 24;

	//Milliseconds
	public static final int MILLISECONDS_IN_SECOND = 1000;
	public static final int MILLISECONDS_IN_MINUTE = MILLISECONDS_IN_SECOND * 60;
	public static final long MILLISECONDS_IN_HOUR = MILLISECONDS_IN_MINUTE * 60;

	//Microseconds
	public static final int NANO_SECONDS_PER_MILLISECOND = 1000000;
	
	//Picoseconds

	public static int daysInMonth(Month month) {
		return -1;
	}
}
