/*
 * File name:  Host.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 5, 2020
 *
 */
package main.org.botka.utility.api.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import main.org.botka.utility.api.network.server.ClientConnectedListener;
import main.org.botka.utility.api.network.server.ClientRunnable;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public abstract class Host extends NetworkNode {

	/**
	 * 
	 */
	public Host() {

	}

	public abstract void init(ClientRunnable clientRunnable);

	public abstract void run() throws IOException;

	public abstract void registerClientConnectedListener(ClientConnectedListener callback);

	public abstract Socket getServerSocket();

	public abstract InputStream getServerInputStream() throws IOException;

	public abstract OutputStream getServerOutputStream() throws IOException;

	public abstract int getPortNumber();

}
