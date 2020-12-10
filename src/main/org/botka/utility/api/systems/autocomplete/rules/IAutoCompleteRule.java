/**
 * IAutoCompleteRule.java
 * Programmer: Jake Botka
 * Nov 2, 2020
 *
 */
package main.org.botka.utility.api.systems.autocomplete.rules;

import main.org.botka.utility.api.systems.autocomplete.MatchingResult;
import main.org.botka.utility.api.systems.autocomplete.RuleResult;

/**
 * Interface class that all AutoComplete rules must implement for the AutoCompleteEngine.
 * @see AutoCompleteEngine.java.
 * @author Jake Botka
 *
 */
public interface IAutoCompleteRule {

	/**
	 * Gets the rule id. This id should be static to identifying different types of rules.
	 * @return ID represented as an integer.
	 */
	public int getRuleId();

	/**
	 * Gets the priority score of this rule.
	 * This is important for async operations with the AutoCompleteEngine as rules will be executed in order of priority.
	 * @return Rule priority represented by an integer.
	 */
	public int getRulePriority();

	/**
	 * Gets the scoring sceme of this rule as the query score will be incrimented in score based off of the return of this method.
	 * @return Rule scoring scheme.
	 */
	public int getRuleScoring();

	/**
	 * Executes the rule against a query.
	 * @param query
	 * @param record
	 * @return RuleResult object that contains information on the result of the query against @param record.
	 */
	public RuleResult executeRule(String query, String record);
	
	public default boolean hasLinkingRule() {
		return this.getLinkingRules() != null && this.getLinkingRules().length > 0;
	}
	public IAutoCompleteRule[] getLinkingRules();

	/**
	 * 
	 * @return Short description of what this rule is doing.
	 */
	public String getRuleDescription();
}
