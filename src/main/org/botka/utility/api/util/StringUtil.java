/*
 * File name:  StringUtils.java
 *
 * Programmer : Jake Botka
 * ULID: JMBOTKA
 *
 * Date: Jun 13, 2020
 *
 * Out Of Class Personal Program
 */
package main.org.botka.utility.api.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;

import main.org.botka.utility.api.exceptions.IllegalNullArguementException;
import main.org.botka.utility.api.exceptions.NotImplementedYetException;

/**
 * <insert class description here>
 *
 * @author Jake Botka
 *
 */
public class StringUtil {
	
	public static String parseAfter(@NonNull String source ,@NonNull char[] afterSequence) {
		return parseBefore(source,  new String(afterSequence));
	}
	
	public static String parseAfter(@NonNull String source ,@NonNull char afterCharacter) {
		return parseAfter(source,  String.valueOf(afterCharacter));
	}
	
	public static String parseAfter(@NonNull String source,@NonNull String afterElement) {
		Util.checkNullArgumentAndThrow(source, IllegalNullArguementException.formatEceptionMessage("source"));
		Util.checkNullArgumentAndThrow(afterElement, IllegalNullArguementException.formatEceptionMessage("afterElement"));
		int index = source.indexOf(afterElement);
		if (index != -1 && index >= 0) {
			int offset = index  + afterElement.length();
			return offset < source.length() ? source.substring(offset) : null;
		}
		return null;
		
	}
	
	public static String parseBefore(@NonNull String source ,@NonNull char[] beforeSequence) {
		return parseBefore(source,  new String(beforeSequence));
	}
	public static String parseBefore(@NonNull String source ,@NonNull char beforeCharacter) {
		return parseBefore(source,  String.valueOf(beforeCharacter));
	}
	
	public static String parseBefore(@NonNull String source, @NonNull String beforeElement) {
		Util.checkNullArgumentAndThrow(source, IllegalNullArguementException.formatEceptionMessage("source"));
		Util.checkNullArgumentAndThrow(beforeElement, IllegalNullArguementException.formatEceptionMessage("beforeElement"));
		int index = source.indexOf(beforeElement);
		if (index != -1 && index > 0) {
			return source.substring(0,index);
		}
		return null;
	}
	
	public static String parseBetween(@NonNull String source, @NonNull char startCharacter, @NonNull char endCharacter) {
		return parseBetween(source, String.valueOf(startCharacter), String.valueOf(endCharacter));
	}
	
	public static String parseBetween(@NonNull String source, @NonNull String startBlock, @NonNull char endCharacter) {
		return parseBetween(source, startBlock, String.valueOf(endCharacter));
	}
	
	public static String parseBetween(@NonNull String source, @NonNull char startCharacter, @NonNull String endBlock) {
		return parseBetween(source, String.valueOf(startCharacter), endBlock);
	}
	
	public static String parseBetween(@NonNull String source,@NonNull String startBlock, @NonNull String endblock) {
		Util.checkNullArgumentAndThrow(source, IllegalNullArguementException.formatEceptionMessage("source"));
		Util.checkNullArgumentAndThrow(startBlock, IllegalNullArguementException.formatEceptionMessage("startBlock"));
		Util.checkNullArgumentAndThrow(startBlock, IllegalNullArguementException.formatEceptionMessage("endBlock"));
		String temp = source;
		int indexBefore = source.indexOf(startBlock);
		if (indexBefore != -1 && indexBefore >= 0) {
			temp = temp.substring(indexBefore + 1);
		} else {
			return null;
		}
		int indexAfter = temp.indexOf(endblock);
		if (indexAfter != -1 && indexAfter > 0) {
			return temp.substring(0,indexAfter);
		} else {
			
			return null; //means there isnt anything between the two block such as  this: ().
		}
		
	}
	
	
	
	/**
	 * Insert a string into specified str param
	 * 
	 * @param str
	 * @param insertIndex
	 * @return
	 */
	public static String insert(String str, String insertString, int insertIndex) throws Exception {
		if (insertIndex < str.length()) {
			String x = str.substring(0, insertIndex);
			x += insertString + str.substring(insertIndex);
			return x;
		} else {
			throw new Exception("insertIndex param is larger than the length of str param");
		}
	}
	
	public static String remove(int startIndex, int endIndex) {
		throw new NotImplementedYetException();
	}
	
	public static String remove(int startIndex) {
		throw new NotImplementedYetException();
	}

}
