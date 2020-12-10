/**
 * AutoCompleteTests.java
 * Programmer: Jake Botka
 * Nov 2, 2020
 *
 */
package test;

import static org.junit.Assert.*;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.org.botka.utility.api.systems.autocomplete.AutoCompleteEngine;
import main.org.botka.utility.api.systems.autocomplete.IQueryResultsListener;
import main.org.botka.utility.api.systems.autocomplete.MatchingResult;
import main.org.botka.utility.api.systems.autocomplete.Query;
import main.org.botka.utility.api.systems.autocomplete.QueryResult;
import main.org.botka.utility.api.systems.autocomplete.rules.AutoCompleteRule;
import main.org.botka.utility.api.systems.autocomplete.rules.AutoCompleteRules;
import main.org.botka.utility.api.systems.autocomplete.rules.ContainsRule;
import main.org.botka.utility.api.systems.autocomplete.rules.IAutoCompleteRule;
import main.org.botka.utility.api.systems.autocomplete.rules.StartsWithRule;
import main.org.botka.utility.api.util.ArrayUtil;

/**
 * @author Jake Botka
 *
 */
public class AutoCompleteTests {
	public String[] mStringData = {"hi", "bye","aabya", "ALe", "hi lovehi"};
	private CountDownLatch lock = new CountDownLatch(1);
	private Vector<IAutoCompleteRule> rules = new Vector(0);
	int queryId = 212;

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		if (rules == null) {
			rules = new Vector<>();
		}
		rules.clear();
		AutoCompleteRule rule = new StartsWithRule(999,3,20);
		rule.addLinkingRule((new ContainsRule(123, 2, 10)));
		rules.add(rule);
		
	}

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void basicTest() {
		Vector<String> results = new Vector<>();
		String query = "i";
		for (String x : this.mStringData) {
			if (x.contains(query)) {
				results.add(x);
			}
		}
		
		assertEquals(1, results.size());
	}
	
	@Test
	public void mainTest() {
		int queryId = 212;
		int queryId2 = 101;
		int queryId3 = 301;
		
		AutoCompleteEngine engine = new AutoCompleteEngine(rules);
		engine.init(new ResultCallback(), false);
		engine.commitQuery(new Query(queryId, "hi", this.mStringData));
		engine.commitQuery(new Query(queryId2, "by", this.mStringData));
		engine.commitQuery(new Query(queryId3, "ye", this.mStringData));
		printResults(engine, queryId);
		printResults(engine, queryId2);
		printResults(engine, queryId3);
		assertEquals(1, engine.getQueryById(queryId).getResults().getAllWithMathingResults().size());
	}
	
	@Test
	public void asyncTest() throws InterruptedException {
		
		
		AutoCompleteEngine engine = new AutoCompleteEngine(rules);
		engine.init(new ResultCallback(), true);
		Query[] queries = generateQueryRequests(100);
		
		for (Query q : queries) {
			engine.commitQuery(q);
		}
		lock.await(100, TimeUnit.MILLISECONDS);
		assertEquals(100, engine.getTaskCompletedCount());
	}

	@Test
	public void findRuleIdTest() {
		
	}
	
	@Test
	public void findRulePriorityTest() {
		
	}
	
	@Test
	public void findRulesPriorityTest() {
		
	}
	public Query[] generateQueryRequests(int amount) {
		Query[] arr = new Query[amount];
		for (int i =0; i < amount; i++) {
			arr[i] = new Query(queryId, randomString(3), this.mStringData);
		}
		return arr;
	}
	
	


	public static String randomString (int len){
		 final String AlphaNumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
	     StringBuilder sb = new StringBuilder(len);
	     for( int i = 0; i < len; i++ )
	        sb.append( AlphaNumeric.charAt( rnd.nextInt(AlphaNumeric.length()) ) );
	        return sb.toString();
	}
	
	public static void printResults(AutoCompleteEngine engine, int queryId) {
		System.out.println("\nResults for qquery: " + queryId);
		
		MatchingResult[] result1 = engine.getQueryById(queryId).getResults().getAllWithMathingResults().toArray(new MatchingResult[0]);
		String[] resultContent = new String[result1.length];
		int index = 0;
		System.err.println(result1.length);
		for (MatchingResult result : result1) {
			resultContent[index] = result.getMatchingRecord();
			System.out.println(resultContent[index] + " : " + result.getMatchingResultScore());
			index++;
		}
		//ArrayUtil.print(resultContent);
	}
	
	public static class ResultCallback implements IQueryResultsListener{

		@Override
		public void onResultListener(QueryResult result) {
			//assertEquals(1, result.getAllWithMathingResults().size());
			//System.out.println("Results count: " + result.getResults().size());
			
		}
		
	}
	
	
}
