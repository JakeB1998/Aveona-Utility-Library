/*
 * File name:  ServerExampleDriver.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 6, 2020
 *
 */
package main.org.botka.utility.api.network.server.examples;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;


import main.org.botka.utility.api.network.Client;
import main.org.botka.utility.api.network.Host;
import main.org.botka.utility.api.network.server.ClientConnectedListener;
import main.org.botka.utility.api.network.server.ClientRunnable;
import main.org.botka.utility.api.network.server.Server;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class ServerExampleDriver implements ClientConnectedListener {

	private static Host mHost;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			mHost = new Server(InetAddress.getLocalHost(), 4444);
			mHost.init(new ServerProgramRuunable());
			mHost.run();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onClientConnected(Client client) {
		/*
		Logger.log(getClass(), "Client Connected. Summary: \n" + client.toString(),
				true);
*/
	}

	/**
	 * 
	 * <insert class description here>
	 *
	 * @author Jake Botka
	 *
	 */
	public static class ServerProgramRuunable implements ClientRunnable {
		@Override
		public void run(Client client) {
			if (client != null) {
				//ConsoleLogger.Logger.log(getClass(), "Client being handled via callback interface",
					//	true);
				try {
					OutputStream outStream = client.getCLientSocket().getServerOutputStream();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

}
