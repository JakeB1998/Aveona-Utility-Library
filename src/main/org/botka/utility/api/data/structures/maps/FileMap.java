/**
 * FileMap.java
 * Programmer: Jake Botka
 * Nov 19, 2020
 *
 */
package main.org.botka.utility.api.data.structures.maps;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import org.eclipse.jdt.annotation.NonNull;

import main.org.botka.utility.api.exceptions.NotImplementedYetException;
import main.org.botka.utility.api.util.Util;

/**
 * @author Jake Botka
 *
 */
public class FileMap<K>  {
	private Map <K,File> mFileMap;
	
	/**
	 * Default constructor.
	 */
	public FileMap() {
		this.mFileMap = new HashMap<>(0);
	}
	/**
	 *@param hashtable
	 */
	public FileMap(Map<K, File> map) {
		this.mFileMap = map;
	}
	
	/**
	 * Constructor. Fills map based on the supplied keys and files. Must be ordered to match.
	 * Index of key in key array mapped to the same index in the files array.
	 * @param keys Array of keys
	 * @param files Array of files
	 */
	public FileMap(@NonNull K[] keys, @NonNull File[] files) {
		Util.checkNullArgumentAndThrow(keys);
		Util.checkNullArgumentAndThrow(files);
		throw new NotImplementedYetException();
	}
	
	/**
	 * Constructor. Fills map based on the supplied keys and files. Must be ordered to match.
	 * Index of key in key list mapped to the same index in the files list
	 * @param keys Array of keys
	 * @param files Array of files.
	 */
	public FileMap(@NonNull List<K> keys, @NonNull List<File> files) {
		this((K[]) keys.toArray(), files.toArray(new File[0]));
	}
	
	public boolean putFile(@NonNull K key, @NonNull File file) {
		return this.addFile(key, file);
	}
	
	public boolean addFile(@NonNull K key, @NonNull File file) {
		Util.checkNullArgumentAndThrow(key);
		Util.checkNullArgumentAndThrow(file);
		
		return  this.mFileMap != null && this.mFileMap.size() >= 0 
				&& this.mFileMap.containsKey(key) == false 
				? this.mFileMap.put(key, file) == null : false;
	}
	

	/**
	 * Clears map.
	 * @see java.util.Map#clear()
	 */
	public void clearMap() {
		mFileMap.clear();
	}

	
	/**
	 * Find file based on key.
	 * @param key Key that is linked to file.
	 * @return Found File, if no file was found then returns null.
	 *
	 */
	public File findFile(K key) {
			return this.mFileMap != null && this.mFileMap.size() > 0 
					&& this.mFileMap.containsKey(key) ? this.mFileMap.get(key) : null;
	}

	/**
	 * Finds key that is linked to file.
	 * @param file The file.
	 * @return Key mapped to the provided file.
	 *
	 */
	public K findKey(@NonNull File file) {
		Util.checkNullArgumentAndThrow(file);
		return this.mFileMap != null && this.mFileMap.size() > 0
				&& this.mFileMap.containsValue(file) ? findKeyFromValue(this.mFileMap, file): null;
	}
	
	/**
	 * 
	 * @param <K>
	 * @param <V>
	 * @param map
	 * @param value
	 * @return
	 *
	 */
	private static <K, V> K findKeyFromValue(Map<K, V> map, Object value) {
        for(Map.Entry<K, V> entry : map.entrySet()){
            if( entry.getValue().equals(value) ){
                return entry.getKey();
            }
        }
        return null;
    }
	
	/**
	 * 
	 * @return True if syncronized, otherwise false.
	 *
	 */
	public boolean isSyncronized() {
		return false;
	}
	
	/**
	 * @param key
	 * @param value
	 * @return
	 * @see java.util.AbstractMap#remove(java.lang.Object, java.lang.Object)
	 */
	public boolean remove(Object key, Object value) {
		return mFileMap.remove(key, value);
	}

	/**
	 * @param key
	 * @return
	 * @see java.util.AbstractMap#remove(java.lang.Object)
	 */
	public File remove(Object key) {
		return mFileMap.remove(key);
	}

	/**
	 * @param key
	 * @param oldValue
	 * @param newValue
	 * @return
	 * @see java.util.AbstractMap#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	public boolean replace(K key, File oldValue, File newValue) {
		return mFileMap.replace(key, oldValue, newValue);
	}

	/**
	 * @param key
	 * @param value
	 * @return
	 * @see java.util.AbstractMap#replace(java.lang.Object, java.lang.Object)
	 */
	public File replaceFile(K key, File value) {
		return mFileMap.replace(key, value);
	}

	/**
	 * @param function
	 * @see java.util.AbstractMap#replaceAll(java.util.function.BiFunction)
	 */
	public void replaceAll(BiFunction<? super K, ? super File, ? extends File> function) {
		mFileMap.replaceAll(function);
	}

	/**
	 * @return
	 * @see java.util.AbstractMap#size()
	 */
	public int sizeOfMap() {
		return mFileMap.size();
	}

	public Map<K, File> getMap(){
		return this.mFileMap;
	}
	/**
	 * @return
	 * @see java.util.AbstractMap#toString()
	 */
	public String toString() {
		return mFileMap.toString();
	}

	
	
	
}
