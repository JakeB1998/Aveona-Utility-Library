/*
 * File name:  ConnectionListener.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 5, 2020
 *
 */
package main.org.botka.utility.api.network.server;

import main.org.botka.utility.api.network.AddressInfo;
import main.org.botka.utility.api.network.Connection;

/**
 * Interface class that executes calllbacks to provide information o an eastablished connection
 *
 * @author Jake Botka
 *
 */
public interface ConnectionListener {
	public void onConnectionEstablished(Connection connection);
}
