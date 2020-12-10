/*
 * File name:  NetworkNode.java
 *
 * Programmer : Jake Botka
 *
 * Date: Sep 27, 2020
 *
 */
package main.org.botka.utility.api.network;

/**
 * Class that represents a node in a network
 *
 * @author Jake Botka
 *
 */
public class NetworkNode extends Node {

	private AddressInfo mAddressInfo;
	
	/**
	 * Constrcutor
	 */
	public NetworkNode() {
		this.mAddressInfo = null;
	}
	
	
	
	/**
	 * Constructor
	 * @param addressInfo Information on this nodes address information
	 */
	public NetworkNode(AddressInfo addressInfo) {
		this.mAddressInfo = addressInfo;
	}
	
	/**
	 * Constrcutor
	 */
	public NetworkNode( String id, AddressInfo addressInfo) {
		super(id);
		this.mAddressInfo = addressInfo;
	}
	
	/**
	 * @return String representation of this object
	 */
	@Override
	public String toString() {
		return super.toString();
	}
}
