/**
 * TimeoutListener.java
 * Programmer: Jake Botka
 * Nov 26, 2020
 *
 */
package main.org.botka.utility.api.base;

import java.util.concurrent.TimeUnit;

/**
 * @author Jake Botka
 *
 */
public interface TimeoutListener {
	void onTimeout(long amount, TimeUnit timeUnit);
}
