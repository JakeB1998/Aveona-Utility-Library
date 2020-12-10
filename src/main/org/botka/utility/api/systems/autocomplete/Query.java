/**
 * Query.java
 * Programmer: Jake Botka
 * Nov 2, 2020
 *
 */
package main.org.botka.utility.api.systems.autocomplete;

import java.util.Arrays;
import java.util.Vector;

import org.eclipse.jdt.annotation.NonNull;

/**
 * @author Jake Botka
 *
 */
public class Query {
	private int mId;
	private String mQuery;
	private String[] mRecords;
	private QueryResult mResults;
	

	/**
	 *
	 */
	public Query() {
		this.mQuery = null;
		this.mRecords = null;
		this.mResults = null;
	}
	
	public Query(String query, String[] records) {
		this();
		this.mQuery = query;
		this.mRecords = records;
		this.mResults = new QueryResult(this);
	}
	
	public Query(int id, String query, String[] records) {
		this(query,records);
		this.mId = id;
		
	}
	
	
	public boolean recordResult(MatchingResult ruleResult) {
		if (ruleResult != null) {
			return this.mResults.addMatchResult(ruleResult);
			
		}
		return false;
	}
	
	public int getQueryId() {
		return this.mId;
	}

	/**
	 * @return the Query
	 */
	public String getQuery() {
		return mQuery;
	}

	/**
	 * @param Query the Query to set
	 */
	public void setQuery(String query) {
		this.mQuery = query;
	}

	/**
	 * @return the Records
	 */
	public String[] getRecords() {
		return mRecords;
	}

	/**
	 * @param Records the Records to set
	 */
	public void setRecords(String[] records) {
		this.mRecords = records;
	}

	/**
	 * @return the Results
	 */
	public QueryResult getResults() {
		return mResults;
	}

	/**
	 * @param Results the Results to set
	 */
	public void setResults(QueryResult results) {
		this.mResults = results;
	}

	/**
	 * @return 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Query) {
			Query query = (Query)obj;
			return this.getQueryId() == query.getQueryId();
		}
		return false;
	}
	
	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "Query [mId=" + mId + "\nmQuery=" + mQuery + "\nmRecords=" + Arrays.toString(mRecords) + "\nmResults="
				+ mResults + "]";
	}

}
