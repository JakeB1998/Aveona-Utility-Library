/*
 * File name:  Client.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 5, 2020
 *
 */
package main.org.botka.utility.api.network;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;

import main.org.botka.utility.api.network.server.ClientSocket;

/**
 * 
 * Class to be used on a server side program that provides information about
 * clients
 *
 * @author Jake Botka
 *
 */
public class Client extends Node {

	private AddressInfo mAddressInfo;
	private ClientSocket mClientSocket;

	/**
	 * 
	 * @param addressInfo Adress wrapper object
	 */
	public Client(AddressInfo addressInfo) {
		this.mAddressInfo = addressInfo;
	}

	/**
	 * 
	 * @param address
	 */
	public Client(InetAddress address) {
		this(new AddressInfo(address));
	}

	public Client(Socket socket) {

		this(socket.getInetAddress());
	}

	public ClientSocket getCLientSocket() {
		return this.mClientSocket;
	}

	public void setSocket(Socket socket) {
		this.mClientSocket = new ClientSocket(socket);
	}

}
