/**
 * CMDTests.java
 * Programmer: Jake Botka
 * Nov 16, 2020
 *
 */
package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.org.botka.utility.api.base.CMDInterface;

/**
 * @author Jake Botka
 *
 */
public class CMDTests {

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link main.org.botka.openjdk.api.addon.CMD#executeCommand(java.lang.String)}.
	 */
	@Test
	public void testExecuteCommandString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.org.botka.openjdk.api.addon.CMD#executeCommand(java.lang.Runtime, java.lang.String)}.
	 */
	@Test
	public void testExecuteCommandRuntimeString() {
		fail("Not yet implemented");
		
	}

	/**
	 * Test method for {@link main.org.botka.openjdk.api.addon.CMD#executeCommandForResult(java.lang.String)}.
	 */
	@Test
	public void testExecuteCommandForResultString() {
		String string = CMDInterface.executeCommandForResult("ping www.google.com");
		assertNotNull(string);
		System.out.println(String.valueOf(string));
	}

	/**
	 * Test method for {@link main.org.botka.openjdk.api.addon.CMD#executeCommandForResult(java.lang.Runtime, java.lang.String)}.
	 */
	@Test
	public void testExecuteCommandForResultRuntimeString() {
		String string = CMDInterface.executeCommandForResult(Runtime.getRuntime(), "ping www.google.com");
		assertNotNull(string);
		System.out.println(String.valueOf(string));
		
		this.netstatTest();
		assertNotNull(string);
		System.out.println(String.valueOf(string));
	}

	public void netstatTest() {

		try {
			System.out.println(CMDInterface.processExists("netstat -a"));
			Process netstatProc = CMDInterface.executeCommand("netstat -a");
			BufferedReader reader = new BufferedReader(new InputStreamReader(netstatProc.getInputStream()));
			String result = "";
		    String line = "";
		    int count = 0;
		    while ((line = reader.readLine()) != null) {
		    	result += "\n".concat(line);
		    	if (count >= 5) {
		    		System.out.println(result);
		    		result = "";
		    	}
		    	count = count < 5 ? count + 1 : 0;
		    	
		    }
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
