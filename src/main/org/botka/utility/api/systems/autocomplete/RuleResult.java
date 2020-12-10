/**
 * RuleResult.java
 * Programmer: Jake Botka
 * Nov 25, 2020
 *
 */
package main.org.botka.utility.api.systems.autocomplete;

import main.org.botka.utility.api.systems.autocomplete.rules.IAutoCompleteRule;

/**
 * @author Jake Botka
 *
 */
public class RuleResult extends Result {
	public static final  RuleResult NO_RESULT = new RuleResult.Builder().hasMatch(false);
	private MatchDescriptor mMatchDescriptor;
	private IAutoCompleteRule mRuleUsed;
	private String mQuery;
	private String mRecord;
	//private int[][] mIndecesOfMatchingContent;
	//private String mMatchingContent;
	
	/**
	 *
	 */
	private RuleResult() {
		super();
		this.mMatchDescriptor = null;
	}
	
	public RuleResult(int score,  IAutoCompleteRule ruleOrigin, String query, String record, MatchDescriptor matchDescriptor) {
		super(score,true);
		this.mQuery = query;
		this.mRecord = record;
		this.mRuleUsed = ruleOrigin;
		this.mMatchDescriptor = matchDescriptor;
	}

	
	

	/**
	 * @return the mMatchDescriptor
	 */
	public MatchDescriptor getMatchDescriptor() {
		return mMatchDescriptor;
	}

	/**
	 * @param mMatchDescriptor the mMatchDescriptor to set
	 */
	public void setmMatchDescriptor(MatchDescriptor matchDescriptor) {
		this.mMatchDescriptor = matchDescriptor;
	}

	/**
	 * @return the mQuery
	 */
	public String getQueryString() {
		return mQuery;
	}

	/**
	 * @param mQuery the mQuery to set
	 */
	public void setQuery(String query) {
		this.mQuery = query;
	}

	/**
	 * @return the mRecord
	 */
	public String getRecordString() {
		return mRecord;
	}

	/**
	 * @param mRecord the mRecord to set
	 */
	public void setRecord(String record) {
		this.mRecord = record;
	}

	public IAutoCompleteRule getRuleUsed() {
		return this.mRuleUsed;
	}
	@Override
	public String toString() {
		return "RuleResult [mMatchDescriptor=" + mMatchDescriptor + ", mRuleUsed=" + mRuleUsed + ", mQuery=" + mQuery
				+ ", mRecord=" + mRecord + "]";
	}

	/**
	 * 
	 * @author Jake Botka
	 *
	 */
	public static class Builder{
		private RuleResult mResult;
		public Builder() {
			this.mResult = new RuleResult();
		}
		
		public RuleResult hasMatch(boolean hasMatch) {
			this.mResult.setResult(hasMatch);
			return this.mResult;
		}
		
		
	}
	
	
}
