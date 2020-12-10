/**
 * SequentialNonceGenerator.java
 * Programmer: Jake Botka
 * Nov 1, 2020
 *
 */
package main.org.botka.utility.api.security;

import java.util.Arrays;
import java.util.Vector;

/**
 * @author Jake Botka
 *
 */
public class SequentialNonceGenerator extends NonceGenerator {

	/**
	 *
	 */
	public SequentialNonceGenerator() {
		super();
	}
	
	/**
	 * @param usedNonces
	 */
	public SequentialNonceGenerator(int[] usedNonces) {
		super(usedNonces);
	
	}

	/**
	 * @param usedNonces
	 */
	public SequentialNonceGenerator(Nonce[] usedNonces) {
		super(usedNonces);
		
	}

	@Override
	public int nextNounce() {
		Nonce[] n = new Nonce[super.getUsedNonces().size()];
		n = super.getUsedNonces().toArray(n);
		Nonce nonce =  nextNounce(n);
		return nonce != null ? nonce.getNonce() : -1;
	}

	@Override
	public int nextNounce(int[] sortedNonceHistory) {
		if (sortedNonceHistory != null) {
			
			Vector<Integer> triedNonces = new Vector<Integer>(0);
			int random = -1;
			while (true) {
				while (true) {
					
					int bound = sortedNonceHistory.length > 0 ? sortedNonceHistory[sortedNonceHistory.length - 1] + 100 : 100;
					random = SECURE_RANDOM.nextInt(bound);
					if (triedNonces.size() == 0) {
						break;
					}
					boolean flag = false; // represents if the number has alreeady been tried before searching the array
					for (int i = 0; i < triedNonces.size(); i++) {
						
						if (random == triedNonces.get(i).intValue()){
							
							flag = true;
						}
					}
					
					if (!flag) {
						
						break;
					}
					
				}
				int index = Arrays.binarySearch(sortedNonceHistory, random);
				
				if (index < 0) {
					return random;
				}
				else {
					triedNonces.add(random);
				}
			}
			
		}
		
		return -1;
	}
	
	@Override
	public Nonce nextNounce(Nonce[] sortedNonceHistory) {
		if (sortedNonceHistory != null) {
			int[] sortedNonces = new int[sortedNonceHistory.length];
			for (int i =0; i < sortedNonces.length; i++) {
				if (sortedNonceHistory[i] != null) {
					sortedNonces[i] = sortedNonceHistory[i].getNonce();
				}
			}
			return new Nonce(this.nextNounce(sortedNonces));
		}
		return null;
	}

	@Override
	public boolean hasBeenUsed(int number) {
		return false;
	}

	@Override
	public boolean isSequentialMethod() {
		return true;
	}

	@Override
	public boolean isRandomMethod() {
		return false;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	

	

}
