/**
 * QueryRunnable.java
 * Programmer: Jake Botka
 * Nov 2, 2020
 *
 */
package main.org.botka.utility.api.systems.autocomplete;

import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

import main.org.botka.utility.api.systems.autocomplete.rules.AutoCompleteRules;
import main.org.botka.utility.api.systems.autocomplete.rules.IAutoCompleteRule;

/**
 * @author Jake Botka
 *
 */
public class QueryRunnable implements Runnable {

	private Query mQuery;
	private Vector<IQueryResultsListener> mResultListener;
	private AutoCompleteRules mRules;
	
	
	public QueryRunnable() {
		this.mResultListener = new Vector<>();
	}
	/**
	 *
	 */
	public QueryRunnable(Query query) {
		this();
		this.mQuery = query;
		
	}
	
	public QueryRunnable(Query query, AutoCompleteRules rules) {
		this(query);
		this.mRules = rules;
		
		
	}
	

	public void registerListener(IQueryResultsListener listener) {
		this.mResultListener.add(listener);
	}
	@Override
	public void run() {
		final Query query = this.mQuery;
		for (String record : query.getRecords()) {
			Vector<RuleResult> results = new Vector<>();
			for (IAutoCompleteRule rule : this.mRules.getRules()) {
				results.add(rule.executeRule(query.getQuery(), record));
			}
			query.recordResult(new MatchingResult(record, results.toArray(new RuleResult[0])));
		
		}
		if (this.mResultListener != null) {
			for (IQueryResultsListener listener : this.mResultListener) {
				listener.onResultListener(query.getResults());
			}
		}
		
		

	}

}
