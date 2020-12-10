/*
 * File name:  AESDecryption.java
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
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import main.org.botka.utility.api.security.AESInformation;
import main.org.botka.utility.api.security.KeyAlgorithm;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class AESDecryption extends SymmetricDecryption {

	private final static KeyAlgorithm ALGORITHM = KeyAlgorithm.AES;
	//private final CallTimeout TIMEOUT = new CallTimeout(2);
	private String mTransformation;
	private boolean salted;

	/**
	 * 
	 */
	public AESDecryption() {
		super();
		this.mTransformation = AESInformation.DEFAULT_TRANSFORMATION;
	}

	/**
	 * 
	 */
	public AESDecryption(String transformation) {
		super();
		this.mTransformation = transformation;

	}

	/**
	 * 
	 */
	public AESDecryption(SecretKey key) {
		super(key);
		this.mTransformation = AESInformation.DEFAULT_TRANSFORMATION;
	}

	@Override
	public byte[] decrypt(byte[] data) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

		return this.decrypt(data, super.getKey());
	}

	@Override
	public byte[] decrypt(byte[] data, Key key)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {

		Cipher cipher = Cipher.getInstance(this.mTransformation);
		cipher.init(Cipher.DECRYPT_MODE, key);
		return cipher.doFinal(data);

	}

}
