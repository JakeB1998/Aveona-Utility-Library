/**
 * AutoCompleteRules.java
 * Programmer: Jake Botka
 * Nov 2, 2020
 *
 */
package main.org.botka.utility.api.systems.autocomplete.rules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Wrapper class that contains all the rules for the auto complete engine to use/
 * @author Jake Botka
 *
 */
public class AutoCompleteRules {

	private List<IAutoCompleteRule> mRules;
	
	/**
	 * Default constructor.
	 */
	public AutoCompleteRules() {
		this.mRules = new ArrayList<>(0);
	}

	/**
	 * Constructor.
	 * @param rules Auto complete rules.
	 */
	public AutoCompleteRules(IAutoCompleteRule[] rules) {
		this.mRules = new ArrayList<>(Arrays.asList(rules));
	}
	
	
	
	/**
	 *@param rules
	 */
	public AutoCompleteRules(List<? extends IAutoCompleteRule> rules) {
		this.mRules = (List<IAutoCompleteRule>) rules;
	}

	/**
	 * Constructor.
	 * @param rules Auto complete rules.
	 */
	public IAutoCompleteRule findRuleByIndex(int index) {
		return this.mRules != null && this.mRules.size() - 1 <= index ? this.mRules.get(index) : null;
	}
	
	/**
	 * 
	 * @param id
	 * @return Rule.
	 *
	 */
	public IAutoCompleteRule findRuleById(int id) {
		for (IAutoCompleteRule rule : this.mRules) {
			if (rule.getRuleId() == id) {
				return rule;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param priority
	 * @return First found Rule.
	 *
	 */
	public IAutoCompleteRule findRuleByPriority(int priority) {
		for (IAutoCompleteRule rule : this.mRules) {
			if (rule.getRulePriority() == priority) {
				return rule;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param priority
	 * @return All rules that meet condition.
	 *
	 */
	public IAutoCompleteRule[] findRulesByPriority(int priority) {
		Vector<IAutoCompleteRule> rules = new Vector<>();
		for (IAutoCompleteRule rule : this.mRules) {
			if (rule.getRulePriority() == priority) {
				rules.add(rule);
			}
		}
		return rules.size() > 0 ? rules.toArray(new IAutoCompleteRule[0]) : null;
	}
	
	/**
	 * 
	 * @return
	 *
	 */
	public IAutoCompleteRule[] getRules() {
		return this.mRules.toArray(new IAutoCompleteRule[0]);
	}
	public String toString() {
		return super.toString();
	}
}
