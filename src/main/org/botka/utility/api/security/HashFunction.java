/*
 * File name:  HashFunction.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: Jun 21, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.security;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class for various hash functions.
 * Can not be extended from.
 *
 * @author Jake Botka
 *
 */
public final class HashFunction {

	/**
	 * 
	 * @param data
	 * @return
	 */
	public static String SHA256Hash(String data) {
		return SHA256Hash(data.getBytes());
	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public static String SHA256Hash(byte[] data) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
			return toHexString(md.digest(data));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param input
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
		// Static getInstance method is called with hashing SHA
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		return md.digest(input.getBytes(StandardCharsets.UTF_8));
	}

	/**
	 * 
	 * @param hash
	 * @return
	 */
	public static String toHexString(byte[] hash) {
		// Convert byte array into signum representation
		BigInteger number = new BigInteger(1, hash);
		// Convert message digest into hex value
		StringBuilder hexString = new StringBuilder(number.toString(16));
		// Pad with leading zeros
		while (hexString.length() < 32) {
			hexString.insert(0, '0');
		}
		return hexString.toString();
	}
}
