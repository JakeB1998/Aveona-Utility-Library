/**
 * MatchDescriptor.java
 * Programmer: Jake Botka
 * Nov 25, 2020
 *
 */
package main.org.botka.utility.api.systems.autocomplete;

import java.util.Arrays;

/**
 * @author Jake Botka
 *
 */
public class MatchDescriptor {

	private int[][] mIndecesOfMatchingContent;
	/**
	 *
	 */
	public MatchDescriptor() {
		// TODO Auto-generated constructor stub
	}
	
	public MatchDescriptor(int[][] indecesOfMAtchingContent) {
		this.mIndecesOfMatchingContent = indecesOfMAtchingContent;
	}

	public int[][] getIndecesOfMatchingContent(){
		return this.mIndecesOfMatchingContent;
	}
	
      /**
	 * @param mIndecesOfMatchingContent the mIndecesOfMatchingContent to set
	 */
	public void setIndecesOfMatchingContent(int[][] indecesOfMatchingContent) {
		this.mIndecesOfMatchingContent = indecesOfMatchingContent;
	}

	@Override
	public String toString() {
		return "MatchDescriptor [mIndecesOfMatchingContent=" + Arrays.toString(mIndecesOfMatchingContent) + "]";
	}
}
