/*
 * File name:  Node.java
 *
 * Programmer : Jake Botka
 *
 * Date: Sep 27, 2020
 *
 */
package main.org.botka.utility.api.network;

import main.org.botka.utility.api.security.IDGenerator;

/**
 * Base class that represents a node
 *
 * @author Jake Botka
 *
 */
public abstract class Node {
	private String mID;

	/**
	 * 
	 */
	public Node() {
		this.mID = IDGenerator.generateSecureID();
	}

	/**
	 * 
	 * @param id ID of the node
	 */
	public Node(String id) {
		if (id != null) {
			this.mID = id;
		} else {
			this.mID = IDGenerator.generateSecureID();
		}
	}
	
	/**
	 * @return String representation of this object
	 */
	public String toString() {
		return super.toString();
	}

}
