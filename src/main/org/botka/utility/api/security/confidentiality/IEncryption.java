/*
 * File name:  IEncryption.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: Jun 12, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.security.confidentiality;

import javax.crypto.SecretKey;

/**
 * Interface for encryption operations
 *
 * @author Jake Botka
 *
 */
public interface IEncryption {
	public void encrypt();

	public void encrypt(SecretKey key);

	public void encrypt(SecretKey key, byte[] data);

	public void encrypt(SecretKey key, byte[] data, byte[] iv);

	public void encrypt(byte[] data);

	public void encrypt(byte[] data, byte[] key);

	public void encrypt(byte[] data, byte[] key, byte[] iv);

}
