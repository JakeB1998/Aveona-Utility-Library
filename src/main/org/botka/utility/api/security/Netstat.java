/**
 * Netstat.java
 * Programmer: Jake Botka
 * Nov 26, 2020
 *
 */
package main.org.botka.utility.api.security;

import java.util.concurrent.TimeUnit;

import org.eclipse.jdt.annotation.NonNull;

import main.org.botka.utility.api.exceptions.IllegalNullArguementException;
import main.org.botka.utility.api.util.Util;

/**
 * @author Jake Botka
 *
 */
public class Netstat {

	public static final String NETSTAT_LIVE_CONNECTIONS_COMMAND = "netstat -a";
	/**
	 * 
	 */
	public Netstat() {
		
	}
	
	public void accuireLiveConnectionsWithTimeout(@NonNull TimeUnit timeUnit, int amountOfUnit, @NonNull DataTransferListener<String> listener) {
		Util.checkNullArgumentAndThrow(listener, IllegalNullArguementException.formatEceptionMessage("listener"));
	}
	
	public boolean devicesupportsNetstat() {
		return false;
	}

}
