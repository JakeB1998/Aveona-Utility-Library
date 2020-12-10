/*
 * File name:  Encryption.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: Jun 10, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.security.confidentiality;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import main.org.botka.utility.api.security.KeyAlgorithm;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public abstract class Encryption {
	private KeyAlgorithm mAlgorithmType;

	/**
	 * 
	 */
	public Encryption() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public Encryption(KeyAlgorithm algo) {
		this.setAlgorithmType(algo);
		// TODO Auto-generated constructor stub
	}

	public abstract byte[] encrypt(byte[] data)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException;

	public abstract void generateNewKeys();

	public KeyAlgorithm getCipherAlgorithm() {
		return mAlgorithmType;
	}

	public String getAlgorithm() {
		return this.mAlgorithmType.toString();
	}

	public void setAlgorithmType(KeyAlgorithm mAlgorithmType) {
		this.mAlgorithmType = mAlgorithmType;
	}

	public String toString() {
		return super.toString();
	}

}
