/*
 * File name:  ClientRunnable.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 6, 2020
 *
 */
package main.org.botka.utility.api.network.server;

import main.org.botka.utility.api.network.Client;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public interface ClientRunnable {
	void run(Client client);
}
