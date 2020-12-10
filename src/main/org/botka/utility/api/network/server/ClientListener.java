/*
 * File name:  ClientListener.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 5, 2020
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
public interface ClientListener {

	Client onNewCLientConnection();
}
