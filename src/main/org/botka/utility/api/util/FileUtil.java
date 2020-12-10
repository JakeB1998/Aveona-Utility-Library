/**
 * FileUtil.java
 * Programmer: Jake Botka
 * Nov 14, 2020
 *
 */
package main.org.botka.utility.api.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.jdt.annotation.NonNull;

import main.org.botka.utility.api.exceptions.IllegalNullArguementException;

/**
 * Utility class for File operations
 * @author Jake Botka
 *
 */
public class FileUtil {

	public static File findOrCreateDirectory(@NonNull File file) {
		Util.checkNullArgumentAndThrow(file, IllegalNullArguementException.formatEceptionMessage("file"));
		
		if (!file.isDirectory()) {
			if (file.mkdir()) {
				return file;
			}
		}
		else {
			return file;
		}
		
		return null;
	}
	/**
	 * 
	 * @param filePath
	 * @return Found file, if file not found then returns null;
	 *
	 */
	public static File findFile(@NonNull String filePath) {
		if (filePath == null) {
			throw new NullPointerException("The file path is null");
		}
		File file = new File(filePath);
		if (file.exists()) {
			return file;
		}
		return null;
	}
	
	/**
	 * Finds file. 
	 * If file was not found it create a new file with the path name provided.
	 * @param filePaString
	 * @return File, if error occurs then returns null;
	 *
	 */
	public static File findOrCreate(@NonNull String filePath) {
		File file = findFile(filePath);
		if (file == null) {
			file = new File(filePath);
			try {
				if (file.createNewFile()) {
					
					return file;
				}else {
					
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return file;
	}
	
	/**
	 * 
	 * @param file
	 * @return Null if no exstension was found.
	 */
	public static String getFileExt(File file) {
		if (!file.isDirectory()) {
			return file.getAbsolutePath().indexOf('.') != -1 
					? file.getAbsolutePath().substring(file.getAbsolutePath().indexOf('.')) : null;
		}
		return null;
	}
	
	/**
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	public static File moveTo(File source, File destination) {
		Util.checkNullArgumentAndThrow(source, IllegalNullArguementException.formatEceptionMessage("source"));
		Util.checkNullArgumentAndThrow(source, IllegalNullArguementException.formatEceptionMessage("destinationPath"));
		try {
			long fileLegth =source.length();
			byte[] fileData = Files.readAllBytes(source.toPath());
			File newFile = Paths.get(destination.getPath()).resolve(source.toPath().getFileName()).toFile();
			
			if (writeDataToFile(fileData, newFile)) {
				source.delete();
				return newFile;
			}
			return null;
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Moves the file to the destination path with the destination path becoming the new parent to the source file.
	 * Resolve its new path to its parent meaning if there is a file with that name it will put the source file as a child.
	 * @param source
	 * @param destinationPath
	 * @return
	 */
	public static File moveTo(@NonNull File source, @NonNull String destinationPath) {
		return moveTo(source, new File(destinationPath));
	}
	
	
	
	public static File moveTo(@NonNull String filePath, @NonNull String destinationPath) {
		return moveTo(new File(filePath), new File(destinationPath));
	}
	
	/**
	 * Writes data to file.
	 * @param data Data.
	 * @param file File.
	 * @return True if data was written to file. Otherwise false.
	 */
	public static boolean writeDataToFile(@NonNull byte[] data, @NonNull File file) throws FileNotFoundException {
		Util.checkNullArgumentAndThrow(data, IllegalNullArguementException.formatEceptionMessage("data"));
		Util.checkNullArgumentAndThrow(data, IllegalNullArguementException.formatEceptionMessage("file"));
		boolean errorFlag = false;
		if (!file.exists()) {
			try {
				if (!file.createNewFile()) {
					errorFlag = true;
				} 
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		if (!errorFlag) {
			FileOutputStream fileOut = null;
			ObjectOutputStream objOut = null;
			boolean closed = false;
			if (file.canWrite()) {
				try {
					fileOut = new FileOutputStream(file);
					objOut = new ObjectOutputStream(fileOut);
					objOut.write(data);
					objOut.flush();
					fileOut.close();
					closed = true;
					return true;
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (fileOut != null && closed == false) {
						try {
							fileOut.close();
						} catch (IOException e) {
							//empty
						}
					}
				}
			}
		}
		return false;
	}
}
