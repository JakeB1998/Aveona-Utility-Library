/**
 * Result.java
 * Programmer: Jake Botka
 * Nov 25, 2020
 *
 */
package main.org.botka.utility.api.systems.autocomplete;

/**
 * @author Jake Botka
 *
 */
public abstract class Result {

	

	public static final  Result NO_RESULT = (Result) new MatchingResult.Builder().hasMatch(false);
	private int mScore;
	private boolean mHasResult;
	/**
	 *
	 */
	public Result() {
		this.mHasResult = true;
	}

	/**
	 *@param mScore
	 *@param mHasResult
	 */
	public Result(int score, boolean hasResult) {
		this();
		this.mScore = score;
		this.mHasResult = hasResult;
	}
	
	
	
	public int getScore() {
		return this.mScore;
	}
	
	public boolean hasResult() {
		return this.mHasResult;
	}
	
	public void setResult(boolean hasResult) {
		this.mHasResult = hasResult;
	}
	
	@Override
	public String toString() {
		return "Result [mScore=" + mScore + ", mHasResult=" + mHasResult + "]";
	}

	
	
	
}
