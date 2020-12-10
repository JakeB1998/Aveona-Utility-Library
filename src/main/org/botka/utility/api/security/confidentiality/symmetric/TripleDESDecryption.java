/*
 * File name:  TripleDESDecryption.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: Jun 12, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.security.confidentiality.symmetric;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import main.org.botka.utility.api.security.KeyAlgorithm;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class TripleDESDecryption extends SymmetricDecryption {

	/**
	 * 
	 */
	public TripleDESDecryption() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param key
	 */
	public TripleDESDecryption(SecretKey key) {
		super(key);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param key
	 * @param algo
	 */
	public TripleDESDecryption(SecretKey key, KeyAlgorithm algo) {
		super(key, algo);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see botka.api.security.decryption.Decryption#decrypt(byte[])
	 */
	@Override
	public byte[] decrypt(byte[] data) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] decrypt(byte[] data, Key key)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
		return null;
	}

}
