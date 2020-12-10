/*
 * File name:  SymmetricDecryption.java
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
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import main.org.botka.utility.api.security.KeyAlgorithm;
import main.org.botka.utility.api.security.confidentiality.Decryption;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public abstract class SymmetricDecryption extends Decryption {
	private SecretKey mSecretKey;
	private boolean mSalted;

	/**
	 * 
	 */
	public SymmetricDecryption() {

	}

	/**
	 * 
	 */
	public SymmetricDecryption(SecretKey key) {
		super();
		this.setSecretKey(key);
	}

	/**
	 * 
	 */
	public SymmetricDecryption(SecretKey key, KeyAlgorithm algo) {
		super(algo);
		this.setSecretKey(key);
	}

	public SecretKey getKey() {
		return this.mSecretKey;
	}

	private void setSecretKey(SecretKey key) {
		this.mSecretKey = key;

	}

	public String toString() {
		return "\nDecrpytion Type: Symmetric" + "\nAlgorithm: " + super.getAlgorithmType()
				+ "\nSalted: " + this.mSalted + "\nKey: " + new String(this.mSecretKey.getEncoded())
				+ "\nKey Length: " + this.mSecretKey.getEncoded().length + "\nKey Destroyed: "
				+ this.mSecretKey.isDestroyed();
	}
}
