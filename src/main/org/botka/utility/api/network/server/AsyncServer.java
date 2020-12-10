/*
 * File name:  AsyncServer.java
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
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

import main.org.botka.utility.api.network.AddressInfo;
import main.org.botka.utility.api.network.Host;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class AsyncServer extends Server {

	public AsyncServer(InetAddress address, int portNumber) {
		super(address, portNumber);
		// TODO Auto-generated constructor stub
	}

	public AsyncServer(InetAddress address, int portNumber, ClientConnectedListener callback) {
		super(address, portNumber, callback);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see botka.com.openjdk.api.network.Host#run()
	 */
	@Override
	public void run() throws IOException {

		ServerSocket serverSocket = new ServerSocket(super.getPortNumber());
		ServerSocketChannel serverChannel = serverSocket.getChannel();
		serverChannel.configureBlocking(false);
		// This is how you open a Selector
		Selector selector = Selector.open();
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		while (!Thread.currentThread().isInterrupted()) {

			selector.select(6000);
			Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

			while (keys.hasNext()) {
				SelectionKey key = keys.next();
				// remove the key so that we don't process this OPERATION again.
				keys.remove();

				// key could be invalid if for example, the client closed the connection.
				if (!key.isValid()) {
					continue;
				}

				if (key.isAcceptable()) {
					System.out.println("Accepting connection");

				}

				if (key.isWritable()) {
					System.out.println("Writing...");

				}

				if (key.isReadable()) {
					System.out.println("Reading connection");

				}
			}

		}
	}
}
