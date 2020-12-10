/*
 * File name:  ClientSocket.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 6, 2020
 *
 */
package main.org.botka.utility.api.network.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Wrapper class for Socket that is not the host socket
 *
 * @author Jake Botka
 *
 */
public class ClientSocket {

	private Socket mClientSocket;

	/**
	 * 
	 */
	public ClientSocket(Socket socket) {
		this.mClientSocket = socket;
	}

	public Socket getClientSocket() {
		// TODO Auto-generated method stub
		return this.mClientSocket;
	}
	
	public boolean isClosed() {
		if (this.mClientSocket != null)
			return this.mClientSocket.isClosed();
		return false;
	}

	public InputStream getClientInputStream() throws IOException {
		if (this.mClientSocket != null)
			return this.mClientSocket.getInputStream();
		return null;
	}

	public OutputStream getServerOutputStream() throws IOException {
		if (this.mClientSocket != null)
			return this.mClientSocket.getOutputStream();
		return null;
	}

}
