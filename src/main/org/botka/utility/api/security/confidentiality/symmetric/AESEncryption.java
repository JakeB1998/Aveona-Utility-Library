/*
 * File name:  AESEncryption.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: Jun 10, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.security.confidentiality.symmetric;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import javafx.scene.canvas.Canvas;
import main.org.botka.utility.api.base.Timeout;
import main.org.botka.utility.api.security.KeyAlgorithm;

/**
 * AES encryption implementation
 *
 * @author Jake Botka
 *
 */
public class AESEncryption extends SymmetricEncryption {
	private final static KeyAlgorithm ALGORITHM = KeyAlgorithm.AES;
	//private final Timeout TIMEOUT = new Timeout(2);
	private boolean salted;


	/**
	 * 
	 */
	public AESEncryption() {
		super();
		this.generateNewKeys();
	}

	/**
	 * 
	 */
	public AESEncryption(SecretKey key) {
		super(key, ALGORITHM);
	}

	/**
	 * Encrypts byte data. Returns encrypted byte data encoded using Base64 encoding
	 * schema Throws errors to allow users to catch and handle them as they see fit
	 * 
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	@Override
	public byte[] encrypt(byte[] data) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		if (super.getSecretKey() != null) {

			Cipher cipher = null;

			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, super.getSecretKey());

			return Base64.getEncoder().encode(cipher.doFinal(data));

		}
		else {
			this.generateNewKeys();
			if (super.getSecretKey() != null) {
				return this.encrypt(data);
			}
			
			//throw error
		}
		return null;
	}

	@Override
	public void generateNewKeys() {
		KeyGenerator keyGen = null;
		try {
			keyGen = KeyGenerator.getInstance("AES");
			keyGen.init(256); // for example
			super.setSecretKey(keyGen.generateKey());
		} catch (NoSuchAlgorithmException e) {
			super.setSecretKey(null);
			e.printStackTrace();
		}
	}

	public String toString() {
		return super.toString();
	}

}
