/**
 * VersionSnapShot.java
 * Programmer: Jake Botka
 * Nov 16, 2020
 *
 */
package main.org.botka.utility.api.data.structures;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Class represents snapshoted data tied to version control.
 * Supports both async operations and data structures as well as synchronous.
 * Uses HashMap for synchronous operations and HashTable for asyncronous operations.
 * @author Jake Botka
 *
 */
public class VersionSnapShot<V extends Serializable> extends SnapShot<String, V>{
	
	public VersionSnapShot() {
		super();
	}
	
	/**
	 *
	 */
	public VersionSnapShot(Class<V> objectClass) {
		this(objectClass, DEFAULT_ASYNC_VALUE );
	}
	
	public VersionSnapShot(Class<V> objectClass, boolean async) {
		super(String.class,objectClass, async);
	}
	
	@Override
	public boolean commit(@NonNull String version,@NonNull V obj) {
		return super.commit(version, obj);
	}
	
	/**
	 * Checks if version already was snappshoted.
	 * @param version String vesion.
	 * @return True if version has already been snapshotted, otherwise false;
	 *
	 */
	public boolean isVersionSnapshotted(@NonNull String version) {
		if (version == null) {
			throw new IllegalArgumentException("Parameter provided is null.");
		}
		return super.getSnapshotMap().containsKey(version);
	}
	
	/**
	 * @throws RuntimeException Throws if key already exists in map. 
	 * Overriden from parent.
	 */
	@Override
	public void throwKeyAlreadyExists() {
		throw new RuntimeException("Version Already Exists");
	}
	
	/**
	 * Gets the last recorded version
	 * @return Last recorded version.
	 *
	 */
	public String getCurrentVersion() {
		return super.getLastCommitedKey();
	}

}
