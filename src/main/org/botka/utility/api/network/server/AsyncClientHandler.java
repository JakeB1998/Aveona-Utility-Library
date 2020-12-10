/*
 * File name:  AsyncClientHandler.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 5, 2020
 *
 */
package main.org.botka.utility.api.network.server;

import java.util.ArrayList;

import main.org.botka.utility.api.network.Client;

/**
 * Bass class that handles clients so that they can be threaded and not block eachother.
 *
 * @author Jake Botka
 *
 */
public class AsyncClientHandler {
	private ClientConnectedListener mClientConnectionedListner;
	private ClientRunnable mRunnable; // program the server runs for each client interation
	private ArrayList<ClientThreadWrapper> mClients;

	/**
	 * 
	 */
	public AsyncClientHandler(ClientRunnable clientRunnable) {
		this.mRunnable = clientRunnable;
		this.mClients = new ArrayList(0);
	}
	
	public void registerClientConnectionedListener(ClientConnectedListener listener) {
		this.mClientConnectionedListner = listener;
	}

	/**
	 * 
	 * @param client
	 */
	public void handleClient(Client client) {
		if (this.mClientConnectionedListner != null) {
			this.mClientConnectionedListner.onClientConnected(client);
		}
		Thread thread = new Thread(new ClientHandler(client));
		this.mClients.add(new ClientThreadWrapper(thread, client));
		thread.start();
	}

	/**
	 * Provides the method of getting all connected clients as an array
	 * 
	 * @return Array of Client objects
	 */
	public Client[] getCLients() {
		if (this.mClients != null) {
			Client[] arr = new Client[this.mClients.size()];
			for (int i = 0; i < this.mClients.size(); i++) {
				arr[i] = this.mClients.get(i).getCLient();
			}
		}

		return null;
	}

	/**
	 * 
	 * <insert class description here>
	 *
	 * @author Jake Botka
	 *
	 */
	private class ClientHandler implements Runnable {
		private Client mClient;

		public ClientHandler(Client client) {
			this.mClient = client;
		}

		@Override
		public void run() {
			if (mClient != null) {
				mRunnable.run(mClient);
			}

		}
	}

	private class ClientThreadWrapper {
		private Thread mThread;
		private Client mClient;

		public ClientThreadWrapper(Thread thread, Client client) {
			this.mThread = thread;
			this.mClient = client;

		}

		public Client getCLient() {
			return this.mClient;
		}

		public Thread getThread() {
			return this.mThread;
		}
	}

}
