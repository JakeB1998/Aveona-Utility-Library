/**
 * SnapShot.java
 * Programmer: Jake Botka
 * Nov 16, 2020
 *
 */
package main.org.botka.utility.api.data.structures;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.management.RuntimeErrorException;

import main.org.botka.utility.api.base.DeepCloneInstance;

/**
 * Class that snapshots objects by deep-copy cloning objects into unlined new
 * instances and storing them in related Map data structure that can support
 * both Asynchronous data handling and synchronous data handling
 * 
 * @author Jake Botka
 *
 */
public class SnapShot<K extends Serializable, V extends Serializable> {

	public static final boolean DEFAULT_ASYNC_VALUE = false;

	private KeyDeepCloner<K> mKeyDeepCloner;
	private ValueDeepCloner<V> mValueDeepCloner;
	private K mLastCommittedKey;
	private Class<K> mKeyClass;
	private Class<V> mValueClass;
	private Class<? extends Map> mMapImplementingClass;
	private Map<K, V> mSnapshotMap;
	private boolean mAsync;

	/**
	 *
	 */
	public SnapShot() {
		this.mKeyDeepCloner = new KeyDeepCloner<K>();
		this.mValueDeepCloner = new ValueDeepCloner<V>();
		this.mLastCommittedKey = null;
		this.mKeyClass = null;
		this.mValueClass = null;
		this.mMapImplementingClass = null;
		this.mSnapshotMap = null;
	}

	/**
	 * @param class1
	 * @param objectClass
	 */
	public SnapShot(Class<K> keyClass, Class<V> valueClass) {
		this(keyClass, valueClass, DEFAULT_ASYNC_VALUE);

	}

	/**
	 * @param class1
	 * @param objectClass
	 * @param async
	 */
	public SnapShot(Class<K> keyClass, Class<V> valueClass, boolean async) {
		this();
		this.mKeyClass = keyClass;
		this.mValueClass = valueClass;
		this.mAsync = async;
		if (async) {
			this.mSnapshotMap = new Hashtable<>(0);
			this.mMapImplementingClass = Hashtable.class;
		} else {
			this.mSnapshotMap = new HashMap<>(0);
			this.mMapImplementingClass = HashMap.class;
		}
	}

	protected K deepCloneKey(K key) {
		return this.mKeyDeepCloner.deepCopyNewInstance(key);
	}

	protected V deepCloneValue(V value) {
		return this.mValueDeepCloner.deepCopyNewInstance(value);
	}

	/**
	 * Retrieves the snapshot copy of an object based on its linking key when the object was commited.
	 * @param key Snapshot key.
	 * @return Snapshot object, if key is not tied to object then returns null.
	 *
	 */
	public V retrieveSnapshot(K key) {
		if (this.mSnapshotMap != null) {
			return this.mSnapshotMap.containsKey(key) ? this.mSnapshotMap.get(key) : null;
		}
		return null;
		
	}
	public boolean commit(K key, V value) {
		if (this.mSnapshotMap == null) {
			throw new NullPointerException("Map is null. You can not set the map value to a null refrence. Fix now.");
		}
		if (!this.mSnapshotMap.containsKey(key)) {
			return this.mSnapshotMap.put(key, value).equals(value);
		} else {
			this.throwKeyAlreadyExists();
		}
		return false;
	}
	
	public void throwKeyAlreadyExists() {
		
	}

	/**
	 * @return the mLastCommitedKey
	 */
	public K getLastCommitedKey() {
		return mLastCommittedKey;
	}

	/**
	 * @return the mKeyClass
	 */
	public Class<K> getKeyClass() {
		return mKeyClass;
	}

	/**
	 * @param mKeyClass the mKeyClass to set
	 */
	public void setKeyClass(Class<K> keyClass) {
		this.mKeyClass = keyClass;
	}

	/**
	 * @return the mValueClass
	 */
	public Class<V> getValueClass() {
		return mValueClass;
	}

	/**
	 * @param mValueClass the mValueClass to set
	 */
	public void setValueClass(Class<V> valueClass) {
		this.mValueClass = valueClass;
	}

	/**
	 * Gets the implementing subclass to the map structure. This is either HashTable
	 * for Async settings or HashMap for Synch.
	 * 
	 * @return implementing subclass to the map structure. This is either HashTable
	 *         for Async settings or HashMap for Synch.
	 *
	 */
	public Class<? extends Map> getMapImplementingMap() {
		return this.mMapImplementingClass;
	}

	/**
	 * @return the mSnapshotMap
	 */
	public Map<K, V> getSnapshotMap() {
		return mSnapshotMap;
	}

	/**
	 * @param mSnapshotMap the mSnapshotMap to set
	 */
	public void setSnapshotMap(Map<K, V> snapshotMap) {
		this.mSnapshotMap = snapshotMap;
	}

	private static class KeyDeepCloner<K> implements DeepCloneInstance<K> {
		// default methods located in IDeepCLoneInstance.
	}

	private static class ValueDeepCloner<V> implements DeepCloneInstance<V> {
		// default methods located in IDeepCLoneInstance.
	}
}
