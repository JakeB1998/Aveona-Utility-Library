/*
 * File name:  ClientConnectedListener.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 6, 2020
 *
 */
package main.org.botka.utility.api.network.server;

import main.org.botka.utility.api.network.Client;

/**
 * Interface listener that callbacks with information on a client
 *
 * @author Jake Botka
 *
 */
public interface ClientConnectedListener {
	void onClientConnected(Client client);
}
