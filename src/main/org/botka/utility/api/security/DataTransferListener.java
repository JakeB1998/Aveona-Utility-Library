/**
 * DataTransferListener.java
 * Programmer: Jake Botka
 * Nov 26, 2020
 *
 */
package main.org.botka.utility.api.security;

/**
 * @author Jake Botka
 *
 */
public interface DataTransferListener<T>  {

	void onDataStransferCallback(T[] dataArray);
}
