/*
 * File name:  DigitalSignature.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: Jun 20, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class DigitalSignature extends Signature {
	public enum SignatureValidationPhase {
		Unsigned, Signed, Validated, Error
	}

	private boolean mSigned;
	private boolean mVerified;
	private boolean mInvalid;
	private String mAlgorithm, mSummary;

	private SignatureValidationPhase mSignaturePhase;

	/**
	 * 
	 */
	public DigitalSignature() {
		mAlgorithm = "RSA"; // nit to defaul

	}

	/**
	 * 
	 */
	public DigitalSignature(String algorithm) {
		mAlgorithm = algorithm; // nit to defaul
	}

	@Override
	public void sign(PrivateKey key) throws Exception {
		if (super.hasSignature() == false) {
			Cipher cipher;
			try {
				cipher = Cipher.getInstance("RSA");
				cipher.init(Cipher.ENCRYPT_MODE, key);
				byte[] digitalSignature = cipher.doFinal(
						HashFunction.SHA256Hash(IDGenerator.generateSecureID()).getBytes());
			} catch (NoSuchAlgorithmException e) {

				e.printStackTrace();
				this.mInvalid = true;
				throw new Exception(
						"Provided Algorithm does not exist, Destroy this object and recreate");

			} catch (NoSuchPaddingException e) {
				this.mInvalid = true;
				e.printStackTrace();
			} catch (InvalidKeyException e) {
				this.mInvalid = true;
				e.printStackTrace();
				throw new Exception("Provided Key is invalid");
			} catch (IllegalBlockSizeException e) {
				this.mInvalid = true;
				e.printStackTrace();
			} catch (BadPaddingException e) {
				this.mInvalid = true;
				e.printStackTrace();
			}

			this.mSigned = true;
		} else {
			// TODO: handle signature then recall method
		}

	}

	@Override
	public boolean verify(PublicKey key) {
		if (super.hasSignature() == true && this.isSigned() == true) {
			// TODO: Insert verfy code

			return true;
		}
		return false;
	}

	/**
	 * 
	 */
	@Override
	public boolean isSigned() {
		return this.mSigned;
	}

	/**
	 * 
	 */
	@Override
	public boolean isVerified() {
		return this.mVerified;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isInvalid() {
		return this.mInvalid;
	}

	/**
	 * Provides a current summary of the sate of this digital signature and which
	 * phase it is in
	 * 
	 * @return
	 */
	public String getSignatureSummary() {
		if (this.mSigned) {
			if (this.mVerified == true && this.mInvalid == false) {
				return "Signature has be validated, This is the siganture of the reciepient of the public key provided";
			}
			if (this.mInvalid) {

				return "Has been signed. Verification proecess has failed due to error";
			}

		} else {
			return "Has not been signed Yet";
		}

		return "Erorr";

	}

	public SignatureValidationPhase getSignatureSatus() {
		return this.mSignaturePhase;
	}

	public String toString() {
		return "\nSignature: " + new String(super.getSignature()) + "\nSigned: " + this.mSigned
				+ "\nVerified: " + this.mVerified;
	}

}
