/*
 * File name:  Network.java
 *
 * Programmer : Jake Botka
 *
 * Date: Sep 27, 2020
 *
 */
package main.org.botka.utility.api.network;

import java.util.Iterator;
import java.util.Vector;

/**
 * Class that represents a network and its contents
 *
 * @author Jake Botka
 *
 */
public class Network {

	private Vector<NetworkNode> mNetworkNodes;
	
	/**
	 * 
	 */
	public Network() {
		this.mNetworkNodes = new Vector<NetworkNode>();
	}
	
	/**
	 * 
	 * @param networkNodes
	 */
	public Network(NetworkNode[] networkNodes) {
		this();
		if (networkNodes != null) {
			for (NetworkNode node : networkNodes) {
				this.mNetworkNodes.add(node);
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Vector<NetworkNode> getNetworkVectorArray(){
		return this.mNetworkNodes;
	}
	
	public NetworkNode[] getNodesInNetwork() {
		if (this.mNetworkNodes != null) {
			NetworkNode[] nodes = new NetworkNode[this.mNetworkNodes.size()];
			Iterator iterator = this.mNetworkNodes.iterator();
			int index = 0;
			while (iterator.hasNext()) {
				nodes[index] = (NetworkNode)iterator.next();
				index++;
			}
		}
		return null;
	}
	
	/**
	 * @return String representation of object
	 */
	public String toString() {
		return super.toString();
	}

}
