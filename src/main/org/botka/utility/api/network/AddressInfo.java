/*
 * File name:  ClientAddressInfo.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 5, 2020
 *
 */
package main.org.botka.utility.api.network;

import java.net.Inet4Address;
import java.net.InetAddress;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class AddressInfo {

	private InetAddress mAddress;

	/**
	 * 
	 */
	public AddressInfo(InetAddress address) {
		this.mAddress = address;
	}

	public InetAddress getAddress() {
		return this.mAddress;
	}

}
