/**
 * AutoCompleteRule.java
 * Programmer: Jake Botka
 * Nov 2, 2020
 *
 */
package main.org.botka.utility.api.systems.autocomplete.rules;

import java.util.Vector;

import java.util.Vector;

/**
 * Implementation abstract class to represent all Auto complete rules.This class implements the interface IAutoCompleteRule.
 * @see IAutoCompleteRule.java.
 * @author Jake Botka
 *
 */
public abstract class AutoCompleteRule implements IAutoCompleteRule {

	private Vector<IAutoCompleteRule> mLinkingRules;
	private String mRuleDescription;
	private int mID;
	private int mPriority;
	private int mScoring;
	
	/**
	 * Default constructor.
	 */
	public AutoCompleteRule() {
		this.mLinkingRules = new Vector<>();
	}
	
	public AutoCompleteRule(int id,int priority, int score) {
		this();
		this.mID = id;
		this.mPriority = priority;
		this.mScoring = score;
	}
	
	public AutoCompleteRule(int id, int priority, int score, String ruleDesciption) {
		this(id, priority,score);
		this.mRuleDescription = ruleDesciption;
	}
	
	public int getId() {
		return this.mID;
	}
	
	public String getRuleDescription() {
		return mRuleDescription;
	}

	public void setRuleDescription(String RuleDescription) {
		this.mRuleDescription = RuleDescription;
	}

	public int getPriority() {
		return mPriority;
	}

	public void setPriority(int Priority) {
		this.mPriority = Priority;
	}

	public int getScoring() {
		return mScoring;
	}

	public void setScoring(int Scoring) {
		this.mScoring = Scoring;
	}
	
	public void addLinkingRule(IAutoCompleteRule linkingRule) {
		this.mLinkingRules.add(linkingRule);
	}
	
	public IAutoCompleteRule[] getLinkingRules() {
		return this.mLinkingRules.toArray(new IAutoCompleteRule[0]);
	}

	
	/**
	 * @return String representation of this object.
	 */
	public String toString() {
		return super.toString();
	}

}
