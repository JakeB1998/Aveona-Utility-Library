/*
 * File name:  Savable.java
 *
 * Programmer : Jake Botka
 *
 * Date: Aug 3, 2020
 *
 */
package main.org.botka.utility.api.data.save;

import java.io.File;
import java.io.Serializable;

import main.org.botka.utility.api.data.serialization.Serialization;
import main.org.botka.utility.api.data.serialization.Serializer;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public interface Savable<T extends Serializable> {
	public default byte[] getSerializedObject() {
		Object obj = this.getObject();
		return Serialization.serailizeObject(obj);
		
	}
	
	T getObject();

}
