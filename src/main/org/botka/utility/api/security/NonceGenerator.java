/**
 * NonceGenerator.java
 * Programmer: Jake Botka
 * Nov 1, 2020
 *
 */
package main.org.botka.utility.api.security;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

/**
 * 
 * @author Jake Botka
 *
 */
public abstract class NonceGenerator {

	public static final SecureRandom SECURE_RANDOM = new SecureRandom();
	private ArrayList<Nonce> mUsedNonces;
	/**
	 * Default constructor.
	 */
	public NonceGenerator() {
		this.mUsedNonces = new ArrayList<>(0);
	}
	
	/**
	 * 
	 *@param usedNonces
	 */
	public NonceGenerator(int[] usedNonces) {
		this();
		if (usedNonces != null) {
			Arrays.sort(usedNonces);
			Nonce[] nonces = new Nonce[usedNonces.length];
			for (int x : usedNonces) {
				this.mUsedNonces.add(new Nonce(x));
			}
			
			for (Nonce n : getUsedNonces()) {
				System.out.println(String.valueOf(n));
			}
			
		}
		
	}
	
	/**
	 * 
	 *@param usedNonces
	 */
	public NonceGenerator(Nonce[] usedNonces) {
		this();
		if (usedNonces != null) {
			this.mUsedNonces = (ArrayList<Nonce>) Arrays.asList(usedNonces);
			Collections.sort(this.mUsedNonces);
		}
	}
	
	public abstract int nextNounce();
	public abstract int nextNounce(int[] sortedNonceHistory);
	public abstract Nonce nextNounce(Nonce[] sortedNonceHistory);
	public abstract boolean hasBeenUsed(int number);
	public abstract boolean isSequentialMethod();
	public abstract boolean isRandomMethod();
	
	/**
	 * Generates a nonce randomly that has not been used before.
	 * @param nonceSortedHistory Sorted array of used nonces.
	 * @return A generated nonce object that contains the nonce.
	 *
	 */
	public static Nonce generateNonce(int[] nonceSortedHistory) {
		if (nonceSortedHistory != null) {
			Vector<Integer> triedNonces = new Vector<Integer>(0);
			int random = -1;
			while (true) {
				while (true) {
					int bound = nonceSortedHistory.length > 0 ? nonceSortedHistory[nonceSortedHistory.length - 1] + 100 : 100;
					random = SECURE_RANDOM.nextInt(bound);
					if (triedNonces.size() == 0) {
						break;
					}
					boolean flag = false; // represents if the number has alreeady been tried before searching the array
					for (int i = 0; i < triedNonces.size(); i++) {
						if (random == triedNonces.get(i).intValue());{
							flag = true;
						}
					}
					
					if (!flag) {
						break;
					}
					
				}
				int index = Arrays.binarySearch(nonceSortedHistory, random);
				if (index == -1) {
					return new Nonce(random);
				}
				else {
					triedNonces.add(random);
				}
			}
			
		}
		return null;
		
	}
	
	/**
	 * 
	 * @return List of used nonces.
	 *
	 */
	public ArrayList<Nonce> getUsedNonces() {
		return mUsedNonces;
	}

	/**
	 * Sets the arraylist of used nonces
	 * @param mUsedNonces
	 *
	 */
	public void setUsedNonces(ArrayList<Nonce> mUsedNonces) {
		this.mUsedNonces = mUsedNonces;
	}

	/**
	 * @return String representation of object.
	 */
	public String toString() {
		return super.toString();
	}

}
