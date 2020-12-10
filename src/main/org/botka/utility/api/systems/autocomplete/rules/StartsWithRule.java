/**
 * StartsWithRule.java
 * Programmer: Jake Botka
 * Nov 2, 2020
 *
 */

package main.org.botka.utility.api.systems.autocomplete.rules;



import main.org.botka.utility.api.systems.autocomplete.MatchDescriptor;
import main.org.botka.utility.api.systems.autocomplete.MatchingResult;
import main.org.botka.utility.api.systems.autocomplete.Result;
import main.org.botka.utility.api.systems.autocomplete.RuleResult;

/**
 * @author Jake Botka
 *
 */
public class StartsWithRule extends AutoCompleteRule {

	 
	public static final int DEFAULT_SCORING_INCREMENT = 20;
	
	
	
	/**
	 *
	 */
	public StartsWithRule() {
		
	}

	/**
	 *@param priority
	 *@param score
	 */
	public StartsWithRule(int id, int priority, int score) {
		super(id, priority, score, "Starts with Rule");
		
	}

	/**
	 *@param priority
	 *@param score
	 *@param ruleDesciption
	 */
	public StartsWithRule(int id, int priority, int score, String ruleDesciption) {
		super( id, priority, score, ruleDesciption);
		
	}
	
	/**
	 *@param priority
	 *@param score
	 *@param ruleDesciption
	 */
	public StartsWithRule(int id, int priority, int score, String ruleDesciption, IAutoCompleteRule... linkingRules) {
		super( id, priority, score, ruleDesciption);
		if (linkingRules != null) {
			for (IAutoCompleteRule rule : linkingRules) {
				super.addLinkingRule(rule);
			}
		}
		
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
		// TODO Auto-generated method stub
		return super.getScoring();
	}

	@Override
	public RuleResult executeRule(String query, String record) {
		return query != null && record != null && record.startsWith(query) ? new RuleResult(super.getScoring(), this,query,record,  new MatchDescriptor(null)) 
				: new RuleResult(0, this,query,record,  new MatchDescriptor(null));
	}

	@Override
	public String getRuleDescription() {
		// TODO Auto-generated method stub
		return super.getRuleDescription();
	}

	

	@Override
	public IAutoCompleteRule[] getLinkingRules() {
		return super.getLinkingRules();
	}

	

}
