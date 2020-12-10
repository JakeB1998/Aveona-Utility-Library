/*
 * File name:  Encryption.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: Jun 12, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.examples;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import main.org.botka.utility.api.security.confidentiality.Encryption;
import main.org.botka.utility.api.security.confidentiality.symmetric.AESEncryption;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class EncryptionExample {

	/**
	 * Main method This is to show encryption. The necryption calls can be used to
	 * encrypt multiple data with specified options and params
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String dataS = "This is my data";
		byte[] data = dataS.getBytes();
		byte[] encryptedData = null;

		Encryption encryption = null;
		AESEncryption aesNoparam = new AESEncryption(); // no param generates a
														// key for you
		AESEncryption aes = new AESEncryption(EncryptionExample.generateKey());

		try {
			encryptedData = aesNoparam.encrypt(data);
			System.out.println("Encrypted Data Without Parameters: "
					+ new String(aesNoparam.encrypt(encryptedData)));

			System.out.println(
					"Encrypted Data With Parameters: " + new String(aes.encrypt(encryptedData)));

			encryption = (Encryption) aes;

			System.out.println("Encrypted Data From parent abstract class: "
					+ new String(encryption.encrypt(encryptedData)));
			System.out.println("\nEncryption information: " + encryption.toString());
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static SecretKey generateKey() {
		KeyGenerator keyGen = null;

		try {
			keyGen = KeyGenerator.getInstance("AES");
			keyGen.init(256); // for example
			return keyGen.generateKey();
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		return null;

	}

}
