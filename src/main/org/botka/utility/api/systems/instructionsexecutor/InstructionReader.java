/**
 * InstructionReader.java
 * Programmer: Jake Botka
 * Nov 23, 2020
 *
 */
package main.org.botka.utility.api.systems.instructionsexecutor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import main.org.botka.utility.api.io.readers.FileReader;

/**
 * @author Jake Botka
 *
 */
public class InstructionReader extends FileReader {

	/**
	 *@param file
	 *@throws FileNotFoundException
	 */
	public InstructionReader(File file) throws FileNotFoundException {
		super(file);
		// TODO Auto-generated constructor stub
	}

	/**
	 *@param path
	 *@throws FileNotFoundException
	 */
	public InstructionReader(String path) throws FileNotFoundException {
		super(path);
		
	}
	
	public InstructionList readInstructions() {
		return null;
	}

}
