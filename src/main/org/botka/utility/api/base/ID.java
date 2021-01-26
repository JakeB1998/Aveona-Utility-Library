/**
 * File Name: ID.java
 * Programmer: Jake Botka
 * Date Created: Jan 26, 2021
 *
 */
package main.org.botka.utility.api.base;

import java.io.Serializable;

/**
 * Allows for aggrogated id.
 * @author Jake Botka
 *
 */
public class ID implements Serializable{

	private String mID;
	private boolean mSecured, mImmutable;
	
	/**
	 * Constrcutor.
	 */
	public ID() {
		mID = null;
	}
	
	/**
	 * Constructor.
	 * @param id ID
	 */
	public ID(String id) {
		this();
		mID = id;
	}
	
	/**
	 * Constructor.
	 * @param id ID
	 * @param immutable Immutable
	 */
	public ID(String id, boolean immutable) {
		this(id);
		mImmutable = immutable;
	}
	
	/**
	 * Determines equaly by if the ID field of each object is equal.
	 * @param obj compared id
	 * @return True if equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof String) {
			String str = (String) obj;
			String original = getID();
			if (original != null && str != null) {
				return original.equals(str);
			}
		}
		return false;
	}
	
	/**
	 * Gets id.
	 * @return ID
	 */
	public String getID() {
		return mID;
	}

	
	
	/**
	 * Sets id. if immutably activated Id is only set if it  is already not been set. 
	 * if it is immuable and already set (not null) the new id will be ignored.
	 * @param newId
	 */
	public void setID(String newId) {
		if (mID != null) {
			if (!mImmutable) {
				mID = newId;
			}
		} else {
			mID = newId;
		}
	}
	
	/**
	 * 
	 * @return if immutable
	 */
	public boolean isImumtable() {
		return mImmutable;
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "ID [mID=" + mID + ", mSecured=" + mSecured + ", mImmutable=" + mImmutable + "]";
	}
	
}
