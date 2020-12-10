package main.org.botka.utility.api.time;

/**
 * 
 * Custom stop watch class that can be used for any pupose such as testing to
 * time management.
 *
 * @author Jake Botka
 *
 */
public class Stopwatch {
	private long startTimeMil;
	private long stopTimeMil;
	private long currentTimeMil;

	public void start() {
		startTimeMil = System.currentTimeMillis();
	}

	public void stop() {
		stopTimeMil = System.currentTimeMillis();
	}

	public void reset() {
		startTimeMil = -1;
		stopTimeMil = -1;
	}

	public void getCurrentDuration() {
		currentTimeMil = System.currentTimeMillis() - startTimeMil;
		System.out.println("Current time duration : " + currentTimeMil);
	}

	public void printResults() {
		long results = stopTimeMil - startTimeMil;
		System.out.println("Start time : " + startTimeMil + "\n End Time : " + stopTimeMil
				+ "\n Difference  : " + results);
	}

}
