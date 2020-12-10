/**
 * MatchingResult.java
 * Programmer: Jake Botka
 * Nov 2, 2020
 *
 */
package main.org.botka.utility.api.systems.autocomplete;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * @author Jake Botka
 *
 */
public class MatchingResult extends Result {

	public static final MatchingResult NO_RESULT = new Builder().hasMatch(false);
	private int mScoreSum;
	private RuleResult[] mRuleResults;
	//private int[][] mIndecesOfMatchingContent;
	private String mRecordString;
	/**
	 *
	 */
	public MatchingResult() {
		super();
	}
	
	public MatchingResult(int scoreSum) {
		super(scoreSum, true);
		this.mScoreSum = scoreSum;
	}
	
	
	public MatchingResult(String record, @NonNull RuleResult[] ruleResults) {
		super(0, true);
		int scoreSum = 0;
		int index = 0;
		this.mRecordString = record;
		for (RuleResult result : ruleResults) {
			if (result != null) {
				scoreSum += result.getScore();
			} else {
				throw new NullPointerException("Rule result element: " + index + " was null");
			}
			index++;
		}
		this.mScoreSum = scoreSum;
	}
	
	public MatchingResult(String matchingContent, @NonNull List<RuleResult> ruleResults) {
		this(matchingContent,ruleResults.toArray(new RuleResult[0]));
	}
	
	public int getMatchingResultScore() {
		return this.mScoreSum;
	}
	
	public String getMatchingRecord() {
		return this.mRecordString;
	}
	

	@Override
	public String toString() {
		return "MatchingResult [mScoreSum=" + mScoreSum + ", mRuleResults=" + Arrays.toString(mRuleResults)
				+ ", mRecordString=" + mRecordString + "]";
	}


	public static class Builder{
		private MatchingResult mResult;
		public Builder() {
			this.mResult = new MatchingResult();
		}
		
		public MatchingResult hasMatch(boolean hasMatch) {
			this.mResult.setResult(hasMatch);
			return this.mResult;
		}
	}
}
