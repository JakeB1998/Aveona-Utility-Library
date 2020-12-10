/**
 * QueryResult.java
 * Programmer: Jake Botka
 * Nov 2, 2020
 *
 */
package main.org.botka.utility.api.systems.autocomplete;

import java.util.List;
import java.util.Vector;

import org.eclipse.jdt.annotation.NonNull;

/**
 * @author Jake Botka
 *
 */
public class QueryResult {

	private Query mQuery;
	private List<MatchingResult> mQueryResults;
	/**
	 *
	 */
	public QueryResult() {
		this.mQuery = null;
		this.mQueryResults = new Vector<>();
	}
	
	public QueryResult(Query query) {
		this();
		this.mQuery = query;
	}
	
	/**
	 *@param mQuery
	 *@param mQueryResults
	 */
	public QueryResult(Query query, List<MatchingResult> queryResults) {
		this.mQuery = query;
		if (queryResults != null) {
			this.mQueryResults = queryResults;
		}
	}
	
	public boolean addMatchResult(@NonNull MatchingResult result) {
		if (result != null) {
			this.mQueryResults.add(result);
			return true;
		}
		return false;
	}
	/**
	 * @return the Query
	 */
	public Query getQuery() {
		return mQuery;
	}
	/**
	 * @param Query the query to set
	 */
	public void setQuery(Query query) {
		this.mQuery = query;
	}
	
	public List<MatchingResult> getResults() {
		return this.mQueryResults;
	}
	
	public List<MatchingResult> getAllWithMathingResults(){
		List<MatchingResult> result = new Vector<>();
		for (MatchingResult mRes : this.getResults()) {
			if (mRes.hasResult()) {
				result.add(mRes);
			}
		}
		
		return result;
	}

	@Override
	public String toString() {
		return "QueryResult [mQuery=" + mQuery + ", mQueryResults=" + mQueryResults + "]";
	}

}
