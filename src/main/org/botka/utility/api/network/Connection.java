/*
 * File name:  Connection.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 5, 2020
 *
 */
package main.org.botka.utility.api.network;

import java.net.Inet4Address;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class Connection {

	private Inet4Address mAdress1;
	private Inet4Address mAdress2;
	private boolean mConnected;

	/**
	 * 
	 */
	public Connection(Inet4Address socket1Address, Inet4Address socket2Address) {
		this.mAdress1 = socket1Address;
		this.mAdress2 = socket2Address;

	}

	public boolean establishConnection() {
		return false;
	}

	public boolean isConnected() {
		return this.mConnected;
	}

}
