/*
 * File name:  SymmetricEncryption.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: Jun 10, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.security.confidentiality.symmetric;

import java.security.PrivateKey;

import javax.crypto.SecretKey;

import main.org.botka.utility.api.security.KeyAlgorithm;
import main.org.botka.utility.api.security.confidentiality.Encryption;

/**
 * Abstract class to represent symmetric encryption algorithms.
 *
 * @author Jake Botka
 *
 */
public abstract class SymmetricEncryption extends Encryption {
	private SecretKey mSecretKey;
	private boolean mSalted;

	/**
	 * 
	 */
	public SymmetricEncryption() {
		super();
	}

	/**
	 * 
	 */
	public SymmetricEncryption(SecretKey key) {
		super();
		this.setSecretKey(key);
	}

	/**
	 * 
	 */
	public SymmetricEncryption(SecretKey key, KeyAlgorithm algo) {
		super(algo);
		this.setSecretKey(key);
	}

	/**
	 * 
	 * @return
	 */
	public SecretKey getSecretKey() {
		return mSecretKey;
	}

	/**
	 * 
	 * @param mPrivateKey
	 */
	public void setSecretKey(SecretKey secretkey) {
		this.mSecretKey = secretkey;
	}

	public boolean isSalted() {
		return mSalted;
	}

	public void setSalted(boolean salted) {
		this.mSalted = salted;
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "\nEncrpytion Type: Symmetric" + "\nAlgorithm: " + super.getCipherAlgorithm()
				+ "\nKey Accocciated Algorithm: " + this.getSecretKey().getAlgorithm()
				+ "\nSalted: " + this.mSalted + "\nKey: " + new String(this.mSecretKey.getEncoded())
				+ "\nKey Length: " + this.mSecretKey.getEncoded().length + "\nKey Destroyed: "
				+ this.mSecretKey.isDestroyed();
	}

}
