/*
 * File name:  Key.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 19, 2020
 *
 */
package main.org.botka.utility.api.security;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class Key {

	/**
	 * 
	 * @param algorithm
	 * @return
	 */
	public static KeyAlgorithmType keyAlgorithmType(KeyAlgorithm algorithm) {
		// TODO
		return null;
	}

	/**
	 * 
	 * @param keyAlgorithmType
	 * @return
	 */
	public static KeyAlgorithm[] allKeyAlgorithmsOfType(KeyAlgorithmType keyAlgorithmType) {
		KeyAlgorithm[] algorithms = null;
		final KeyAlgorithm[] symmetricAlgorithms = {};
		final KeyAlgorithm[] asymmetricAlgorithms = {};
		switch (keyAlgorithmType) {
		case Asymmetric:
			algorithms = asymmetricAlgorithms;
			break;
		case Symmetric:
			algorithms = symmetricAlgorithms;
			break;
		default:
			break;

		}
		return algorithms;
	}
}
