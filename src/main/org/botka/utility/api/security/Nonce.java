/**
 * Nonce.java
 * Programmer: Jake Botka
 * Nov 1, 2020
 *
 */
package main.org.botka.utility.api.security;

import java.util.Comparator;

/**
 * Class that represents a onnly used once number called a nonce.
 * @author Jake Botka
 *
 */
public class Nonce implements Comparable<Nonce>, Comparator<Nonce> {

	private int mNonce;
	/**
	 * Constructor.
	 * @param nounce Nounce number.
	 */
	public Nonce(int nonce) {
		this.setNonce(nonce);
	}
	
	
	public int getNonce() {
		return this.mNonce;
	}
	
	public void setNonce(int nonce) {
		this.mNonce = nonce;
	}
	
	/**
	 * @return Nounce value inside this object.
	 */
	public String toString() {
		return String.valueOf(this.mNonce);
	}


	@Override
	public int compare(Nonce o1, Nonce o2) {
		if (o1 == null || o2 == null) {
			return 0;
		}
		return o1.getNonce() - o2.getNonce();
	}


	@Override
	public int compareTo(Nonce arg0) {
		if (arg0 != null) {
			return this.getNonce() - arg0.getNonce();
		}
		return 0;
	}

}
