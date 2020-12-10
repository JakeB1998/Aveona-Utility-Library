/**
 * ContainsRule.java
 * Programmer: Jake Botka
 * Nov 25, 2020
 *
 */
package main.org.botka.utility.api.systems.autocomplete.rules;

import main.org.botka.utility.api.systems.autocomplete.MatchDescriptor;
import main.org.botka.utility.api.systems.autocomplete.RuleResult;

/**
 * @author Jake Botka
 *
 */
public class ContainsRule extends AutoCompleteRule {

	public static final int DEFAULT_SCORING_INCREMENT = 20;
	
	/**
	 *
	 */
	public ContainsRule() {
		// TODO Auto-generated constructor stub
	}

	/**
	 *@param id
	 *@param priority
	 *@param score
	 */
	public ContainsRule(int id, int priority, int score) {
		super(id, priority, score, "ContainsRUle");
		// TODO Auto-generated constructor stub
	}

	/**
	 *@param id
	 *@param priority
	 *@param score
	 *@param ruleDesciption
	 */
	public ContainsRule(int id, int priority, int score, String ruleDesciption) {
		super(id, priority, score, ruleDesciption);
		//
	}

	@Override
	public int getRuleId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public int getRulePriority() {
		// TODO Auto-generated method stub
		return super.getPriority();
	}

	@Override
	public int getRuleScoring() {
		return super.getScoring();
	}

	@Override
	public RuleResult executeRule(String query, String record) {
		return query != null && record != null && record.contains(query) ? new RuleResult(super.getScoring(),  this,query,record,  new MatchDescriptor(null)) 
				: new RuleResult(0, this,query,record,  new MatchDescriptor(null));
	}

	/**
	 * 
	 */
	@Override
	public IAutoCompleteRule[] getLinkingRules() {
		return null;
	}
	
	public String toString() {
		return String.valueOf(super.getScoring());
	}

}
