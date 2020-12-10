/*
 * File name:  Decryption.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: Jun 12, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.security.confidentiality;

import java.security.InvalidKeyException;
import java.security.Key;
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
public abstract class Decryption {
	private KeyAlgorithm mAlgorithmType;

	public Decryption() {

	}

	public Decryption(KeyAlgorithm algo) {
		this.mAlgorithmType = algo;
	}

	public abstract byte[] decrypt(byte[] data)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException;

	public abstract byte[] decrypt(byte[] data, Key key)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException;

	public KeyAlgorithm getAlgorithmType() {
		return mAlgorithmType;
	}

	public void setAlgorithmType(KeyAlgorithm mAlgorithmType) {
		this.mAlgorithmType = mAlgorithmType;
	}

	public String toString() {
		return super.toString();
	}

}
