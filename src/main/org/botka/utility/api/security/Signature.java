package main.org.botka.utility.api.security;

import java.security.PrivateKey;
import java.security.PublicKey;

public abstract class Signature {

	private byte[] mSignature;

	/**
	 * Overrides default constructor.
	 */
	public Signature() {

	}

	public abstract void sign(PrivateKey key) throws Exception;

	public abstract boolean verify(PublicKey key);

	public abstract boolean isSigned();

	public abstract boolean isVerified();

	public boolean hasSignature() {
		if (this.getSignature().length > 0) // getSiganture handles if it is null and return a
											// length of zero if is null
		{
			return true;
		}
		return false;
	}

	/**
	 * Returns the signature in the form as an encoded byte array. If the array is
	 * null or a signature is absent then it returns an array with a length of 0
	 * 
	 * @return mSignature
	 */
	public byte[] getSignature() {
		if (this.mSignature == null) {
			return new byte[0];
		}
		return this.mSignature;
	}

}
