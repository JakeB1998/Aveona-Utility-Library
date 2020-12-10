/*
 * File name:  Server.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 5, 2020
 *
 */
package main.org.botka.utility.api.network.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

import main.org.botka.utility.api.logger.ConsoleLogger;
import main.org.botka.utility.api.network.AddressInfo;
import main.org.botka.utility.api.network.Client;
import main.org.botka.utility.api.network.Connection;
import main.org.botka.utility.api.network.Host;

/**
 * Class that represents a server.
 *
 * @author Jake Botka
 *
 */
public class Server extends Host {

	private Socket mServerSocket;
	private AsyncClientHandler mClientHandler;
	private AddressInfo mAddressInfo;
	private int mPortNumber;

	private boolean mInitialized;
	private boolean mRunning;
	private ClientConnectedListener mClientConnectedCallback;

	/**
	 * 
	 */
	public Server(InetAddress address, int portNumber) {
		this.mInitialized = false;
		this.mAddressInfo = new AddressInfo(address);
		this.mPortNumber = portNumber;

	}

	/**
	 * 
	 */
	public Server(InetAddress address, int portNumber, ClientConnectedListener callback) {
		this(address, portNumber);
		this.mClientConnectedCallback = callback;
	}

	/**
	 * 
	 */
	@Override
	public void init(ClientRunnable clientRunnable) {
		if (clientRunnable != null) {
			this.mClientHandler = new AsyncClientHandler(clientRunnable);
			this.mInitialized = true;
		}

	}

	/**
	 * @throws IOException
	 * 
	 */
	@Override
	public void run() throws IOException {
		Socket socket = null;
		ServerSocket serverSocket = null;
		if (this.mPortNumber > 0) {

			if (serverSocket != null && this.mInitialized == true) {
				this.mRunning = true;
				while (this.mRunning) {
					socket = serverSocket.accept();
					Client client = new Client(socket);
					this.handleClient(client);
				}
			}
		}
	}

	public void stopServer() {
		this.mRunning = false;
	}

	@Override
	public Socket getServerSocket() {
		// TODO Auto-generated method stub
		return this.mServerSocket;
	}

	@Override
	public InputStream getServerInputStream() throws IOException {
		if (this.mServerSocket != null)
			return this.mServerSocket.getInputStream();
		return null;
	}

	@Override
	public OutputStream getServerOutputStream() throws IOException {
		if (this.mServerSocket != null)
			return this.mServerSocket.getOutputStream();
		return null;
	}

	public AddressInfo getServerAddressInfo() {
		return this.mAddressInfo;
	}

	@Override
	public int getPortNumber() {

		return this.mPortNumber;
	}

	public ClientConnectedListener getClientConnectedListenerCallback() {
		return this.mClientConnectedCallback;
	}

	@Override
	public void registerClientConnectedListener(ClientConnectedListener callback) {
		this.mClientConnectedCallback = callback;

	}

	protected AsyncClientHandler getClientHandler() {
		return this.mClientHandler;
	}

	protected void handleClient(Client client) {
		this.mClientConnectedCallback.onClientConnected(client);
		if (this.mClientHandler != null) {
			this.mClientHandler.handleClient(client);
		}
	}

}
