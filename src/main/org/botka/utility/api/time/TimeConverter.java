package main.org.botka.utility.api.time;

import java.util.concurrent.TimeUnit;

/**
 * Class to convert time units between eachother.
 * @author Jake Botka
 *
 */
public class TimeConverter {
	/**
	 * 
	 * @param from
	 * @param to
	 * @param fromValue
	 * @return
	 */
	public static long convert(TimeUnit from, TimeUnit to, double fromValue) {
		long value = -1;
		long mil = convertToMilliseconds(from, fromValue);

		switch (to) {
		case DAYS:
			break;
		case HOURS:
			break;
		case MICROSECONDS:
			break;
		case MILLISECONDS:
			
			break;
		case MINUTES:
			break;
		case NANOSECONDS:
			break;
		case SECONDS:
			
			break;
		default:
			break;

		}
		return mil;
	}

	

	/**
	 * Converts time unity to milliseconds
	 * 
	 * @param unit
	 * @param unitValue
	 * @return
	 */
	public static long convertToMilliseconds(TimeUnit unit, double unitValue) {
		long value = -1;
		switch (unit) {
		case DAYS:
			value = (long) (unitValue * TimeConstants.MILLISECONDS_IN_HOUR * 24);
			break;
		case HOURS:
			value = (long) (unitValue * TimeConstants.MILLISECONDS_IN_HOUR);
			break;
		case MICROSECONDS:
			break;
		case MILLISECONDS:
			value = (long) unitValue;
			break;
		case MINUTES:
			value = (long) (unitValue * TimeConstants.MILLISECONDS_IN_MINUTE); // evaluate then cast
			break;
		case NANOSECONDS:
			break;
		case SECONDS:
			value = (long) (unitValue * TimeConstants.MILLISECONDS_IN_SECOND);
			break;
		default:
			break;

		}
		return value;
	}

	

}
