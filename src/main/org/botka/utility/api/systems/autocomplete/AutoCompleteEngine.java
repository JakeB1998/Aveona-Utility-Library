/**
 * AutoCompleteEngine.java
 * Programmer: Jake Botka
 * Nov 2, 2020
 *
 */
package main.org.botka.utility.api.systems.autocomplete;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import main.org.botka.utility.api.data.structures.arrays.BufferArray;
import main.org.botka.utility.api.systems.autocomplete.rules.AutoCompleteRule;
import main.org.botka.utility.api.systems.autocomplete.rules.AutoCompleteRules;
import main.org.botka.utility.api.systems.autocomplete.rules.IAutoCompleteRule;

/**
 * @author Jake Botka
 *
 */
public class AutoCompleteEngine implements IQueryResultsListener   {

	private static final int MAX_THREADS = 50;
	private AutoCompleteRules mRules;
	private ArrayList<Query> mQueries;
	private ArrayList<Query> mCompletedQueries;
	private AtomicInteger mTaskCompletedCount;
	private IQueryResultsListener mResultListener;
	private boolean mInitialized;
	private boolean mAsync;
	private ExecutorService mExecutor;
	
	/**
	 *
	 */
	public AutoCompleteEngine() {
		this.mRules = null;
		this.mQueries = new ArrayList<>(0);
		this.mCompletedQueries = new ArrayList<>();
		this.mTaskCompletedCount = new AtomicInteger(0);
		
	}

	public AutoCompleteEngine(AutoCompleteRules rules) {
		this();
		this.mRules = rules;
	}
	
	public AutoCompleteEngine(IAutoCompleteRule[] rules) {
		this(new AutoCompleteRules(rules));
	}
	
	public AutoCompleteEngine(List<? extends IAutoCompleteRule> rules) {
		this(new AutoCompleteRules(rules));
	}
	
	public void init(IQueryResultsListener callback, boolean async) {
		this.mResultListener = callback;
		this.mInitialized = true;
		this.mAsync = async;
		this.mExecutor = Executors.newFixedThreadPool(MAX_THREADS);
	}
	
	public void doRound() {
		if (this.mInitialized) {
			if (this.mAsync) {
				ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);
				Iterator<Query> iterator = this.mQueries.iterator();
				while (iterator.hasNext()) {
					Query query = iterator.next();
					iterator.remove();
					QueryRunnable run = new QueryRunnable(query, this.mRules);
					run.registerListener(this);
					run.registerListener(this.mResultListener);
					executor.submit(run);
				}
				
			}
			else {
				this.run();
			}
		}
		
	}
	private  void run() {
		Iterator iterator = this.mQueries.iterator();
	    while (iterator.hasNext()) {
	    	Query query = (Query) iterator.next();
	    	iterator.remove();
			for (String record : query.getRecords()) {
				Vector<RuleResult> results = new Vector<>();
				for (IAutoCompleteRule rule : this.mRules.getRules()) {
					RuleResult res = rule.executeRule(query.getQuery(), record);
					System.out.println("Record: " + res.getRecordString() + "\nQuery: " + res.getQueryString() 
					+ "\nscore: " + res.getScore() + "\nUsing rule: " 
							+ res.getRuleUsed().getRuleDescription() + "\n");
					results.add(res);
					if (res.getScore() > 0 && rule.hasLinkingRule()) {
						for (IAutoCompleteRule aRule : rule.getLinkingRules()) {
							System.err.println("Added extra res"  + aRule.getRuleScoring());
							results.add(new RuleResult(aRule.getRuleScoring(),aRule, query.getQuery(), record, null));
						}
					}
					
				}
				
				query.recordResult(new MatchingResult(record, results.toArray(new RuleResult[0])));
			}
			this.mCompletedQueries.add(query);
			if (this.mResultListener != null) {
				this.mResultListener.onResultListener(query.getResults());
			}
			this.mTaskCompletedCount.incrementAndGet();
		}
		
			
		
	}
	
	public void commitQuery(Query query) {
		this.mQueries.add(query);
		this.doRound();
		
	}
	public void commitQuery(String query, String[] records) {
		this.commitQuery(new Query(query,records));
		
	}
	
	public Query getQueryById(int id) {
		for (Query query : this.mQueries) {
			if (query.getQueryId() == id) {
				return query;
			}
		}
		
		for (Query completedQueries : this.mCompletedQueries) {
			if (completedQueries.getQueryId() == id) {
				return completedQueries;
			}
		}
		return null;
	}
	public List<Query> getQueries(){
		return this.mQueries;
	}
	
	public int getTaskCompletedCount() {
		return this.mTaskCompletedCount.get();
	}

	@Override
	public void onResultListener(QueryResult result) {
		this.mTaskCompletedCount.incrementAndGet();
		
	}
	
	
}
