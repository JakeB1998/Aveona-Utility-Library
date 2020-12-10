/**
 * CMDInterface.java
 * Programmer: Jake Botka
 * Nov 16, 2020
 *
 */
package main.org.botka.utility.api.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Class to interface with the CMD of the operating system.
 * This uses the Runtime class as well as the Proccess class.
 * @author Jake Botka
 *
 */
public class CMDInterface {

	/**
	 *
	 */
	private CMDInterface() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean processExists(String cmdCommand) {
		try {
			executeCommandForResult(cmdCommand);
		}
		catch (Exception e) {
			if (e instanceof IOException) {
				return false;
			}
		}
		return true;
	}

	public static Process executeCommand(String cmdCommand) throws IOException {
		return executeCommand(Runtime.getRuntime(), cmdCommand);
	}
	
	public static Process executeCommand( Runtime runtime, String cmdCommand) throws IOException {
		if (runtime == null) {
			runtime = Runtime.getRuntime();
		}
		
		return runtime.exec(cmdCommand);
		
	}
	
	/**
	 * @param cmdCommand
	 * @return Result of running the command in the CMD prompt.
	 *
	 */
	public static String executeCommandForResult(String cmdCommand) {
		return executeCommandForResult(Runtime.getRuntime(), cmdCommand);
		
	}
	
	/**
	 * 
	 * @param runtime
	 * @param cmdCommand
	 * @return Result of running the command in the CMD prompt.
	 *
	 */
	public static String executeCommandForResult(Runtime runtime, String cmdCommand) {
		Process process = null;
		try {
			process = runtime.exec(cmdCommand);
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String result = "";
		    String line = "";
		    try {
			    while ((line = reader.readLine()) != null) {
			        result += line;
			    }
			    return result;
		    } finally {
				if (reader != null) {
					reader.close();
				}
			}
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return null;
	}
	
	private static class ProccessKillerTimer {
		private Process mProcces;
		public ProccessKillerTimer(Process p) {
			this.mProcces = p;
			
		}
	}
}
