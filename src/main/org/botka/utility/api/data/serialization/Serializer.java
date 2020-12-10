/*
 * File name:  Serializer.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: May 24, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.data.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class Serializer {




	/**
	 * 
	 * @param data of object
	 * @return
	 */
	public static byte[] serailizeObject(Object obj) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		try {
			ObjectOutputStream out = new ObjectOutputStream(stream);
			out.writeObject(obj);
			return stream.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
